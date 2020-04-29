package com.jpvr.demodesignpatterns.lambda.factory;

import com.jpvr.demodesignpatterns.lambda.factory.factory.CircleFactory;
import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Circle;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
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

        //final CircleFactory factory = () -> new Circle();
        final CircleFactory factory = Circle::new;

        List<Circle> circles = factory.createFiveCircles();

        Assertions.assertNotNull(circles);
        assertEquals(5, circles.size());
    } // end void whenUsingCustomSupplier_thenCreateManyObjectsWithFactory()

    @Test
    public void whenUsingCustomSupplier_thenCreateCustomObjectFactory() {

        final CircleFactory redCircleFactory = CircleFactory.createFactory(Color.RED);
        final Circle redCircle = redCircleFactory.newInstance();

        assertEquals(Color.RED, redCircle.getColor());
    } // end void whenUsingCustomSupplier_thenCreateCustomObjectFactory()

    @Test
    public void whenUsingCustomSupplierFactory_thenCreateManyObjects() {

        //final Factory<Circle> factory = () -> new Circle();
        final Factory<Circle> factory = Circle::new;

        final int numCircles = 5;
        List<Circle> circles = factory.createInstances(numCircles);

        Assertions.assertNotNull(circles);
        assertEquals(numCircles, circles.size());

        System.out.println("Circle instance = " + factory.newInstance());
        System.out.println(numCircles + " circles : " + circles);
    } // end void whenUsingCustomSupplierFactory_thenCreateManyObjects()


} // end class FactoryTests
