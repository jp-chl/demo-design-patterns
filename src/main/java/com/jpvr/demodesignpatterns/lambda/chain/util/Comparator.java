package com.jpvr.demodesignpatterns.lambda.chain.util;

import com.jpvr.demodesignpatterns.lambda.chain.model.Person;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    public static Comparator<Person> comparing(java.util.function.Function<Person, String> keyExtractor) {
        return (p1, p2) -> {
            String s1 = keyExtractor.apply(p1);
            String s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    } // end static Comparator<Person> comparing(Function<Person, String> keyExtractor)
} // interface Comparator<T>
