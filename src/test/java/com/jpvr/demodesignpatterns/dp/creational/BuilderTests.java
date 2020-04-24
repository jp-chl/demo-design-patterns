package com.jpvr.demodesignpatterns.dp.creational;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class BuilderTests {

    @Test
    public void stringBuilderTest() {

        System.out.println(new StringBuilder().append("a").append(4).toString());
    } // end

    @Test
    public void lunchBuilderTest() {

        assertNull(new BuilderLunchOrder.Builder().bread("b").dressing("d").meat("m").build().getCondiments());

//        assertEquals("condiments",
//                LunchOrder.Builder()
//                        .bread("b")
//                        .condiments("condiments")
//                        .dressing("d")
//                        .meat("m")
//                        .build()
//                        .getCondiments());
    } // end
} // end class BuilderTests
