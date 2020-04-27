package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

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

    @Override
    public void accept(AtvPartVisitor visitor) {

        for(AtvPart atvPart : parts) {
            atvPart.accept(visitor);
        }
        visitor.visit(this);
    } // end void accept(AtvPartVisitor visitor)
} // end class PartsOrder implements AtvPart
