package com.jpvr.demodesignpatterns.generics;

import java.util.AbstractList;

public class CustomArrayList<T> extends AbstractList<T> {

    private Object[] values;

    public CustomArrayList() {

        values = (T[]) new Object[0];
    } // end constructor

    @Override
    public boolean add(T o) {

        Object[] newValues = new Object[size() + 1];
        for(int i=0; i<size(); i++) {
            newValues[i] = values[i];
        }

        newValues[size()] = o;
        values = newValues;

        return true;
    } // end boolean add(T o)

    @Override
    public T get(int index) {
        return (T) values[index];
    } // end T get(int index)

    @Override
    public int size() {
        return values.length;
    } // end int size()
} // end class CustomArrayList
