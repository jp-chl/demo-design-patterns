package com.jpvr.demodesignpatterns.lambda.factory;

import com.jpvr.demodesignpatterns.dp.creational.SingletonDb;
import com.jpvr.demodesignpatterns.lambda.factory.factory.CircleFactory;
import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Circle;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;

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

        final Factory<Circle> factory = Factory.createCircleFactory();

        final int numCircles = 5;
        List<Circle> circles = factory.createManyInstancesAsList(numCircles);

        Assertions.assertNotNull(circles);
        assertEquals(numCircles, circles.size());

        System.out.println("Circle instance = " + factory.newInstance());
        System.out.println(numCircles + " circles : " + circles);
    } // end void whenUsingCustomSupplierFactory_thenCreateManyObjects()

    @Test
    public void whenUsingGenericSupplierFactory_thenCreateCustomObjects() {

        // Factory with supplier
        final Factory<Circle> factory1 = Factory.createFactory(Circle::new);

        // Factory with function
        final Factory<Circle> factory2 = Factory.createFactory(
                Circle::new, //color -> new Circle(color),
                Color.RED);

        final Circle redCircle = factory2.newInstance();

        assertEquals(Color.RED, redCircle.getColor());
    } // end void whenUsingGenericSupplierFactory_thenCreateCustomObjects()

    @Test
    public void whenUsingGenericSupplierFactory_thenCreateSingletonObject() {

        final Factory<Circle> singletonFactory = Factory.createSingletonFactory(Circle::new);

        final Circle circle1 = singletonFactory.newInstance();//.get();
        final Circle circle2 = singletonFactory.newInstance();//.get();

        assertEquals(circle1, circle2);
    } // end void whenUsingGenericSupplierFactory_thenCreateSingletonObject()

    @Test
    public void test() {

        final Supplier<Circle> factory = () -> new Circle();
        final Circle circle = factory.get();
        System.out.println("circle = " + circle);
    }
} // end class FactoryTests



// Builder independent of the Factory


















