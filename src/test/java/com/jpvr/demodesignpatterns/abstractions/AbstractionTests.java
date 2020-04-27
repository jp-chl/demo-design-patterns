package com.jpvr.demodesignpatterns.abstractions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AbstractionTests {

    @Test
    public void test() {

        Animal animal = new Animal();
        animal.draw(1, 2, 3, 4, 5);
    } // end void test()

} // end class AbstractionTests
