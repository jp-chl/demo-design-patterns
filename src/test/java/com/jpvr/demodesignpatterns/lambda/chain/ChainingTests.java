package com.jpvr.demodesignpatterns.lambda.chain;

import com.jpvr.demodesignpatterns.lambda.chain.function.Consumer;
import com.jpvr.demodesignpatterns.lambda.chain.function.Function;
import com.jpvr.demodesignpatterns.lambda.chain.function.Predicate;
import com.jpvr.demodesignpatterns.lambda.chain.model.Meteo;
import com.jpvr.demodesignpatterns.lambda.chain.model.Person;
import com.jpvr.demodesignpatterns.lambda.chain.util.Comparator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions;

public class ChainingTests {

    @Test
    public void chainingConsumerTests() {

        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);
        //c1.accept("Hello");

        Consumer<String> c3 = s -> {

            c1.accept(s);
            c2.accept(s);
        };
        //c3.accept("Hello");

        Assertions.assertThrows(NullPointerException.class, () -> {
            c1.andThen(null);
        });

        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("Hello");
    } // end void chainingConsumerTests()

    @Test
    public void chainingPredicateTests() {

        Predicate<String> p1 = s -> s!=null;
        Predicate<String> p2 = s -> !s.isEmpty();

        Predicate<String> p3 = p1.and(p2);

        assertFalse( p3.test(null) );
        assertFalse( p3.test("") );
        assertTrue ( p3.test("Hello") );

        Predicate<String> p4 = p1.and(p2.negate());

        assertTrue ( p4.test("") );
        assertFalse( p4.test("Hello") );
    } // end void chainingPredicateTests()

    @Test
    public void chainingFunctionTests() {

        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32d;
        Function<Meteo, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);

        Assertions.assertThrows(NullPointerException.class, () -> {
            readFahrenheit.apply(null);
        });

        assertEquals( new Double(68.0), readFahrenheit.apply(new Meteo(20)));
        assertEquals( new Double(32), readFahrenheit.apply(new Meteo(0)));
        assertEquals( new Double(100.4), readFahrenheit.apply(new Meteo(38)));
    } // end void chainingFunctionTests()

    @Test
    public void chainingCompositionFunctionTests() {

        Function<Meteo, Integer> readCelsius = Meteo::getTemperature;
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32d;

        Function<Meteo, Double> readFahrenheit = celsiusToFahrenheit.compose(readCelsius);

        Assertions.assertThrows(NullPointerException.class, () -> {
            readFahrenheit.apply(null);
        });

        assertEquals( new Double(68.0), readFahrenheit.apply(new Meteo(20)));
        assertEquals( new Double(32), readFahrenheit.apply(new Meteo(0)));
        assertEquals( new Double(100.4), readFahrenheit.apply(new Meteo(38)));
    } // end void chainingCompositionFunctionTests()

    @Test
    public void chainingIdentityFunctionTests() {

        Function<String, String> identity1 = s -> s;
        Function<String, String> identity2 = Function.identity();
    } // end void chainingIdentityFunctionTests()

    @Test
    public void chainingComparatorTests() {

        final Person mary = new Person("Mary", 28);
        final Person john = new Person("John", 22);
        final Person linda = new Person("Linda", 26);
        final Person james = new Person("James", 32);

        Comparator<Person> cmpName1 = (p1, p2) -> {
            return p1.getName().compareTo(p2.getName());
        };

        assertTrue( (cmpName1.compare(mary, john)) > 0);
        assertTrue( (cmpName1.compare(john, james)) > 0);
        assertTrue( (cmpName1.compare(linda, john)) > 0);


        java.util.function.Function<Person, String> getName = p -> p.getName();

        Comparator<Person> cmpName2 = (p1, p2) -> {
            String name1 = getName.apply(p1);
            String name2 = getName.apply(p2);
            return name1.compareTo(name2);
        };

        assertTrue( (cmpName2.compare(mary, john)) > 0);
        assertTrue( (cmpName2.compare(john, james)) > 0);
        assertTrue( (cmpName2.compare(linda, john)) > 0);

        Comparator<Person> cmpName3 = Comparator.comparing(getName);

        assertTrue( (cmpName3.compare(mary, john)) > 0);
        assertTrue( (cmpName3.compare(john, james)) > 0);
        assertTrue( (cmpName3.compare(linda, john)) > 0);

    } // end void chainingComparatorTests()
} // end class ChainingTests
