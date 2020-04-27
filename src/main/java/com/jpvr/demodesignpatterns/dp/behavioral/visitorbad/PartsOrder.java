package com.jpvr.demodesignpatterns.dp.behavioral.visitorbad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsOrder implements AtvPart {

    private List<AtvPart> parts = new ArrayList<>();

    public PartsOrder() {
    } // end constructor

    public void addPart(AtvPart atvPart) {

        parts.add(atvPart);
    } // end void addPart(AtvPart atvPart)

    public List<AtvPart> getParts() {

        return Collections.unmodifiableList(parts);
    } // end List<AtvPart> getParts()

    public double calculateShipping() {

        double shippingCost = 0;

        for(AtvPart atvPart : parts) {

            shippingCost += atvPart.calculateShipping();
        } // end iteration

        return shippingCost;
    } // end void calculateShipping()
} // end class PartsOrder implements AtvPart
