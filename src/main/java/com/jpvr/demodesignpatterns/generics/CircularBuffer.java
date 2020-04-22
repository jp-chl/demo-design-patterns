package com.jpvr.demodesignpatterns.generics;

public class CircularBuffer {

    private Object[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {

        buffer = new Object[size];
    } // end CircularBuffer(int size)

    public boolean offer(Object value) {
        return true;
    } // end boolean offer(Object value)

    public Object poll() {
        return null;
    } // end Object poll()

    private int next(int index) {

        return (index + 1) % buffer.length;
    } // end int next(int index)
} // end class CircularBuffer
