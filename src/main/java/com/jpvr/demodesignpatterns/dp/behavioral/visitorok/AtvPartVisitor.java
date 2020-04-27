package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

public interface AtvPartVisitor {

    void visit(Wheel wheel);
    void visit(Fender fender);
    void visit(Oil oil);
    void visit(PartsOrder order);
} // end interface AtvPartVisitor
