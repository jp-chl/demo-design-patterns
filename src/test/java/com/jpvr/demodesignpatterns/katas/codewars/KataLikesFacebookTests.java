package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class KataLikesFacebookTests {

    @Test
    public void staticTests() {
        Assertions.assertEquals("no one likes this", whoLikesIt());
        Assertions.assertEquals("Peter likes this", whoLikesIt("Peter"));
        Assertions.assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        Assertions.assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        Assertions.assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        Assertions.assertEquals("Alex, Jacob and 4 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max", "John", "Peter"));
    } // end staticTests

    private String whoLikesIt(String... names) {
        //Do your magic here

        switch(names.length) {

            case 0:
                return "no one likes this";
            case 1:
                return String.format("%s likes this", names[0]);
            case 2:
                return String.format("%s and %s like this", names[0], names[1]);
            case 3:
                return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default:
                return String.format("%s, %s and %d others like this", names[0], names[1], (names.length - 2));
        } // end switch
    } // end String whoLikesIt(String... names)

} // end KataLikesFacebookTests
