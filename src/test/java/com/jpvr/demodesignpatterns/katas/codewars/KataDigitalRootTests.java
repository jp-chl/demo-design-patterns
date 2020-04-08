package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataDigitalRootTests {

    @Test
    public void testDigitalRoots() {

        long start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root2(25));
        Assertions.assertEquals(7, digital_root2(16));
        Assertions.assertEquals(6, digital_root2(456));
        Assertions.assertEquals(6, digital_root2(942));
        Assertions.assertEquals(6, digital_root2(132189));
        Assertions.assertEquals(2, digital_root2(493193));
        Assertions.assertEquals(2, digital_root2(65785412));
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Metodo 1: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root(25));
        Assertions.assertEquals(7, digital_root(16));
        Assertions.assertEquals(6, digital_root(456));
        Assertions.assertEquals(6, digital_root(942));
        Assertions.assertEquals(6, digital_root(132189));
        Assertions.assertEquals(2, digital_root(493193));
        Assertions.assertEquals(2, digital_root(65785412));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 2: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root3(25));
        Assertions.assertEquals(7, digital_root3(16));
        Assertions.assertEquals(6, digital_root3(456));
        Assertions.assertEquals(6, digital_root3(942));
        Assertions.assertEquals(6, digital_root3(132189));
        Assertions.assertEquals(2, digital_root3(493193));
        Assertions.assertEquals(2, digital_root3(65785412));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 3: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root4(25));
        Assertions.assertEquals(7, digital_root4(16));
        Assertions.assertEquals(6, digital_root4(456));
        Assertions.assertEquals(6, digital_root4(942));
        Assertions.assertEquals(6, digital_root4(132189));
        Assertions.assertEquals(2, digital_root4(493193));
        Assertions.assertEquals(2, digital_root4(65785412));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 4: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root5(25));
        Assertions.assertEquals(7, digital_root5(16));
        Assertions.assertEquals(6, digital_root5(456));
        Assertions.assertEquals(6, digital_root5(942));
        Assertions.assertEquals(6, digital_root5(132189));
        Assertions.assertEquals(2, digital_root5(493193));
        Assertions.assertEquals(2, digital_root5(65785412));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 5: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root6(25));
        Assertions.assertEquals(7, digital_root6(16));
        Assertions.assertEquals(6, digital_root6(456));
        Assertions.assertEquals(6, digital_root6(942));
        Assertions.assertEquals(6, digital_root6(132189));
        Assertions.assertEquals(2, digital_root6(493193));
        Assertions.assertEquals(2, digital_root6(65785412));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 6: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(7, digital_root7(25));
        Assertions.assertEquals(7, digital_root7(16));
        Assertions.assertEquals(6, digital_root7(456));
        Assertions.assertEquals(6, digital_root7(942));
        Assertions.assertEquals(6, digital_root7(132189));
        Assertions.assertEquals(2, digital_root7(493193));
        Assertions.assertEquals(2, digital_root7(65785412));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 7: " + diff);

    } // end void testDigitalRoots()

    private int digital_root(int n) {

        int number = n;
        int result = 0;

        while(number > 0) {
            result += number % 10;
            number /= 10;
        }

        if (result > 9) {
            result = digital_root(result);
        }

        return result;

//        int number = n;
//
//        while(number > 9) {
//            number = number/10 + number%10;
//        }
//
//        return number;

//        while(n > 9) {
//            n = n/10 + n%10;
//        }
//
//        return n;
    } // end int digitalRootRecursive(int n)

    private int digital_root2(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }

    private int digital_root3(int n) {
        while(n > 9){
            n = n/10 + n % 10;
        }
        return(n);
    }

    private int digital_root4(int n) {
        return n < 10 ? n : digital_root(digital_root(n/10)+n%10);
    }

    private int digital_root5(int n) {
        return (1 + (n - 1) % 9);
    }

    private int digital_root6(int n) {
        final int result = String.valueOf(n).chars().reduce(0, (acc, curr) -> acc + (curr - '0'));
        return result < 10 ? result : digital_root(result);
    }

    private int digital_root7(int n) {
        return --n % 9 + 1;
    }

} // end class KataDigitalRootTests
