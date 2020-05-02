package com.jpvr.demodesignpatterns.lambda.validator;

import com.jpvr.demodesignpatterns.lambda.validator.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTests {

    @Test
    public void test() {

        Person sarah = new Person("Sarah", 29);
        Person james = new Person(null, 29);
        Person mary = new Person("Mary", -10);
        Person john = new Person("John", 1_000);
        Person linda = new Person(null, 1_000);

        sarah =
        Validator.validate(p -> p.getName() != null, "The name should not be null")
                .on(sarah)
                .validate();
        System.out.println("sarah = " + sarah);

        try {
            linda =
                    Validator.validate(p -> p.getName() != null, "The name should not be null")
                            .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                            .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150")
                            .on(linda)
                            .validate();
        } catch(Exception e) {

            Validator.ValidationException v = (Validator.ValidationException) e;
            assertEquals("The object is not valid", v.getMessage());
            IllegalArgumentException i1 = (IllegalArgumentException) e.getSuppressed()[0];
            IllegalArgumentException i2 = (IllegalArgumentException) e.getSuppressed()[1];
            assertEquals("The name should not be null", i1.getMessage());
            assertEquals("The age should be lesser than 150", i2.getMessage());
        }
        //System.out.println("linda = " + linda);

    } // end
} // end class ValidatorTests
