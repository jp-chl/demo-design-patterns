package com.jpvr.demodesignpatterns.dp.behavioral.chain;

public class VP extends Handler {


    @Override
    public void handleRequest(Request request) {

        if ( request.getRequestType() == RequestType.PURCHASE ) {

            if ( request.getAmount() < 1500 ) {

                System.out.println("VPs can approve purchases below 1500");
            } else {

                successor.handleRequest(request);
            }
        } // only purchases allowed

    } // end void handleRequest(Request request)
} // end class VP extends Handler
