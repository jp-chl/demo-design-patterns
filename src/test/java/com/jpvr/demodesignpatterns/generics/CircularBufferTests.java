package com.jpvr.demodesignpatterns.generics;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class CircularBufferTests {

    private CircularBuffer buffer = new CircularBuffer(2);

    @Test
    public void shouldConcatenateBufferElements() {

        CircularBuffer<String> myBuffer = new CircularBuffer<String>(10);

        myBuffer.offer("a");
        myBuffer.offer("bc");
        myBuffer.offer("d");

        String value = concatenate(myBuffer);

        System.out.println(value);
    } // fin void shouldConcatenateBufferElements()

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

    private String concatenate(CircularBuffer buffer) {

        StringBuilder result = new StringBuilder();

        String value;
        while( (value = (String) buffer.poll() ) != null ) {
            result.append(value);
        }

        return result.toString();
    } // end String concatenate(CircularBuffer buffer)
} // end class CircularBufferTests
