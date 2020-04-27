package com.jpvr.demodesignpatterns.generics.people;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    public ReverseComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    } // end constructor

    @Override
    public int compare(final T left, final T right) {

        return -1 * delegateComparator.compare(left, right);
    } // end int compare(final T left, final T right)
} // end class ReverseComparator
