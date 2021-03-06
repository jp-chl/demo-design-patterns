package com.jpvr.demodesignpatterns.dp.creational.factory;

public class Shop extends Website {

    @Override
    public void createWebsite() {

        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    } // end void createWebsite()

} // end class Shop
