package com.jpvr.demodesignpatterns.lambda.factory.registry;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Rectangle;
import com.jpvr.demodesignpatterns.lambda.factory.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public interface Registry {

    Factory<? extends Shape> buildShapeFactory(String shape);

    public static Registry createRegistry(Consumer<Builder<Rectangle>> consumer) {

        Map<String, Factory<Rectangle>> map = new HashMap<>();

        // Calling the register function of the
        // functional interface Builder,
        // with map.put(l, f) as its implementation
        Builder<Rectangle> builder =
                ((label, factory) -> map.put(label, factory));

        // calling builder.register(label, factory) method
        consumer.accept(builder);

        System.out.println("map = " + map);

        // final Factory<Rectangle> rectangleFactory = map.get(shape);
        //
        // buildShapeFactory abstract interface method return type required
        return shape -> map.get(shape);
    } // end static Registry createRegistry(Consumer<Builder<Rectangle>> consumer)
} // end class Registry
