package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KataBinaryArrayToNumberTests {

    @Test
    public void convertBinaryArrayToInt() throws Exception {

        final List<Integer> binary1 = new ArrayList<>(Arrays.asList(0,0,0,1));
        final List<Integer> binary2 = new ArrayList<>(Arrays.asList(1,0,0,0));
        final List<Integer> binary3 = new ArrayList<>(Arrays.asList(1,1,1,1));
        final List<Integer> binary4 = new ArrayList<>(Arrays.asList(0,1,1,1));
        final List<Integer> binary5 = new ArrayList<>(Arrays.asList(1,0,0,1));

        long start = System.currentTimeMillis();
            int decimal1 = ConvertBinaryArrayToInt(binary1);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Method 1: " + diff);

        start = System.currentTimeMillis();
            decimal1 = ConvertBinaryArrayToInt2(binary1);
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Method 2: " + diff);

        start = System.currentTimeMillis();
            decimal1 = ConvertBinaryArrayToInt3(binary1);
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Method 3: " + diff);

        boolean valid = (1 == ConvertBinaryArrayToInt(binary1));
        valid = (8 == ConvertBinaryArrayToInt(binary2));
        valid = (15 == ConvertBinaryArrayToInt(binary3));
        valid = (7 == ConvertBinaryArrayToInt(binary4));
        valid = (9 == ConvertBinaryArrayToInt(binary5));

        valid = (1 == ConvertBinaryArrayToInt2(binary1));
        valid = (8 == ConvertBinaryArrayToInt2(binary2));
        valid = (15 == ConvertBinaryArrayToInt2(binary3));
        valid = (7 == ConvertBinaryArrayToInt2(binary4));
        valid = (9 == ConvertBinaryArrayToInt2(binary5));

        valid = (1 == ConvertBinaryArrayToInt3(binary1));
        valid = (8 == ConvertBinaryArrayToInt3(binary2));
        valid = (15 == ConvertBinaryArrayToInt3(binary3));
        valid = (7 == ConvertBinaryArrayToInt3(binary4));
        valid = (9 == ConvertBinaryArrayToInt3(binary5));

        Assertions.assertEquals(1, ConvertBinaryArrayToInt(binary1));
        Assertions.assertEquals(8, ConvertBinaryArrayToInt(binary2));
        Assertions.assertEquals(15, ConvertBinaryArrayToInt(binary3));
        Assertions.assertEquals(7, ConvertBinaryArrayToInt(binary4));
        Assertions.assertEquals(9, ConvertBinaryArrayToInt(binary5));

        Assertions.assertEquals(1, ConvertBinaryArrayToInt2(binary1));
        Assertions.assertEquals(8, ConvertBinaryArrayToInt2(binary2));
        Assertions.assertEquals(15, ConvertBinaryArrayToInt2(binary3));
        Assertions.assertEquals(7, ConvertBinaryArrayToInt2(binary4));
        Assertions.assertEquals(9, ConvertBinaryArrayToInt2(binary5));

        Assertions.assertEquals(1, ConvertBinaryArrayToInt3(binary1));
        Assertions.assertEquals(8, ConvertBinaryArrayToInt3(binary2));
        Assertions.assertEquals(15, ConvertBinaryArrayToInt3(binary3));
        Assertions.assertEquals(7, ConvertBinaryArrayToInt3(binary4));
        Assertions.assertEquals(9, ConvertBinaryArrayToInt3(binary5));
    } // end void convertBinaryArrayToInt()

    private int ConvertBinaryArrayToInt(List<Integer> binary) {

        int number = 0;
        for (int bit : binary)
            number = number << 1 | bit;
        return number;
    }

    private int ConvertBinaryArrayToInt2(List<Integer> binary) {

        int power = binary.size() - 1;
        int numberAsDecimal = 0;

        for(int digit : binary) {

            numberAsDecimal += digit * Math.pow(2, power--);
        } // end for

        return numberAsDecimal;

    } // fin int ConvertBinaryArrayToInt(List<Integer> binary)

    private int ConvertBinaryArrayToInt3(List<Integer> binary) {

        int result = IntStream.range(0, binary.size()).map(i -> binary.get(binary.size()-1-i) * (int)Math.pow(2, i)).sum();

        return binary
                .stream()
                .reduce((x, y) -> x * 2 + y)
                .get();
    }
} // end class KataBinaryArrayToNumberTests
