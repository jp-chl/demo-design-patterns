package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class KataPerfectPowerTests {

    //@Test
    public void testUpTo500() {
        int[] pp = {4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216, 225, 243, 256, 289, 324, 343, 361, 400, 441, 484};
        for (int i: pp) {
            Assertions.assertNotNull(isPerfectPower(i), i+" is a perfect power");
        }
    }

    public static int[] isPerfectPower(int n) {
        // ...
        return null;
    }

    @Test
    public void testPrimes() {

        Assertions.assertEquals(true, isPrime(2));
        Assertions.assertEquals(false, isPrime(4));
        Assertions.assertEquals(true, isPrime(5));
        Assertions.assertEquals(true, isPrime(7));
        Assertions.assertEquals(false, isPrime(9));
        Assertions.assertEquals(true, isPrime(11));
        Assertions.assertEquals(false, isPrime(12));
        Assertions.assertEquals(false, isPrime(15));
    } // end testPrimes()

    private boolean isPrime(int number) {

        int squared = (int) Math.sqrt(number);
        System.out.println("Number: " + number);
        IntStream.rangeClosed(2, squared).forEach(System.out::println);
        System.out.println("------------------\n");

        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    } // end
} // end class KataPerfectPowerTests
