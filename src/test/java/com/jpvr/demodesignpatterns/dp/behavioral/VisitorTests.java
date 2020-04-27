package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.Fender;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.Oil;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.PartsOrder;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorbad.Wheel;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorok.AtvPartsDisplayVisitor;
import com.jpvr.demodesignpatterns.dp.behavioral.visitorok.AtvPartsShippingVisitor;
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

    @Test
    public void visitorOkDemo() {

        com.jpvr.demodesignpatterns.dp.behavioral.visitorok.PartsOrder order = new com.jpvr.demodesignpatterns.dp.behavioral.visitorok.PartsOrder();
        order.addPart(new com.jpvr.demodesignpatterns.dp.behavioral.visitorok.Wheel());
        order.addPart(new com.jpvr.demodesignpatterns.dp.behavioral.visitorok.Fender());
        order.addPart(new com.jpvr.demodesignpatterns.dp.behavioral.visitorok.Oil());

        order.accept(new AtvPartsShippingVisitor());
        order.accept(new AtvPartsDisplayVisitor());
    } // end void visitorOkDemo()

} // end class VisitorTests
