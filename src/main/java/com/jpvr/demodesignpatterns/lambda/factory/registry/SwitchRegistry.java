package com.jpvr.demodesignpatterns.lambda.factory.registry;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Rectangle;
import com.jpvr.demodesignpatterns.lambda.factory.model.Shape;
import com.jpvr.demodesignpatterns.lambda.factory.model.Square;
import com.jpvr.demodesignpatterns.lambda.factory.model.Triangle;

/**
 * Factory as a class.
 * Check improved version as a Functional interface (@see ShapeRegistry)
 */
public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape) {

        switch(shape) {

            case "square" :
                return () -> new Square();

            case "triangle":
                return () -> new Triangle();

            case "rectangle":
                return () -> new Rectangle();

            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        } // end switch(shape)
    } // end Factory<? extends Shape> buildShapeFactory(String shape)
} // end class SwitchRegistry
