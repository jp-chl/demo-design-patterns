package com.jpvr.demodesignpatterns.dp.structural.composite;

public class MenuItem extends MenuComponent {

    public MenuItem(String name, String url) {

        this.name = name;
        this.url = url;
    } // end constructor


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(print(this));

        return builder.toString();

        //return print(this);
    } // end String toString()
} // end class MenuItem extends MenuComponent
