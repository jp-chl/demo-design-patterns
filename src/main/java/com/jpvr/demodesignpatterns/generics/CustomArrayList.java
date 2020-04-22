package com.jpvr.demodesignpatterns.generics;

import java.util.AbstractList;

public class CustomArrayList extends AbstractList {

    private Object[] values;

    public CustomArrayList() {

        values = new Object[0];
    }

    @Override
    public boolean add(Object o) {

        Object[] newValues = new Object[size() + 1];
        for(int i=0; i<size(); i++) {
            newValues[i] = values[i];
        }

        newValues[size()] = o;
        values = newValues;

        return true;
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }
} // end class CustomArrayList
