package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.reflection.Injector;
import com.jpvr.demodesignpatterns.reflection.Logger;
import org.junit.jupiter.api.Test;

public class ReflectionTests {

    @Test
    public void test() {

        Injector injector = new Injector().with("Hello World");

        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    } // end
} // end class ReflectionTests
