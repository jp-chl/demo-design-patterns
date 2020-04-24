package com.jpvr.demodesignpatterns.dp.structural.composite;

import java.util.Iterator;

public class Menu extends MenuComponent {

    public Menu(String name, String url) {

        this.name = name;
        this.url = url;
    } // end constructor

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(print(this));

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {

            MenuComponent menuComponent = iterator.next();

            // hierarchy
            menuComponent.url = this.url + menuComponent.url;

            builder.append(menuComponent.toString());
        } // end iteration

        return builder.toString();
    } // end String toString()

    @Override
    public MenuComponent add(MenuComponent menuComponent) {

        menuComponents.add(menuComponent);
        return menuComponent;
    } // end MenuComponent add(MenuComponent menuComponent)

    @Override
    public MenuComponent remove(MenuComponent menuComponent) {

        menuComponents.remove(menuComponent);
        return menuComponent;
    } // end MenuComponent remove(MenuComponent menuComponent)
} // end class Menu
