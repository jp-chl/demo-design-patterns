package com.jpvr.demodesignpatterns.dp.creational;

import com.jpvr.demodesignpatterns.dp.creational.factory.Website;
import com.jpvr.demodesignpatterns.dp.creational.factory.WebsiteFactory;
import com.jpvr.demodesignpatterns.dp.creational.factory.WebsiteType;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.TimeZone;

public class FactoryTests {

    @Test
    public void instancesTests() {

        //Calendar calendar = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    } // end

    @Test
    public void WebsiteFactoryTests() {

        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);

        System.out.println(site.getPages());
    } // end
} // end class FactoryTests
