package com.jpvr.demodesignpatterns.lambda.factory;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Rectangle;
import com.jpvr.demodesignpatterns.lambda.factory.model.Shape;
import com.jpvr.demodesignpatterns.lambda.factory.model.Square;
import com.jpvr.demodesignpatterns.lambda.factory.model.Triangle;
import com.jpvr.demodesignpatterns.lambda.factory.registry.Builder;
import com.jpvr.demodesignpatterns.lambda.factory.registry.Registry;
import com.jpvr.demodesignpatterns.lambda.factory.registry.ShapeRegistry;
import com.jpvr.demodesignpatterns.lambda.factory.registry.SwitchRegistry;
import org.junit.Test;

import java.util.function.Consumer;

public class BuilderTests {

    @SuppressWarnings("unchecked") // to avoid the "unchecked cast" warning on (Factory<Rectangle>) registry.buildShapeFactory("rectangle")
    @Test
    public void shouldCreateSimpleObjectFactory() {

        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");

        System.out.println("rectangleFactory.newInstance() = " + rectangleFactory.newInstance());
    } // end void shouldCreateSimpleObjectFactory

    @SuppressWarnings("unchecked")
    @Test
    public void shouldCreateRectangleFactory() {

        // This method can be modeled as a consumer.
        // And can be called with the accept() function.
        //
        // builder.register("rectangle", Rectangle::new);

        Consumer<Builder<Rectangle>> consumer =
                builder ->
                    builder.register("rectangle", Rectangle::new);

        final Registry registry = Registry.createRegistry(consumer);

        final Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");

        Rectangle rectangle = rectangleFactory.newInstance();
        System.out.println("Rectangle = " + rectangle);
    } // end void shouldCreateRectangleFactory

    @SuppressWarnings("unchecked")
    @Test
    public void shouldCreateRectangleAndTriangleFactory() {

        final Consumer<Builder<Shape>> consumer1 =
                builder ->
                        builder.register("rectangle", Rectangle::new);

        final Consumer<Builder<Shape>> consumer2 =
                builder ->
                        builder.register("triangle", Triangle::new);

        final Consumer<Builder<Shape>> consumer = consumer1.andThen(consumer2);

        final ShapeRegistry registry = ShapeRegistry.createShapeRegistry(consumer);

        Factory<Shape> buildRectangleFactory = registry.buildShapeFactory("rectangle");
        Rectangle rectangle = (Rectangle) buildRectangleFactory.newInstance();
        System.out.println("Rectangle = " + rectangle);

        // Factory<Shape> buildTriangleFactory  = registry.buildShapeFactory("triangle");
        // Triangle triangle = (Triangle) buildTriangleFactory.newInstance();
        Triangle triangle =
                (Triangle) registry.buildShapeFactory("triangle").newInstance();
        System.out.println("Triangle = " + triangle);
    } // end void shouldCreateRectangleAndTriangleFactory()

    @Test
    public void shouldCreateShapesFactory() {

        final Consumer<Builder<Shape>> consumer1 =
                builder ->
                        builder.register("rectangle", Rectangle::new);

        final Consumer<Builder<Shape>> consumer2 =
                builder ->
                        builder.register("triangle", Triangle::new);

        final Consumer<Builder<Shape>> consumer3 =
                builder -> builder.register("square", Square::new);

        Consumer<Builder<Shape>> consumer4 = consumer1.andThen(consumer2);
        final Consumer<Builder<Shape>> consumer = consumer4.andThen(consumer3);

        final ShapeRegistry registry = ShapeRegistry.createShapeRegistry(consumer);

        Rectangle rectangle =
                (Rectangle) registry.buildShapeFactory("rectangle").newInstance();
        System.out.println("Rectangle = " + rectangle);

        Square square =
                (Square) registry.buildShapeFactory("square").newInstance();
        System.out.println("Square = " + square);

    } // end void shouldCreateShapesFactory()
} // end class BuilderTests
