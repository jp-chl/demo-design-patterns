package com.jpvr.demodesignpatterns.dp.behavioral.template;

public class StoreOrder extends OrderTemplate {

    @Override
    public void doCheckout() {

        System.out.println("Ring up items from cart.");

    } // end void doCheckout()

    @Override
    public void doPayment() {

        System.out.println("Process payment with Card present");

    } // end doPayment()

    @Override
    public void doReceipt() {

        System.out.println("Print receipt");
    } // end doReceipt()

    @Override
    public void doDelivery() {

        System.out.println("Bag items at counter");
    } // end doDelivery()
} // end class StoreOrder extends OrderTemplate
