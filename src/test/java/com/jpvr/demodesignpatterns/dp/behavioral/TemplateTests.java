package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.template.OrderTemplate;
import com.jpvr.demodesignpatterns.dp.behavioral.template.StoreOrder;
import com.jpvr.demodesignpatterns.dp.behavioral.template.WebOrder;
import org.junit.jupiter.api.Test;

public class TemplateTests {

    @Test
    public void templateDemo() {

        System.out.println("Web Order:");

        OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();

        System.out.println("\nStore Order:");

        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
    } // end void templateDemo()

} // end class TemplateTests
