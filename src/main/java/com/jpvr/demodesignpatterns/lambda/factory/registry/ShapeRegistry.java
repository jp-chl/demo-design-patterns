package com.jpvr.demodesignpatterns.lambda.factory.registry;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public interface ShapeRegistry {

    Factory<Shape> buildShapeFactory(String shape);

    public static ShapeRegistry createShapeRegistry(
            Consumer<Builder<Shape>> consumer) {

        Map<String, Factory<Shape>> map = new HashMap<>();

        Builder<Shape> builder =
                ((label, factory) -> map.put(label, factory));

        consumer.accept(builder);

        System.out.println("map = " + map);

        return shape -> map.get(shape);
    } // end static ShapeRegistry createShapeRegistry(Consumer<Builder<Shape>> consumer)

} // end interface ShapeRegistry
