package com.jpvr.demodesignpatterns.dp.behavioral.template;

public abstract class OrderTemplate {

    public boolean isGift;

    public abstract void doCheckout();
    public abstract void doPayment();
    public abstract void doReceipt();
    public abstract void doDelivery();

    public final void wrapGift() {

        System.out.println("Gift wrapped.");
    }  // end public final void wrapGift()

    public final void processOrder() {

        doCheckout();
        doPayment();

        if ( isGift ) {

            wrapGift();
        } else {

            doReceipt();
        }

        doDelivery();

    } // end public final void processOrder()
} // end abstract class OrderTemplate
