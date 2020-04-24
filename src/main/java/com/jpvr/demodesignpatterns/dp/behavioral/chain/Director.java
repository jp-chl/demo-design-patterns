package com.jpvr.demodesignpatterns.dp.behavioral.chain;

public class Director extends Handler {


    @Override
    public void handleRequest(Request request) {

        if ( request.getRequestType() == RequestType.CONFERENCE ) {

            System.out.println("Directors can approve conferences");
        } else {

            successor.handleRequest(request);
        }
    } // end void handleRequest(Request request)
} // end class Director extends Handler
