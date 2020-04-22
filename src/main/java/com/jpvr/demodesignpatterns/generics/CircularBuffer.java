package com.jpvr.demodesignpatterns.generics;

public class CircularBuffer<T> {

    private T[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {

        buffer = (T[]) new Object[size];
    } // end CircularBuffer(int size)

    public boolean offer(T value) {

        if ( buffer[writeCursor] != null ) {
            return false;
        }

        buffer[writeCursor] = value;

        writeCursor = next(writeCursor);

        return true;
    } // end boolean offer(Object value)

    public T poll() {

        final T value = buffer[readCursor];
        if ( value != null ) {

            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }

        return value;
    } // end Object poll()

    private int next(int index) {

        return (index + 1) % buffer.length;
    } // end int next(int index)
} // end class CircularBuffer
