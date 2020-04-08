package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

// TODO: Ejemplos IntStream: https://opensource.com/article/20/1/javastream
public class KataPersistenceTests {

    @Test
    public void testDigitsMultiplication() {

        long number = 69;
//        int theDigitsMultiplication =  digitsMultiplication(number);
        int multiplicativePersistence = persistence(number);

        number = 999;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 39;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 277777788888899L;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistenceString(number);

        number = 999;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 39;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 2268;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 18432;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 1176;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 432;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);



        number = 9;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);

        number = 0;
//        theDigitsMultiplication =  digitsMultiplication(number);
        multiplicativePersistence = persistence(number);
    } // end testDigitsMultiplication()

    private int persistence(long n) {

        long multiplicativePersistence = 1;
        long rest = n;

        if ( (rest / 10) == 0) {
            return 0;
        }

        for(rest = n; rest != 0; rest /= 10) {
            multiplicativePersistence *= rest % 10;
        } // end for

        return persistence(multiplicativePersistence) + 1;
    } // end persistence(long n)

    private int persistenceString(long n) {

        String longNumber = Long.toString(n);
        IntStream intStream = longNumber.chars();

        intStream.forEach(System.out::println);

        int ax = 54;
        int ay = 57;
        int az = ay - '0';
        az = ay - '9';
        az = ay - '8';
        az = ay - '7';

        IntBinaryOperator reducer = (x, y) -> (x*y);
        int multiplication = reducer.applyAsInt(54, 57);
        long digitsMultiplication = longNumber.chars()
                .reduce(1, reducer);

        IntBinaryOperator anotherReducer = (x, y) -> (x * (y - '0'));
        multiplication = anotherReducer.applyAsInt(54, 57);
        digitsMultiplication = longNumber.chars()
                .reduce(1, anotherReducer);

        IntBinaryOperator yetAnotherReducer = (x, y) -> (x * (y - '1'));
        multiplication = yetAnotherReducer.applyAsInt(54, 57);
        digitsMultiplication = longNumber.chars()
                .reduce(1, yetAnotherReducer);

        digitsMultiplication = longNumber.chars()
                .reduce(1,
                        (r, i) -> (r * (i - '1' )));

        int times = 0;
        while (n >= 10) {
            n = Long.toString(n).chars().reduce(1, (r, i) -> r * (i - '0'));
            times++;
        }
        return times;
    } // end int persistenceString(long n)

    private int deprecatedPersistence(long n) {

        if ( n <= 9) {
            return 0;
        }

        int multiplicativePersistence = 0;

        long multiplicationAcum = digitsMultiplication(n);
        multiplicativePersistence++;

        while( multiplicationAcum >= 9) {

            multiplicativePersistence++;
            multiplicationAcum = digitsMultiplication(multiplicationAcum);
        }

        return multiplicativePersistence;
    } // end int persistence(long n)

    private int lastDigit(long number) {

        int theNumber = Math.toIntExact(number);

        return ((theNumber < 10) && (theNumber >= 0)) ? theNumber : (theNumber%10);
    } // end int lastDigit(int number)

    private int digitsMultiplication(long number) {

        if ( number <= 9) {
            return Math.toIntExact(number);
        }

        int theLastDigit = lastDigit(number);
        long numberWithoutLastDigit = number/10;

        int multiplicationAcum = 1 * theLastDigit;

        while(true) {

            theLastDigit = lastDigit(numberWithoutLastDigit);
            if ( numberWithoutLastDigit <= 9) {
                multiplicationAcum *= numberWithoutLastDigit;
                break;
            }

            numberWithoutLastDigit = numberWithoutLastDigit/10;

            multiplicationAcum *= theLastDigit;

            if ( multiplicationAcum == 0 ) {
                break;
            }

        } // end while

        return multiplicationAcum;
    } // end int digitsMultiplication(int number)
} // end class KataTests
