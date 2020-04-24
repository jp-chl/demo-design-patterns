package com.jpvr.demodesignpatterns.dp.structural.proxy;

public interface TwitterService {

    public String getTimeline(String screenName);
    public void postToTimeline(String screenName, String message);
} // end interface TwitterService
