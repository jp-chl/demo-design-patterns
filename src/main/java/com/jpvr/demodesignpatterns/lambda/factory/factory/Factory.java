package com.jpvr.demodesignpatterns.lambda.factory.factory;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {

        return this.get();
    } // end T newInstance()

    default List<T> createInstances(int numInstances) {

        return IntStream.range(0, numInstances)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    } // end List<T> createInstances(int numInstances)
} // end interface Factory<T> extends Supplier<T>
