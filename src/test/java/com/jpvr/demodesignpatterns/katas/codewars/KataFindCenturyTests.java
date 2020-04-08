package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataFindCenturyTests {

    @Test
    public void centuryTests() {

        Assertions.assertEquals(18, century(1705));
        Assertions.assertEquals(19, century(1900));
        Assertions.assertEquals(17, century(1601));
        Assertions.assertEquals(20, century(2000));
        Assertions.assertEquals(1,  century(89));
    } // end centuryTests

    private int century(int number) {

        int result = (number+99) / 100;
        return result;
    }

    private int century2(int number) {
        // your code goes here

        final double doubleNumber = (double) number / 100;
        final int intNumber = (int)doubleNumber;

        int result = intNumber;

        if (doubleNumber - intNumber > 0) {
            result += 1;
        }

        return result;
    } // end int century(int number) {
} // end class KataFindCenturyTests
