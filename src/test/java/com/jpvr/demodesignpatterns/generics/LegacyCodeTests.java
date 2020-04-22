package com.jpvr.demodesignpatterns.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCodeTests {

    @Test
    public void test() {

        // raw type
        List list = new ArrayList();
        // equivalent to
        //List<Object> list = new ArrayList();

        list.add("abc");
        list.add(1);
        list.add(new Object());

        Iterator iterator = list.iterator();

        while ( iterator.hasNext() ) {
            final Object element = iterator.next();
            System.out.println("element = " + element);
        }
    } // end
} // end class LegacyCodeTests
