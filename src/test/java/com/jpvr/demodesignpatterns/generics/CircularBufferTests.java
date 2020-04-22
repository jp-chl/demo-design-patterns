package com.jpvr.demodesignpatterns.generics;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class CircularBufferTests {

    private CircularBuffer buffer = new CircularBuffer(2);

    @Test
    public void shouldOfferPollableElement() {

        Assertions.assertTrue(buffer.offer(1));
        Assertions.assertEquals(1, buffer.poll());
        Assertions.assertNull(buffer.poll());
    } // end void shouldOfferPollableElement()

    @Test
    public void shouldNotOfferWhenBufferIsFull() {

        Assertions.assertTrue(buffer.offer(1));
        Assertions.assertTrue(buffer.offer(2));
        Assertions.assertFalse(buffer.offer(3));
    } // end void shouldNotOfferWhenBufferIsFull()

    @Test
    public void shouldNotPollWhenBufferIsEmpty() {

        Assertions.assertNull(buffer.poll());
    } // end void shouldNotPollWhenBufferIsEmpty()

    @Test
    public void shouldRecycleBuffer() {

        Assertions.assertTrue(buffer.offer(1));
        Assertions.assertTrue(buffer.offer(2));
        Assertions.assertEquals(1, buffer.poll());
        Assertions.assertTrue(buffer.offer(3));
        Assertions.assertEquals(2, buffer.poll());
        Assertions.assertEquals(3, buffer.poll());
    } // end void shouldRecycleBuffer()
} // end class CircularBufferTests
