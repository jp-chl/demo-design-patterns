package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.typebounds.SortedPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortedPairTests {

    @Test
    public void shouldRetainOrderOfOrderedPair() {

        SortedPair<Integer> pair = new SortedPair<>(1, 2);

        assertEquals(1, pair.getFirst().intValue());
        assertEquals(2, pair.getSecond().intValue());
    } // end void shouldRetainOrderOfOrderedPair()

    @Test
    public void shouldFlipOrderOfUnorderedPair() {

        SortedPair<Integer> pair = new SortedPair<>(2, 1);

        assertEquals(1, pair.getFirst().intValue());
        assertEquals(2, pair.getSecond().intValue());
    } // end void shouldFlipOrderOfUnorderedPair()
} // end class SortedPairTests
