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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTests {

    @SuppressWarnings("unchecked") // to avoid the "unchecked cast" warning on (Factory<Rectangle>) registry.buildShapeFactory("rectangle")
    @Test
    public void shouldCreateSimpleObjectFactory() {

        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");

        final Rectangle rectangle = rectangleFactory.newInstance();
        assertEquals(Rectangle.class, rectangle.getClass());
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
        assertEquals(Rectangle.class, rectangle.getClass());
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

        // Now with Shape generic Factory
        final ShapeRegistry registry = ShapeRegistry.createShapeRegistry(consumer);

        Factory<Shape> buildRectangleFactory = (Factory<Shape>) registry.buildShapeFactory("rectangle");
        Rectangle rectangle = (Rectangle) buildRectangleFactory.newInstance();
        assertEquals(Rectangle.class, rectangle.getClass());

        // Factory<Shape> buildTriangleFactory  = registry.buildShapeFactory("triangle");
        // Triangle triangle = (Triangle) buildTriangleFactory.newInstance();
        Triangle triangle =
                (Triangle) registry.buildShapeFactory("triangle").newInstance();
        assertEquals(Triangle.class, triangle.getClass());
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
        assertEquals(Rectangle.class, rectangle.getClass());

        Square square =
                (Square) ShapeRegistry.createShapeRegistry(consumer).buildShapeFactory("square").newInstance();
        assertEquals(Square.class, square.getClass());
    } // end void shouldCreateShapesFactory()

    @SuppressWarnings("unchecked")
    @Test
    public void shouldCreateShapesFactoryWithErrorHandling() {

        final Consumer<Builder<Shape>> consumer1 =
                builder ->
                        builder.register("rectangle", Rectangle::new);

        final Consumer<Builder<Shape>> consumer2 =
                builder ->
                        builder.register("triangle", Triangle::new);

        final Consumer<Builder<Shape>> consumer = consumer1.andThen(consumer2);

        final ShapeRegistry registry =
                ShapeRegistry.createShapeRegistryWithErrorHandling(consumer);

        final Factory<Square> buildSquareFactory =
                (Factory<Square>) registry.buildShapeFactory("square");

        //final Square square = buildSquareFactory.newInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            buildSquareFactory.newInstance();
        });
    } // end void shouldCreateShapesFactoryWithErrorHandling()
} // end class BuilderTests
