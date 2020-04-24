package com.jpvr.demodesignpatterns.dp.structural.bridge.shape2;

public class Square extends Shape {

    public Square(Color color) {
        super(color);
    } // end

    @Override
    public void applyColor() {

        color.applyColor();
    } // end
} // end class Square extends Shape
