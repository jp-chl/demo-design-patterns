package com.jpvr.demodesignpatterns.lambda.visitor;

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

        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<R>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {

                registry.put(type, function.compose(o -> type.cast(o)));
                //registry.put(type, function.compose(type::cast));
            } // end void register(Class<T> type, Function<T, R> function)
        }; // end VisitorBuilder<R> visitorBuilder


        consumer.accept(visitorBuilder);

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
    static <T, R> X<T, R> forType(Class<T> type) {

        return () -> type;
    } // end static X forType(Class<?> type)

    /**
     * Inner functional interface.
     * It doesn't allow more methods (so check interface Y)
     * @param <R>
     */
    interface X<T, R> {

        Class<T> type();

        default Y<R> execute(Function<T, R> function) {

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
        default <T> Z<T, R> forType(Class<T> type) {

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
    interface Z<T, R> {

        Object get(int index);

        default Class<T> type() {
            return (Class<T>)get(1);
        }

        default Y<R> previousConsumer() {
            return (Y<R>)get(0);
        }

        default Y<R> execute(Function<T, R> function) {

            return previousConsumer().andThen(
                visitorBuilder -> visitorBuilder.register(type(), function));
        } // end Y<R> execute(Function<Object, R> function)
    } // end inner interface Z<R>
} // end interface Visitor




















