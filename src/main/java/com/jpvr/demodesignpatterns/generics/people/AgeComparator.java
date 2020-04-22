package com.jpvr.demodesignpatterns.generics.people;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(final Person left, final Person right) {

        return Integer.compare(left.getAge(), right.getAge());
    } // end int compare(final Person left, final Person right)
} // end class AgeComparator
