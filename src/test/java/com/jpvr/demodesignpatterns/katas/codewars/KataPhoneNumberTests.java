package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KataPhoneNumberTests {

    @Test
    public void testPhoneNumbers() {

        Assertions.assertEquals("(123) 456-7890",
                createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    } // end

    private String createPhoneNumber(int[] numbers) {
        // Your code here!
        String input = Arrays.toString(numbers).replace("[","")
                .replace("]","")
                .replace(",","")
                .replace(" ","");
        String output = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

        String output2 =
                Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .reduce((a,b) -> a.concat(b))
                .get();

        String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
        return output;
    } // end
} // end class KataPhoneNumberTests
