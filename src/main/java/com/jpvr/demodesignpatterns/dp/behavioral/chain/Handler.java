package com.jpvr.demodesignpatterns.dp.behavioral.chain;

public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {

        this.successor = successor;
    } // end void setSuccessor(Handler successor)

    public abstract void handleRequest(Request request);

} // end abstract class Handler
