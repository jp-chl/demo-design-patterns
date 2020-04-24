package com.jpvr.demodesignpatterns.dp.creational.factory.creditcard;

public class AmexGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
