package com.jpvr.demodesignpatterns.lambda.factory;

import com.jpvr.demodesignpatterns.lambda.factory.factory.CircleFactory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Circle;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTests {

    @Test
    public void whenUsingCustomSupplier_thenCreateFactory() {

        CircleFactory factory = () -> new Circle();

        final Circle circle = factory.newInstance();
        System.out.println("circle = " + circle);
    } // end void whenUsingCustomSupplier_thenCreateFactory()

    @Test
    public void whenUsingCustomSupplier_thenCreateManyObjectsWithFactory() {

        final CircleFactory factory = () -> new Circle();

        List<Circle> circles = factory.createFiveCircles();

        Assertions.assertNotNull(circles);
    } // end void whenUsingCustomSupplier_thenCreateManyObjectsWithFactory()

} // end class FactoryTests
