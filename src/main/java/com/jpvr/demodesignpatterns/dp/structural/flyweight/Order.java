package com.jpvr.demodesignpatterns.dp.structural.flyweight;

public class Order {

    private final int orderNumber;
    private final Item item;

    public Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    } // end constructor

    void processOrder() {

        System.out.println("Ordering " +
                item +
                " for order number " + orderNumber);
    } // end void processOrder()
} // end class Order
