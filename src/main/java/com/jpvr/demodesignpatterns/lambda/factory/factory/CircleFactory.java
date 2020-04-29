package com.jpvr.demodesignpatterns.lambda.factory.factory;

import com.jpvr.demodesignpatterns.lambda.factory.model.Circle;

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
} // end interface CircleFactory extends Supplier<Circle>
