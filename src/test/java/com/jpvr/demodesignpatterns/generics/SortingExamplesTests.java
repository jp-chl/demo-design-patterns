package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.people.AgeComparator;
import com.jpvr.demodesignpatterns.generics.people.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortingExamplesTests {

    @Test
    public void shouldCalculateMinimumElement() {

        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<Person>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        Person youngest = min(madMen, new AgeComparator());

        assertEquals(peggyOlson, youngest);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Integer lowest = min(numbers, Integer::compare);
        assertEquals(new Integer(1), lowest);

    } // end void shouldCalculateMinimumElement()

    public <T> T min(List<T> values, Comparator<T> comparator) {

        if ( values.isEmpty() ) {
            throw new IllegalArgumentException("empty list");
        }

        T lowestElement = values.get(0);

        for(int i=1; i<values.size(); i++) {

            final T element = values.get(i);

            if ( comparator.compare(element, lowestElement) < 0 ) {
                lowestElement = element;
            }
        } // end iteration

        return lowestElement;
    } // end Object min(List values, Comparator comparator)
} // end class SortingExamplesTests
