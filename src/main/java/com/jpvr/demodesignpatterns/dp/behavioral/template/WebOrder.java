package com.jpvr.demodesignpatterns.dp.behavioral.template;

public class WebOrder extends OrderTemplate {

    @Override
    public void doCheckout() {

        System.out.println("Get items from cart,");
        System.out.println("Set gift preferences,");
        System.out.println("Set delivery address,");
        System.out.println("Set billing address.");

    } // end void doCheckout()

    @Override
    public void doPayment() {

        System.out.println("Process payment without Card present");

    } // end doPayment()

    @Override
    public void doReceipt() {

        System.out.println("Email receipt");
    } // end doReceipt()

    @Override
    public void doDelivery() {

        System.out.println("Ship the item to address");
    } // end doDelivery()
} // end class WebOrder extends OrderTemplate
