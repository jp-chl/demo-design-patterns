package com.jpvr.demodesignpatterns.dp.structural.shape2;

public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    } // end

    @Override
    public void applyColor() {

        color.applyColor();
    } // end
} // end class Circle extends Shape
