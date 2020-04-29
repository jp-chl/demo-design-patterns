package com.jpvr.demodesignpatterns.lambda.chain;

import com.jpvr.demodesignpatterns.lambda.chain.function.Consumer;
import com.jpvr.demodesignpatterns.lambda.chain.function.Function;
import com.jpvr.demodesignpatterns.lambda.chain.function.Predicate;
import com.jpvr.demodesignpatterns.lambda.chain.model.Meteo;
import com.jpvr.demodesignpatterns.lambda.chain.model.Person;
import com.jpvr.demodesignpatterns.lambda.chain.util.Comparator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;

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
    public void givenPersonObject_WhenUsingCustomComparator_ThenCompareByName() {

        final Person mary = new Person("Mary", 28);
        final Person john = new Person("John", 22);
        final Person linda = new Person("Linda", 26);
        final Person james = new Person("James", 32);

        // Simple inlining comparator
        Comparator<Person> cmpName1 = (p1, p2) -> {
            return p1.getName().compareTo(p2.getName());
        };

        assertTrue( (cmpName1.compare(mary, john)) > 0);
        assertTrue( (cmpName1.compare(john, james)) > 0);
        assertTrue( (cmpName1.compare(linda, john)) > 0);

        // Comparator using a function
        java.util.function.Function<Person, String> getName = p -> p.getName();

        Comparator<Person> cmpName2 = (p1, p2) -> {
            String name1 = getName.apply(p1);
            String name2 = getName.apply(p2);
            return name1.compareTo(name2);
        };

        assertTrue( (cmpName2.compare(mary, john)) > 0);
        assertTrue( (cmpName2.compare(john, james)) > 0);
        assertTrue( (cmpName2.compare(linda, john)) > 0);

        // Comparator by using a generic static function
        Assertions.assertThrows(NullPointerException.class, () -> {
            Comparator.comparing(null);
        });

        Comparator<Person> cmpName3 = Comparator.comparing(getName);

        assertTrue( (cmpName3.compare(mary, john)) > 0);
        assertTrue( (cmpName3.compare(john, james)) > 0);
        assertTrue( (cmpName3.compare(linda, john)) > 0);

        // New Comparator
        Comparator<Person> cmpNameReversed = cmpName3.reversed();

        assertFalse( (cmpNameReversed.compare(mary, john)) > 0);
        assertFalse( (cmpNameReversed.compare(john, james)) > 0);
        assertFalse( (cmpNameReversed.compare(linda, john)) > 0);

    } // end void chainingComparatorTests()

    @Test
    public void givenPersonObject_WhenUsingCustomComparator_ThenCompareByAge() {

        final Person mary = new Person("Mary", 28);
        final Person john = new Person("John", 22);
        final Person linda = new Person("Linda", 26);
        final Person james = new Person("James", 32);

        //final java.util.function.Function<Person, Integer> getAge = p -> p.getAge();
        final java.util.function.Function<Person, Integer> getAge = Person::getAge;

        Comparator<Person> cmpAge = Comparator.comparing(getAge);

        assertTrue( (cmpAge.compare(mary, john) > 0) );
        assertFalse((cmpAge.compare(john, james) > 0));
        assertTrue( (cmpAge.compare(linda, john) > 0));
    } // end void givenPersonObject_WhenUsingCustomComparator_ThenCompareByAge()

    @Test
    public void givenPersonObject_WhenCombiningCustomComparator_ThenCompareByNameAndAge() {

        final java.util.function.Function<Person, String> getName = Person::getName;
        final java.util.function.Function<Person, Integer> getAge = Person::getAge;

        final Comparator<Person> cmpName = Comparator.comparing(getName);
        final Comparator<Person> cmpAge  = Comparator.comparing(getAge);

        // Combining comparators
        final Comparator<Person> cmp = cmpName.thenComparing(cmpAge);

        Assertions.assertThrows(NullPointerException.class, () -> {
            cmpName.thenComparing(null);
        });

        Person person1 = new Person("name", 22);
        Person person2 = new Person("name", 23);
        assertTrue( cmp.compare(person1, person2) < 0);

        person2.setAge(22);
        assertEquals(0, cmp.compare(person1, person2));
        assertEquals(person1.getName(), person2.getName());

        assertEquals(person1.getAge(), person2.getAge());
        person1.setName("tony"); // person2.getName() == "name"
        assertTrue( cmp.compare(person1, person2) > 0);

    } // end void givenPersonObject_WhenCombiningCustomComparator_ThenCompareByNameAndAge()
} // end class ChainingTests









































