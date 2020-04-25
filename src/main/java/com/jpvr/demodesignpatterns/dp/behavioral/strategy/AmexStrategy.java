package com.jpvr.demodesignpatterns.dp.behavioral.strategy;

public class AmexStrategy extends ValidationStrategy {

    @Override
    public boolean isValid(CreditCard creditCard) {

        boolean isValid = true;

        isValid = creditCard.getNumber().startsWith("37") ||
                creditCard.getNumber().startsWith("34");

        if ( isValid ) {

            isValid = creditCard.getNumber().length() == 15;
        } // end if ( isValid )

        if ( isValid ) {

            isValid = passesLuhn(creditCard.getNumber());
        } // end if ( isValid )

        return isValid;
    } // end boolean isValid(CreditCard creditCard)
} // end class AmexStrategy extends ValidationStrategy
