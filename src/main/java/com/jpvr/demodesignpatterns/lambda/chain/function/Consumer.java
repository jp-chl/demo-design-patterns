package com.jpvr.demodesignpatterns.lambda.chain.function;

import java.util.Objects;

/**
 * @FunctionInterface allows only one abstract method per consumer.
 * If you want to add another one:
 * - It has to be a concrete one.
 * - As of Java 8, it must have a "default" keyword prefix.
 */
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {

        Objects.requireNonNull(other);

        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    } // end Consumer<T> andThen(Consumer<T> other)
} // end interface Consumer<T>
