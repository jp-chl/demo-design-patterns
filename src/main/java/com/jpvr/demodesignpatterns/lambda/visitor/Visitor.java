package com.jpvr.demodesignpatterns.lambda.visitor;

import com.jpvr.demodesignpatterns.dp.behavioral.command.Command;
import com.jpvr.demodesignpatterns.lambda.visitor.model.Car;
import com.jpvr.demodesignpatterns.lambda.visitor.model.Engine;

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

        System.out.println("registry = " + registry.keySet());

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
     * Inner functional interface.
     * It doesn't allow more methods (so check interface Y)
     * @param <R>
     */
    interface X<R> {

        Class<?> type();

        default Y<R> execute(Function<Object, R> function) {

            return visitorBuilder -> visitorBuilder.register(type(), function);
        } // end Consumer<VisitorBuilder<R>> execute(Function<Object, R> function)
    } // end inner functional interface X<R>

    /**
     * To allow chaining the execute method
     */
    interface Y<R> extends Consumer<VisitorBuilder<R>> {

        /**
         * Returns Z to chain consumer calls
         */
        default Z<R> forType(Class<?> type) {

            return index -> (index == 0) ? this : type;
        } // end X<R> forType(Class<?> type)

        default Y<R> andThen(Y<R> after) {

            return t -> {
                this.accept(t);
                after.accept(t);
            };
        } // end Y<R> andThen()
    } // end inner interface Y<R> extends Consumer<VisitorBuilder<R>>

    /**
     *
     */
    interface Z<R> {

        Object get(int index);

        default Class<?> type() {
            return (Class<?>)get(1);
        }

        default Y<R> previousConsumer() {
            return (Y<R>)get(0);
        }

        default Y<R> execute(Function<Object, R> function) {

            return previousConsumer().andThen(
                visitorBuilder ->
                    visitorBuilder.register(type(), function));
        } // end Y<R> execute(Function<Object, R> function)
    } // end inner interface Z<R>
} // end interface Visitor




















