package com.jpvr.demodesignpatterns.dp.structural.flyweight;

public class Item {

    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
//        return "Item{" +
//                "name='" + name + '\'' +
//                '}';
    } // end String toString()
} // end class Item
