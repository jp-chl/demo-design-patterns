package com.jpvr.demodesignpatterns.dp.structural.bridge.shape2;

public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
} // end abstract class Shape
