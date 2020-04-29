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
    } // end <V> Function<T, V> andThen(Function<R, V> other)

    default <V> Function<V, R> compose(Function<V, T> other) {
        Objects.requireNonNull(other);

        return (V v) -> {

            final T t = other.apply(v);
            return this.apply(t);
        };
    } // end <V> Function compose(Function other)
} // end interface Function
