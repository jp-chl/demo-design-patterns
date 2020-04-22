package com.jpvr.demodesignpatterns.generics;

import java.util.AbstractList;

public class CustomArrayList<T> extends AbstractList<T> {

    private T[] values;

    public CustomArrayList() {

        values = (T[]) new Object[0];
    }

    @Override
    public boolean add(T o) {

        T[] newValues = (T[]) new Object[size() + 1];
        for(int i=0; i<size(); i++) {
            newValues[i] = values[i];
        }

        newValues[size()] = o;
        values = newValues;

        return true;
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }
} // end class CustomArrayList
