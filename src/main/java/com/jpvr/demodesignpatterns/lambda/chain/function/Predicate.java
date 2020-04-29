package com.jpvr.demodesignpatterns.lambda.chain.function;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {

        Objects.requireNonNull(other);

//        return (T t) -> {
//            return this.test(t) && other.test(t);
//        };

        return (T t) -> this.test(t) && other.test(t);
    } // end Predicate<T> and(Predicate<T> other)

    default Predicate<T> negate() {

        return (T t) -> !this.test(t);
    } // end Predicate<T> negate()
} // end interface Predicate<T>
