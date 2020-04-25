package com.jpvr.demodesignpatterns.dp.behavioral.strategy;

public class VisaStrategy extends ValidationStrategy {

    @Override
    public boolean isValid(CreditCard creditCard) {

        boolean isValid = true;

        isValid = creditCard.getNumber().startsWith("4");

        if ( isValid ) {

            isValid = creditCard.getNumber().length() == 16;
        } // end if ( isValid )

        if ( isValid ) {

            isValid = passesLuhn(creditCard.getNumber());
        } // end if ( isValid )

        return isValid;
    } // end boolean isValid(CreditCard creditCard)
} // end class VisaStrategy extends ValidationStrategy {
