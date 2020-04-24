package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.proxy.SecurityProxy;
import com.jpvr.demodesignpatterns.dp.structural.proxy.TwitterService;
import com.jpvr.demodesignpatterns.dp.structural.proxy.TwitterServiceStub;
import org.junit.jupiter.api.Test;

public class ProxyTests {

    @Test
    public void twitterDemo() {

        TwitterService service = (TwitterService) SecurityProxy.newInstance(
                new TwitterServiceStub());

        System.out.println(service.getTimeline("jp"));
    } // end void twitterDemo()
} // end class ProxyTests
