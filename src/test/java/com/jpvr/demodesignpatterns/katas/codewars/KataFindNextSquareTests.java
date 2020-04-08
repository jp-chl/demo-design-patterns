package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class KataFindNextSquareTests {

    @Test
    public void findNextSquares() {

        Assertions.assertEquals(144, findNextSquareBad(121));

        Assertions.assertEquals(676, findNextSquareBad(625));

        Assertions.assertEquals(-1, findNextSquareBad(114));
    } // end findNextSquares()

    private long fns(long sq) {

        long start = System.currentTimeMillis();

        final double root = Math.sqrt(sq);

        long nextPerfectSquare = ((root % 1) != 0) ? -1L: (long)Math.pow(root +1, 2);

        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Metodo 1: " + diff);

        start = System.currentTimeMillis();
        nextPerfectSquare = (new BigDecimal(root).scale() > 0) ? (-1L) : (long)((root+1)*(root+1));
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 2: " + diff);

        start = System.currentTimeMillis();
        nextPerfectSquare = (long)((root * root == sq) ? ((root + 1) * (root + 1)) : -1);
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Metodo 3: " + diff);

        return nextPerfectSquare;
    } // end long fns(long sq)

    private long findNextSquareBad(long sq) {
        long root = (long) Math.sqrt(sq);
        return root * root == sq ? (root + 1) * (root + 1) : -1;
    }

    /**
     * You might know some pretty large perfect squares. But what about the NEXT one?
     *
     * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
     *
     * If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
     * @param sq
     * @return
     */
    private long findNextSquare(long sq) {

        final double root = Math.sqrt(sq);

        if ( root % 1 != 0) {

            return -1L;
        } else {

            return ((long)Math.pow(root +1, 2));
        }

        //return (new BigDecimal(root).scale() > 0) ? (-1L) : ((long)Math.pow(root +1, 2));

        //return (new BigDecimal(root).scale() > 0) ? (-1L) : (long)((root+1)*(root+1));
    } // end long findNextSquare(long sq)
} // end class KataFindNextSquareTests
