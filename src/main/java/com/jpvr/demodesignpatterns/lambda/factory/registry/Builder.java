package com.jpvr.demodesignpatterns.lambda.factory.registry;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;

public interface Builder<T> {

    // This method can be modeled as a consumer,
    // a consumer of the parameter is taking
    void register(String label, Factory<T> factory);
} // end interface Builder<T>
