package com.jpvr.demodesignpatterns.lambda.chain;

import com.jpvr.demodesignpatterns.lambda.chain.function.Consumer;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainingTests {

    @Test
    public void chainingTests() {

        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);
        //c1.accept("Hello");

        Consumer<String> c3 = s -> {

            c1.accept(s);
            c2.accept(s);
        };
        c3.accept("Hello");

        Consumer<String> c4 = c1.andThen(c2);
    } // end void chainingTests()
} // end class ChainingTests
