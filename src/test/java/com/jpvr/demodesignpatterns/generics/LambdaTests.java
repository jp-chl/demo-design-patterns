package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.people.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LambdaTests {

    Person donDraper = new Person("Don Draper", 89);
    Person peggyOlson = new Person("Peggy Olson", 65);
    Person bertCooper = new Person("Bert Cooper", 100);

    @Test
    public void shouldVerifyOldPeople() {

        Predicate<Person> isOld = person -> person.getAge() > 80;
        assertTrue(isOld.test(donDraper));
        assertFalse(isOld.test(peggyOlson));

        List<Person> people = new ArrayList<>();
        people.add(donDraper);
        people.add(peggyOlson);
        people.add(bertCooper);

        final Map<Boolean, List<Person>> oldAndYoungPeople =
                people.stream().collect(Collectors.partitioningBy(isOld));

        final Map<Boolean, Long> countOfOldAndYoungPeople =
                people.stream().collect(Collectors.partitioningBy(isOld, Collectors.counting()));
        System.out.println("countOfOldAndYoungPeople = " + countOfOldAndYoungPeople);

    } // end void shouldVerifyOldPeople()

} // end class LambdaTests
