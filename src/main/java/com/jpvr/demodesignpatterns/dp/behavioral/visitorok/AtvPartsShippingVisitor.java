package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

import java.util.List;

public class AtvPartsShippingVisitor implements AtvPartVisitor {

    double shippingAmount = 0;

    @Override
    public void visit(Wheel wheel) {

        final int shippingFee = 15;
        shippingAmount += shippingFee;
        System.out.println("Wheels are bulky and expensive to ship. Fee: " + shippingFee);
    } // end void visit(Wheel wheel)

    @Override
    public void visit(Fender fender) {

        final int shippingFee = 3;
        shippingAmount += shippingFee;
        System.out.println("Fenders are light and cheap to ship. Fee: " + shippingFee);
    } // end void visit(Fender wheel)

    @Override
    public void visit(Oil oil) {

        final int shippingFee = 9;
        shippingAmount += shippingFee;
        System.out.println("Oil is hazardous and has a fee to ship. Fee: " + shippingFee);
    } // end void visit(Oil wheel)

    @Override
    public void visit(PartsOrder order) {

        System.out.println("If they bought more than 3 things we will give them a discount on shipping.");
        List<AtvPart> parts = order.getParts();
        if ( parts.size() > 3 ) {
            shippingAmount -= 5;
        }
        System.out.println("Shipping amount is: " + shippingAmount);
    } // end void visit(PartsOrder wheel)

} // end class AtvPartsShippingVisitor implements AtvPartVisitor
