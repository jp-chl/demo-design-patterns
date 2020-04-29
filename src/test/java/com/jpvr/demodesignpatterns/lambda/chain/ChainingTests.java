package com.jpvr.demodesignpatterns.lambda.chain;

import com.jpvr.demodesignpatterns.lambda.chain.function.Consumer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions;

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
        //c3.accept("Hello");

        Assertions.assertThrows(NullPointerException.class, () -> {
            c1.andThen(null);
        });
        
        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("Hello");
    } // end void chainingTests()
} // end class ChainingTests
