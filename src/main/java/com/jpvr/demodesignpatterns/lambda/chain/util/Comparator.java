package com.jpvr.demodesignpatterns.lambda.chain.util;

import com.jpvr.demodesignpatterns.lambda.chain.model.Person;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    public static <T> Comparator<T> comparing(java.util.function.Function<T, String> keyExtractor) {

        Objects.requireNonNull(keyExtractor);

        return (p1, p2) -> {
            String s1 = keyExtractor.apply(p1);
            String s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    } // end static <T> Comparator<T> comparing(Function<T, String> keyExtractor)

    default Comparator<T> reversed() {

        return (t1, t2) -> this.compare(t2, t1);
    } // end <T> Comparator<T> reversed()
} // interface Comparator<T>
