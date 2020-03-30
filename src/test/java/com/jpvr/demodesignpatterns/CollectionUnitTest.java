package com.jpvr.demodesignpatterns;

import com.jpvr.demodesignpatterns.collections.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CollectionUnitTest {

    private Country sACountry1, sACountry2, sACountry3, sACountry4;
    private Country nACountry1, nACountry2, nACountry3;
    private int expectedSaPopulation, expectedNaPopulation;

    private final String SOUTHAMERICACONTINENT = "SA";
    private final String NORTHAMERICACONTINENT = "NA";

    @BeforeAll
    public void setUp() {

        sACountry1 = new Country("chile", 1000, SOUTHAMERICACONTINENT);
        sACountry2 = new Country("argentina", 5000, SOUTHAMERICACONTINENT);
        sACountry3 = new Country("brazil", 200000, SOUTHAMERICACONTINENT);
        sACountry4 = new Country("colombia", 2000, "another continent");

        nACountry1 = new Country("usa", 400000, NORTHAMERICACONTINENT);
        nACountry2 = new Country("canada", 300000, NORTHAMERICACONTINENT);
        nACountry3 = new Country("mexico", 200000, NORTHAMERICACONTINENT);

        expectedSaPopulation = 0;
        expectedSaPopulation += sACountry1.getPopulation();
        expectedSaPopulation += sACountry2.getPopulation();
        expectedSaPopulation += sACountry3.getPopulation();
        //expectedSaPopulation += sACountry4.getPopulation();

        expectedNaPopulation = 0;
        expectedNaPopulation += nACountry1.getPopulation();
        expectedNaPopulation += nACountry2.getPopulation();
        expectedNaPopulation += nACountry3.getPopulation();
    } // end void setUp()

    @Test
    public void shouldMapAndConcatenate() {

        final String[] myArray = {"this", "is", "a", "sentence"};

        final String expectedOutput = "thisisasentence";

//        long init = System.currentTimeMillis();
//        System.out.println("t0: ("+init+")");
        String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a+b );
//        long delta = System.currentTimeMillis() - init;
//        System.out.println("t1: ("+delta+")");

        Assertions.assertEquals(expectedOutput, result);

//        init = System.currentTimeMillis();
//        System.out.println("t0: ("+init+")");
        String result2 = Arrays.stream(myArray)
                .reduce("", String::concat);
//        delta = System.currentTimeMillis() - init;
//        System.out.println("t1: ("+delta+")");

        Assertions.assertEquals(expectedOutput, result2);
    } // fin void shouldMapAndConcatenate()

    @Test
    public void shouldCountPopulationFromContinent_withoutLambda() {

        int sAPopulation = getPopulationWithoutLambda(
                Arrays.asList(sACountry1, sACountry2, sACountry3, sACountry4),
                SOUTHAMERICACONTINENT);
        Assertions.assertEquals(expectedSaPopulation, sAPopulation);

        int nAPopulation = getPopulationWithoutLambda(
                Arrays.asList(nACountry1, nACountry2, nACountry3),
                NORTHAMERICACONTINENT);
        Assertions.assertEquals(expectedNaPopulation, nAPopulation);
    } // end void shouldCountPopulationFromContinent_withoutLambda()

    @Test
    public void shouldCountPopulationFromContinent_withLambda() {

        int sAPopulation = getPopulationWithLambda(
                Arrays.asList(sACountry1, sACountry2, sACountry3, sACountry4),
                SOUTHAMERICACONTINENT);
        Assertions.assertEquals(expectedSaPopulation, sAPopulation);

        int nAPopulation = getPopulationWithLambda(
                Arrays.asList(nACountry1, nACountry2, nACountry3),
                NORTHAMERICACONTINENT);
        Assertions.assertEquals(expectedNaPopulation, nAPopulation);
    } // end void shouldCountPopulationFromContinent_withoutLambda()

    @Test
    public void shouldCountPopulationFromContinent_withCollectors() {

        int sAPopulation = getPopulationWithCollectors(
                Arrays.asList(sACountry1, sACountry2, sACountry3, sACountry4),
                SOUTHAMERICACONTINENT);
        Assertions.assertEquals(expectedSaPopulation, sAPopulation);

        int nAPopulation = getPopulationWithCollectors(
                Arrays.asList(nACountry1, nACountry2, nACountry3),
                NORTHAMERICACONTINENT);
        Assertions.assertEquals(expectedNaPopulation, nAPopulation);
    } // end void shouldCountPopulationFromContinent_withCollectors()

    private int getPopulationWithoutLambda(List<Country> countries, String continent) {

        int sum = 0;
        for(Country c : countries) {

            if (c.getContinent().equals(continent)) {
                sum += c.getPopulation();
            }
        } // end for (Country c : countries)

        return sum;
    } // end int getPopulationWithoutLambda(List<Country> countries, String continent)

    private int getPopulationWithLambda(List<Country> countries, String continent) {

        // filter countries
        Stream<Country> countriesSublist = countries.stream().filter(
                country -> {
                    return country.getContinent().equals(continent);
                }
        );//.peek(System.out::println);

        // convert to list of populations
        Stream<Integer> continentPopulation = countriesSublist.map(
                c -> c.getPopulation()
        );//.peek(System.out::println);

        // sum list
        final int population = continentPopulation.reduce(
                0, (a,b) -> a+b
        );

        return population;
    } // end int getPopulationWithLambda(List<Country> countries, String continent)

    private int getPopulationWithCollectors(List<Country> countries, String continent) {

        Collector<Country, ?, Integer> totalPopulation
                = Collectors.summingInt(Country::getPopulation);

        Predicate<Country> filteredCountries = country -> {
            return new Country(country).getContinent().equals(continent);
        };

        Map<String, Integer> populationByContinent
                = countries.stream()
                .filter(filteredCountries)
                .collect(Collectors.groupingBy(Country::getContinent,
                        totalPopulation));

        return populationByContinent.values().stream().reduce(0, Integer::sum);
    } // fin int getPopulationWithCollectors(List<Country> countries, String continent)
} // end class CollectionUnitTest
