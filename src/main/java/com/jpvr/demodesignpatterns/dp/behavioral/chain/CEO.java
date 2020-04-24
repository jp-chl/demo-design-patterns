package com.jpvr.demodesignpatterns.dp.behavioral.chain;

public class CEO extends Handler {
    @Override
    public void handleRequest(Request request) {

        System.out.println("CEOs can approve anything they want");
    } // end void handleRequest(Request request)
} // end class CEO extends Handler
