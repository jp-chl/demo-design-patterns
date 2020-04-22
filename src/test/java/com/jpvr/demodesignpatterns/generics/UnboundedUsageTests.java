package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.people.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UnboundedUsageTests {

    @Test
    public void test() {

//        Object[] array = new Person[1];
//        array[0] = new Person("Don Draper", 89);
//        array[0] = new Object(); // java.lang.ArrayStoreException

        //List<?> objects = new ArrayList<>();
        //objects.add(new Object()); // error
        //objects.add(null); // allowed

        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Person("Don Draper", 89));

        System.out.println("objects = " + objects);
    }
} // end class UnboundedUsageTests
