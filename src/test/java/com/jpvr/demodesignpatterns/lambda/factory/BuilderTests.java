package com.jpvr.demodesignpatterns.lambda.factory;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Rectangle;
import com.jpvr.demodesignpatterns.lambda.factory.registry.Builder;
import com.jpvr.demodesignpatterns.lambda.factory.registry.Registry;
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

    @Test
    public void test() {

        // This method can be modeled as a consumer.
        // And can be called with the accept() function.
        //
        // builder.register("rectangle", Rectangle::new);

        Consumer<Builder<Rectangle>> consumer =
                builder ->
                    builder.register("rectangle", Rectangle::new);

        final Registry registry = Registry.createRegistry(consumer);
    } // end
} // end class BuilderTests
