package com.jpvr.demodesignpatterns.dp.creational.factory.creditcard;

public class VisaValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {

        return false;
    } // end boolean isValid(CreditCard creditCard)
} // end class VisaValidator implements Validator
