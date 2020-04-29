package com.jpvr.demodesignpatterns.lambda.chain.function;

/**
 * @FunctionInterface allows only one abstract method for a consumer.
 * If you want to add another one:
 * - It has to be a concrete one.
 * - As of Java 8, it must have a "default" keyword.
 */
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {

        return (T t) -> {};
    } // end Consumer<T> andThen(Consumer<T> other)
} // end interface Consumer<T>
