package com.jpvr.demodesignpatterns.dp.creational.factory;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteType siteType) {

        switch (siteType) {

            case BLOG:
                return new Blog();
            case SHOP:
                return new Shop();
            default:
                return null;
        } // end switch(siteType)
    } // end getWebsite

} // end class WebsiteFactory
