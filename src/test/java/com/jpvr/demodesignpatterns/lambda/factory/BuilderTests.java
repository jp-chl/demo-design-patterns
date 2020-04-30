package com.jpvr.demodesignpatterns.lambda.factory;

import com.jpvr.demodesignpatterns.lambda.factory.factory.Factory;
import com.jpvr.demodesignpatterns.lambda.factory.model.Rectangle;
import com.jpvr.demodesignpatterns.lambda.factory.registry.SwitchRegistry;
import org.junit.Test;

public class BuilderTests {

    @SuppressWarnings("unchecked") // to avoid the "unchecked cast" warning on (Factory<Rectangle>) registry.buildShapeFactory("rectangle")
    @Test
    public void test() {

        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");

        System.out.println("rectangleFactory.newInstance() = " + rectangleFactory.newInstance());
    } // end
} // end class BuilderTests
