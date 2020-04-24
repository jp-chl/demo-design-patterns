package com.jpvr.demodesignpatterns.dp.creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    } // end

    public List<Page> getPages() {
        return pages;
    }

    public abstract void createWebsite();
} // end abstract class Website
