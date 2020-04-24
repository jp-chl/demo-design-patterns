package com.jpvr.demodesignpatterns.dp.structural.proxy;

public class TwitterServiceStub implements TwitterService {

    @Override
    public String getTimeline(String screenName) {
        return "My neat timeline";
    } // end String getTimeline(String screenName)

    @Override
    public void postToTimeline(String screenName, String message) {

    } // end void postToTimeline(String screenName, String message)
} // end class TwitterServiceStub implements TwitterService
