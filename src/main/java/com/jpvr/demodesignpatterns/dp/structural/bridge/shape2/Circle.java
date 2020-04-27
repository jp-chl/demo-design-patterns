package com.jpvr.demodesignpatterns.dp.structural.bridge.shape2;

public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    } // end constructor

    @Override
    public void applyColor() {

        color.applyColor();
    } // end void applyColor()
} // end class Circle extends Shape
