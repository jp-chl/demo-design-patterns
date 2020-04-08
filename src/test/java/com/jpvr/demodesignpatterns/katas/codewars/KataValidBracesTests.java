package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;

public class KataValidBracesTests {

    public static final Collection<Character> validBraceCharacters = Arrays.asList('(', ')', '[', ']', '{', '}');
    public static final Pattern pattern = Pattern.compile("[()\\[\\]{}]+");

    @Test
    public void checkValidBraces() {

        long start = System.currentTimeMillis();
        Assertions.assertEquals(false, isValidStack("a"));
        Assertions.assertEquals(true, isValidStack("(a .)"));
        Assertions.assertEquals(false, isValidStack("[(])"));
        Assertions.assertEquals(true, isValidStack("(){}[]"));
        Assertions.assertEquals(true, isValidStack("([{}])"));
        Assertions.assertEquals(false, isValidStack("(}"));
        Assertions.assertEquals(false, isValidStack("[(])"));
        Assertions.assertEquals(false, isValidStack("[({})](]"));
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Metodo 1: " + diff);

        start = System.currentTimeMillis();
        Assertions.assertEquals(false, isValidDeque("a"));
        Assertions.assertEquals(true, isValidDeque("(a .)"));
        Assertions.assertEquals(false, isValidDeque("[(])"));
        Assertions.assertEquals(true, isValidDeque("(){}[]"));
        Assertions.assertEquals(true, isValidDeque("([{}])"));
        Assertions.assertEquals(false, isValidDeque("(}"));
        Assertions.assertEquals(false, isValidDeque("[(])"));
        Assertions.assertEquals(false, isValidDeque("[({})](]"));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 2: " + diff);
    } // end void checkValidBraces()

    private boolean isValidDeque(String braces) {

        // Input does not contain valid braces
        if ( !pattern.matcher(braces).find() ) {
            return false;
        }

        // The javadoc of ArrayDeque says "This class is likely to be faster
        // than Stack when used as a stack, and faster than LinkedList when used as a queue."
        Deque<Character> bracesStack = new ArrayDeque<>();
        //Stack<Character> bracesStack = new Stack<>();

        for(Character character : braces.toCharArray()) {

            // Ignoring non-brace characters
            if ( !validBraceCharacters.contains(character)) {

                continue;
            }

            if ( isOpeningBrace(character) ) {

                bracesStack.push(character);
            } else if ( isClosingBrace(character) ) {

                // Last element (opening bracket) matches closing one
                if ( !bracesStack.isEmpty() && isMatchingBraces(bracesStack.peek(), character) ) {

                    bracesStack.pop();
                } else {

                    // opening-closing brackets does not match
                    return false;
                }
            } // end closing brace analysis
        } // end String iteration

        return bracesStack.isEmpty();
    } // end boolean isValidDeque(String braces)

    private boolean isValidStack(String braces) {

        // Input does not contain valid braces
        if ( !pattern.matcher(braces).find() ) {
            return false;
        }

        Stack<Character> bracesStack = new Stack<>();

        for(Character character : braces.toCharArray()) {

            // Ignoring non-brace characters
            if ( !validBraceCharacters.contains(character)) {

                continue;
            }

            if ( isOpeningBrace(character) ) {

                bracesStack.push(character);
            } else if ( isClosingBrace(character) ) {

                // Last element (opening bracket) matches closing one
                if ( !bracesStack.isEmpty() && isMatchingBraces(bracesStack.peek(), character) ) {

                    bracesStack.pop();
                } else {

                    // opening-closing brackets does not match
                    return false;
                }
            } // end closing brace analysis
        } // end String iteration

        return bracesStack.isEmpty();
    } // end boolean isValid(String braces)

    private boolean isMatchingBraces(Character openingCharacter, Character closingCharacter) {

        return     ( openingCharacter.equals('(') && closingCharacter.equals(')') )
                || ( openingCharacter.equals('{') && closingCharacter.equals('}') )
                || ( openingCharacter.equals('[') && closingCharacter.equals(']') );
    } // end boolean isMatchingBraces(Character openingCharacter, Character closingCharacter)

    private boolean isOpeningBrace(Character character) {

        return     (character.equals('('))
                || (character.equals('['))
                || (character.equals('{'));
    } // end boolean isOpeningBrace(Character character)

    private boolean isClosingBrace(Character character) {

        return     (character.equals(')'))
                || (character.equals(']'))
                || (character.equals('}'));
    } // end boolean isClosingBrace(Character character)
} // end class KataValidBracesTests
