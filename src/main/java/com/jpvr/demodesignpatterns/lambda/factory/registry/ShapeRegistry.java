package com.jpvr.demodesignpatterns.lambda.factory.registry;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Functional interface to create objects
 * of type Shape
 */
public interface ShapeRegistry {

    Factory<? extends Shape> buildShapeFactory(String shape);

    /**
     * This method encapsulates the creation with an inner HashMap.
     * Not access allowed, not even with Reflection.
     */
    public static ShapeRegistry createShapeRegistry(Consumer<Builder<Shape>> consumer) {

        Map<String, Factory<Shape>> map = new HashMap<>();

        Builder<Shape> builder =
                ((label, factory) -> map.put(label, factory));

        consumer.accept(builder);

        return shape -> map.get(shape);
    } // end static ShapeRegistry createShapeRegistry(Consumer<Builder<Shape>> consumer)

    public static ShapeRegistry createShapeRegistryWithErrorHandling(
            Consumer<Builder<Shape>> consumer) {

        Map<String, Factory<Shape>> map = new HashMap<>();

        Builder<Shape> builder  =
                (map::put); // ((label, factory) -> map.put(label, factory));

        consumer.accept(builder);

        // As the Factory is an instance of the
        // Supplier functional interface, we can
        // return a lambda expression in the default case
        return shape -> map.getOrDefault(shape,
                () -> {throw new IllegalArgumentException("Unknown shape: " + shape);});
    } // end static ShapeRegistry createShapeRegistryWithErrorHandling(Consumer<Builder<Shape>> consumer)

} // end interface ShapeRegistry
