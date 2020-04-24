package com.jpvr.demodesignpatterns.dp.structural.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventorySystem {

    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList<Order>();

    public void takeOrder(String itemName, int orderNumber) {

        Item item = catalog.lookup(itemName);
        Order order = new Order(orderNumber, item);

        orders.add(order);
    } // end takeOrder(String itemName, int orderNumber)

    public void process() {

        for(Order order : orders) {

            order.processOrder();
            orders.remove(order);
        } // end iteration
    } // end void process()

    public String report() {

        return "\nTotal Item objects made: " +
                catalog.totalItemsMade();
    } // end String report()
} // end class InventorySystem
