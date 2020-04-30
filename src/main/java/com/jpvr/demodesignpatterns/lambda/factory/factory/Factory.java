package com.jpvr.demodesignpatterns.lambda.factory.factory;

import com.jpvr.demodesignpatterns.lambda.factory.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {

        return this.get();
    } // end T newInstance()

    /**
     * Creates instances of object type T as List
     * @param numInstances list size
     * @return List of objects type T with numInstances size
     */
    default List<T> createManyInstancesAsList(int numInstances) {

        return IntStream.range(0, numInstances)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    } // end List<T> createInstances(int numInstances)

    /**
     * Custom, Circle Object, factory
     * @return
     */
    static Factory<Circle> createCircleFactory() {

        return () -> new Circle();
    } // end static Factory<Circle> createCircleFactory()

    /**
     * Custom, Circle colored Object, factory
     * @param color
     * @return
     */
    static Factory<Circle> createCircleFactory(Color color) {

        return () -> new Circle(color);
    } // end static Factory<Circle> createCircleFactory(Color)

    /**
     * Generic factory
     * @param supplier
     * @param <T>
     * @return
     */
    static <T> Factory<T> createFactory(Supplier<T> supplier) {

        return () -> supplier.get();
    } // end static <T> Factory<T> createFactory(Supplier<T> supplier)

    /**
     * Generic Object factory, with parameter, by using partial application
     * @param constructor Function, constructor, of object O with param P
     * @param param Param P passed to the constructor
     * @param <P> datatype of param
     * @param <O> datatype of object
     * @return new instance of object O built with param P
     */
    static <P, O> Factory<O> createFactory(Function<P, O> constructor, P param) {

        //Function<Color, Circle> constructor = c -> new Circle(c);
        return () -> constructor.apply(param);
    } // end static Factory<Circle> createColoredCircleFactory(Color color)

    /**
     * Singleton instance
     * @param supplier
     * @param <T>
     * @return
     */
    static <T> Factory<T> createSingletonFactory(Supplier<T> supplier) {

        T singleton = supplier.get();
        return () -> singleton;
    } // end static <T> Factory<T> createSingletonFactory(Supplier<T> supplier)

} // end interface Factory<T> extends Supplier<T>






























