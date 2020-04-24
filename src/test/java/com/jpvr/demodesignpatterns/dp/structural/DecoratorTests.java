package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.decorator.DressingDecorator;
import com.jpvr.demodesignpatterns.dp.structural.decorator.MeatDecorator;
import com.jpvr.demodesignpatterns.dp.structural.decorator.Sandwich;
import com.jpvr.demodesignpatterns.dp.structural.decorator.SimpleSandwich;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DecoratorTests {

    @Test
    public void decoratorIOStreamTest() throws IOException {

        File file = new File("output.txt");
        file.createNewFile();

        try (
                // OutputStream is the base decorator. FileOutputStream is the concrete decorator
                OutputStream outputStream = new FileOutputStream(file);

                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                ) {

            dataOutputStream.writeChars("text");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end void decoratorIOStreamTest()

    @Test
    public void sandwichDecoratorTest() {

        Sandwich sandwichWithMeatAndDressing = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
        Sandwich sandwichWithDressing = new DressingDecorator(new SimpleSandwich());
        Sandwich sandwichSimple = new MeatDecorator(new SimpleSandwich());

        Assertions.assertEquals("Simple Sandwich made of Bread + turkey + mustard", sandwichWithMeatAndDressing.make());
        Assertions.assertEquals("Simple Sandwich made of Bread + mustard",sandwichWithDressing.make() );
        Assertions.assertEquals("Simple Sandwich made of Bread + turkey", sandwichSimple.make());
    } // end void sandwichDecoratorTest()

} // end class DecoratorTests
