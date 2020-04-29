package com.jpvr.demodesignpatterns.lambda.chain.util;

import com.jpvr.demodesignpatterns.lambda.chain.model.Person;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    //public static <T, U extends Comparable> Comparator<T> comparing(java.util.function.Function<T, U> keyExtractor) {
    //public static <T, U extends Comparable<? super U>> Comparator<T> comparing(java.util.function.Function<T, U> keyExtractor)
    public static <T, U extends Comparable<U>> Comparator<T> comparing(java.util.function.Function<T, U> keyExtractor) {

        Objects.requireNonNull(keyExtractor);

        return (p1, p2) -> {
            U s1 = keyExtractor.apply(p1);
            U s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    } // end static <T> Comparator<T> comparing(Function<T, String> keyExtractor)

    default Comparator<T> reversed() {

        return (t1, t2) -> this.compare(t2, t1);
    } // end <T> Comparator<T> reversed()

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);

        return (t1, t2) -> {

            final int compare = this.compare(t1, t2);
            return (compare!=0) ? compare: other.compare(t1, t2);
        };
    } // end Comparator<T> thenComparing(Comparator<T> other)
} // interface Comparator<T>
