package com.jpvr.demodesignpatterns.dp.structural.bridge.shape2;

public class Square extends Shape {

    public Square(Color color) {
        super(color);
    } // end constructor

    @Override
    public void applyColor() {

        color.applyColor();
    } // end void applyColor()
} // end class Square extends Shape
