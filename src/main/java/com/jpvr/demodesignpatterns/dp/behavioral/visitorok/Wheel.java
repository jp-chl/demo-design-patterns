package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

public class Wheel implements AtvPart {

    @Override
    public void accept(AtvPartVisitor visitor) {

        visitor.visit(this);
    } // end void accept(AtvPartVisitor visitor)
} // end class Wheel implements AtvPart
