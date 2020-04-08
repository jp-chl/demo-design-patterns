package com.jpvr.demodesignpatterns.katas.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataPeopleBuilderTests {

    @Test
    public void testSample() {
        People person = People.builder()
                .name("Adam").lastName("Savage").age(25).city("San Francisco").job("Unchained Reaction")
                .build();
        Assertions.assertEquals(
                "Adam",
                person.getName()
        );
        Assertions.assertEquals(
                "hello my name is Adam",
                person.greet()
        );
    } // end void testSample()

} // end class KataBuilderTests
