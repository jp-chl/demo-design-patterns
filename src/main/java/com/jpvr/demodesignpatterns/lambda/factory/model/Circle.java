package com.jpvr.demodesignpatterns.lambda.factory.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle() {
        this(Color.WHITE);
    } // end Circle()

    public Circle(Color color) {
        this.color = color;
    } // end Circle(Color color)

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + color +
                '}';
    } // end String toString()
} // end class Circle
