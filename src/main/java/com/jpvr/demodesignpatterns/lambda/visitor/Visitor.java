package com.jpvr.demodesignpatterns.lambda.visitor;

import com.jpvr.demodesignpatterns.dp.behavioral.command.Command;
import com.jpvr.demodesignpatterns.lambda.visitor.model.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * "R" is the class to be "visited"
 */
public interface Visitor<R> {

    /**
     * Main method
     */
    R visit(Object o);


    /**
     * Method to create the registry
     * @param consumer Function that takes objects and return R
     * @param <R> Class to be visited
     * @return Implementation of the visitor
     */
    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {

        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();

        // consumer.accept((registry::put)); // less "readable" version
        consumer.accept(
                ((type, function) -> registry.put(type, function)));

        // Return the implementation of the visitor
        // (visit method of this interface)
        return o -> registry.get(o.getClass()).apply(o);
    } // end static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer)


    /**
     * Static factory method
     * @param type
     * @param <R>
     * @return
     */
    static <R> X<R> forType(Class<?> type) {

        return () -> type;
    } // end static X forType(Class<?> type)

    /**
     * Inner functional interface
     * @param <R>
     */
    interface X<R> {

        Class<?> type();

        default Consumer<VisitorBuilder<R>> execute(Function<Object, R> function) {

            return visitorBuilder -> visitorBuilder.register(type(), function);
        } // end Consumer<VisitorBuilder<R>> execute(Function<Object, R> function)


    } // end inner functional interface
} // end interface Visitor




















