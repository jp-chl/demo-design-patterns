package com.jpvr.demodesignpatterns.reflection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Injector {

    private Map<Class<?>, Object> objectGraph = new HashMap<>();

    public Injector with(Object value) {

        objectGraph.put(value.getClass(), value);
        return this;
    }  // end Injector with(Object value)

    public <T> T newInstance(final Class<?> clazz) {

        T result = (T) objectGraph.computeIfAbsent(clazz, this::instantiate);
        return result;
    } // end Object newInstance(final String className)

    private Object instantiate(Class<?> clazz) {

        try {

            Constructor<?>[] constructors = clazz.getConstructors();

            if ( constructors.length > 1 ) {

                throw new IllegalArgumentException(clazz + " must only have 1 constructor");
            }

            Constructor<?> constructor = constructors[0];

            Object[] args = Stream.of(constructor.getParameterTypes())
                    .map(param -> (Object) newInstance(param))
                    .toArray();

            final Object newInstance = constructor.newInstance(args);
            return newInstance;
        } catch(Exception e) {

            throw new RuntimeException(e);
        }
    } // end Object instantiate(Class<?> clazz)
} // end class Injector
