package com.jpvr.demodesignpatterns.lambda.factory.factory;

import com.jpvr.demodesignpatterns.lambda.factory.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface CircleFactory extends Supplier<Circle> {

    default Circle newInstance() {

        return this.get();
    } // end Circle newInstance()

    default List<Circle> createFiveCircles() {

        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    } // end List<Circle> createFiveCircles()

    static CircleFactory createFactory() {

        return () -> new Circle();
    } // end static CircleFactory createFactory()

    static CircleFactory createFactory(Color color) {

        return () -> new Circle(color);
    } // end static CircleFactory createFactory(Color)
} // end interface CircleFactory extends Supplier<Circle>
