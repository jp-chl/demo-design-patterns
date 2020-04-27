package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.people.AgeComparator;
import com.jpvr.demodesignpatterns.generics.people.Person;
import com.jpvr.demodesignpatterns.generics.people.ReverseComparator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TheArrayProblemTests {

    @Test
    public void shouldGetCustomArrayListElements() {

        List arrayList = new CustomArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);

        System.out.println("arrayList(0) = " + arrayList.get(0));
        System.out.println("arrayList(1) = " + arrayList.get(1));
        System.out.println("arrayList(2) = " + arrayList.get(2));
    } // end void shouldGetCustomArrayListElements()


    @Test
    public void shouldSortListElements() {

        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<Person>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        //System.out.println(madMen);
        assertEquals(donDraper, madMen.get(0));
        assertEquals(peggyOlson, madMen.get(1));
        assertEquals(bertCooper, madMen.get(2));

        Collections.sort(madMen, new AgeComparator());
//        Collections.sort(madMen, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return Integer.compare(o1.getAge(), o2.getAge());
//            }
//        });
        System.out.println(madMen);

        assertEquals(peggyOlson, madMen.get(0));
        assertEquals(donDraper, madMen.get(1));
        assertEquals(bertCooper, madMen.get(2));

        //Collections.sort(madMen, new ReverseComparator<Person>(new AgeComparator()));
        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));

        System.out.println(madMen);
    } // end void shouldSortListElements()

    private Person[] add(Person person, Person[] personArray) {

        final int length = personArray.length;
        personArray = Arrays.copyOf(personArray, length + 1);

        personArray[length] = person;

        return personArray;
    } // end Person add(Person jp, Person[] madMen)

} // end class TheArrayProblemTests
