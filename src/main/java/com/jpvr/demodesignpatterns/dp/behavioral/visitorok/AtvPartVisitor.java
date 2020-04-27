package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

public interface AtvPartVisitor {
    void visit(Wheel wheel);
    void visit(Fender wheel);
    void visit(Oil wheel);
    void visit(PartsOrder wheel);
} // end interface AtvPartVisitor
