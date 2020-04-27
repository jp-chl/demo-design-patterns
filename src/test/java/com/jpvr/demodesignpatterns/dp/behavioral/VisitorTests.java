package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.Fender;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.Oil;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.PartsOrder;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.Wheel;
import org.junit.jupiter.api.Test;

public class VisitorTests {

    @Test
    public void visitorBadDemo() {

        PartsOrder order = new PartsOrder();
        order.addPart(new Wheel());
        order.addPart(new Fender());
        order.addPart(new Oil());

        double shippingCost = order.calculateShipping();

        System.out.println("shippingCost = " + shippingCost);
    } // end void visitorBadDemo()

} // end class VisitorTests
