package com.jpvr.demodesignpatterns.lambda.chain.function;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other) {

        Objects.requireNonNull(other);

        return (T t) -> {

            final R r = this.apply(t);
            return other.apply(r);
        };
    } // end Function<T, V> andThen(Function<R, V> other)
} // end interface Function
