package com.jpvr.demodesignpatterns.lambda.visitor;

import com.jpvr.demodesignpatterns.lambda.visitor.model.Body;
import com.jpvr.demodesignpatterns.lambda.visitor.model.Car;
import com.jpvr.demodesignpatterns.lambda.visitor.model.Engine;
import org.junit.Test;

import java.util.function.Consumer;

public class VisitorTests {

    @Test
    public void test() {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        // Consumer is a function that takes objects
        // and return R (String in this case)
        Consumer<VisitorBuilder<String>> consumer = Visitor
                        .<String>forType(Car.class)
                        .execute( c -> "Visiting car: " + c);

        Visitor<String> visitor = Visitor.of(consumer);

        String visitedCard = visitor.visit(car);
        System.out.println("visitedCard = " + visitedCard);

//        visitor.visit(engine);
//        visitor.visit(body);
    } // end
} // end class VisitorTests
