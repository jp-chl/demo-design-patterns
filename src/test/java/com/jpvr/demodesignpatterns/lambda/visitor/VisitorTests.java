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
        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car: " + c)
                        .forType(Engine.class).execute((Engine e) -> "Visiting engine: " + e)
                        .forType(Body.class).execute((Body b) -> "Visiting engine: " + b);


//        Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car: " + c)
//                .forType(Engine.class).execute((Engine e) -> "Visiting engine: " + e)
//                .forType(Body.class).execute((Body b) -> "Visiting body: " + b);

//        Consumer<VisitorBuilder<String>> consumer2 =
//                Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car: " + c)
//                        .forType(Engine.class).execute((Engine e) -> "Visiting engine: " + e)
//                        .forType(Body.class).execute((Body b) -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);


        String visitedEngine = visitor.visit(engine);
        System.out.println("visitedEngine = " + visitedEngine);

        String visitedCard = visitor.visit(car);
        System.out.println("visitedCard = " + visitedCard);

        String visitedBody = visitor.visit(body);
        System.out.println("visitedBody = " + visitedBody);



//        visitor.visit(body);
    } // end
} // end class VisitorTests
