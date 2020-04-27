package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataMiddleExampleTests {

    @Test
    public void tests() {

        long start = System.currentTimeMillis();
//        Assertions.assertEquals("", getMiddle3(""));
//        Assertions.assertEquals(" ", getMiddle3(" "));
//        Assertions.assertEquals("  ", getMiddle3("  "));
        // even
        Assertions.assertEquals("es", getMiddle("test"));
        Assertions.assertEquals("dd", getMiddle("middle"));
        Assertions.assertEquals("fg", getMiddle("abcdefghijkl"));
        // odds
        Assertions.assertEquals("t", getMiddle("testing"));
        Assertions.assertEquals("A", getMiddle("A"));
        Assertions.assertEquals("e", getMiddle("Abcdefghi"));
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Method 1: " + diff);

        start = System.currentTimeMillis();
//        Assertions.assertEquals("", getMiddle(""));
//        Assertions.assertEquals(" ", getMiddle(" "));
//        Assertions.assertEquals("  ", getMiddle("  "));
        // even
        Assertions.assertEquals("es", getMiddle3("test"));
        Assertions.assertEquals("dd", getMiddle3("middle"));
        Assertions.assertEquals("fg", getMiddle3("abcdefghijkl"));
        // odds
        Assertions.assertEquals("t", getMiddle3("testing"));
        Assertions.assertEquals("A", getMiddle3("A"));
        Assertions.assertEquals("e", getMiddle3("Abcdefghi"));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 2: " + diff);

    } // end tests()

    private String getMiddle(String word) {
        //Code goes here!
        if (word.length()==0) return "";

        final int wordLength = word.length();

        return ((wordLength % 2) == 0)
                ? (word.substring((wordLength/2) - 1, (wordLength/2) + 1))
                : ("" + word.charAt(wordLength/2)) ;
    } // end String getMiddle(String word)

    private String getMiddle2(String word) {
        //Code goes here!

        if (word.length()==0) return "";

        final int wordLength = word.length();
        boolean isOdd = (wordLength % 2) == 0;

        String middleWord = "";

        if ( isOdd ) {

            final int oddMiddleWordPosition = (wordLength/2) - 1;
            final String oddSubstring = word.substring(oddMiddleWordPosition, oddMiddleWordPosition+2);
            middleWord = oddSubstring;
        } else {

            final int evenMiddleWordPosition = (wordLength/2);
            final String evenSubstring = ""+word.charAt(evenMiddleWordPosition);
            middleWord = evenSubstring;
        }

        return middleWord;
    } // end String getMiddle(String word)

    private String getMiddle3(String word) {
        int l = word.length();
        int mid = l >> 1;
        return (mid > 0 && l%2 == 0) ? word.substring(mid-1, mid+1) : word.substring(mid, mid+1);
    }
} // fin class KataMiddleExampleTests
