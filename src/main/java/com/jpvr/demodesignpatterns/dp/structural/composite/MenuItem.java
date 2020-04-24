package com.jpvr.demodesignpatterns.dp.structural.composite;

public class MenuItem extends MenuComponent {

    public MenuItem(String name, String url) {

        this.name = name;
        this.url = url;
    } // end constructor


    @Override
    public String toString() {
        return print(this);
    } // end String toString()
} // end class MenuItem extends MenuComponent
