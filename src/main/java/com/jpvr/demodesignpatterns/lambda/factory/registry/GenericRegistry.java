package com.jpvr.demodesignpatterns.lambda.factory.registry;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Functional interface to create objects
 * of any type
 */
public interface GenericRegistry<T> {

    Factory<? extends T> buildShapeFactory(String shape);

    public static <T> GenericRegistry<T> createRegistry(Consumer<Builder<T>> consumer) {

        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder =
                ((label, factory) -> map.put(label, factory));
        consumer.accept(builder);

        return shape -> map.getOrDefault(shape,
                () -> {throw new IllegalArgumentException("Unknown shape: " + shape);});
    } // end static GenericRegistry<T> createRegistry(Consumer<Builder<T>> consumer)

    public static <T> GenericRegistry<T> createRegistry(
            Consumer<Builder<T>> consumer,
            Function<String, Factory<T>> errorFunction) {

        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder =
                ((label, factory) -> map.put(label, factory));
        consumer.accept(builder);

        // final Function<String, Factory<T>> errorFunction = s -> {
        //      throw new IllegalArgumentException("Unknown shape: " + s);
        // };
        //
        // Instead of a Factory, passing a Function as a
        // parameter to map function
        return shape -> map.computeIfAbsent(shape, errorFunction);
    } // end static GenericRegistry<T> createRegistry(Consumer<Builder<T>> consumer, Function<String, Factory<T>> errorFunction)
} // end interface GenericRegistry<T>
