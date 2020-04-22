package com.jpvr.demodesignpatterns.generics.people;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    public ReverseComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    @Override
    public int compare(final T left, final T right) {

        return -1 * delegateComparator.compare(left, right);
    }
} // end class ReverseComparator
