package com.jpvr.demodesignpatterns.dp.creational.factory;

public class Blog extends Website {


    @Override
    public void createWebsite() {

        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    } // end void createWebsite()

} // end class Blog extends Website
