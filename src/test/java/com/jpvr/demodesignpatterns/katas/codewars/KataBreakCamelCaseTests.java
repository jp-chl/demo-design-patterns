package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataBreakCamelCaseTests {

    @Test
    public void stringStreamTests() {

        String s = "Techie Delight";
        int counter = 0;

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .mapToObj(Character::toChars)
                .forEach(System.out::print);

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .mapToObj(i -> new Character((char) i))
                .forEach(System.out::print);

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .mapToObj(i -> Character.valueOf((char) i))
                .forEach(System.out::print);

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .mapToObj(i -> (char) i)
                .forEach(System.out::print);

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .mapToObj(i -> new StringBuilder().appendCodePoint(i))
                .forEach(System.out::print);

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .forEach(i -> System.out.print(new Character((char) i)));

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .forEach(i -> System.out.print(Character.toChars(i)));

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .forEach(i-> System.out.print((char) i));

        System.out.println(String.format("Example %d\n", ++counter));
        s.chars()
                .forEach(i -> System.out.print(new StringBuilder()
                                                    .appendCodePoint(i)));
    } // end void stringStreamTests()

    @Test
    public void tests() {
        Assertions.assertEquals( "Incorrect", "camel Casing", camelCase("camelCasing"));
        Assertions.assertEquals( "Incorrect", "camel Casing Test", camelCase("camelCasingTest"));
        Assertions.assertEquals( "Incorrect", "camelcasingtest", camelCase("camelcasingtest"));
    } // end void tests()

    private String camelCase(String input) {
        return null;
    } // end String camelCase(String input)

} // end class KataBreakCamelCaseTests
