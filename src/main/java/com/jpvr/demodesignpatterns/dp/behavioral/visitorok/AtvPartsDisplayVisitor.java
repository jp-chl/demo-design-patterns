package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

public class AtvPartsDisplayVisitor implements AtvPartVisitor {
    @Override
    public void visit(Wheel wheel) {

        System.out.println("We have a wheel");
    } // end void visit(Wheel wheel)

    @Override
    public void visit(Fender fender) {

        System.out.println("We have a fender");
    } // end void visit(Fender wheel)

    @Override
    public void visit(Oil oil) {

        System.out.println("We have oil");
    } // end void visit(Oil wheel)

    @Override
    public void visit(PartsOrder order) {

        System.out.println("We have an order");
    } // end void visit(PartsOrder wheel)
} // end class AtvPartsDisplayVisitor
