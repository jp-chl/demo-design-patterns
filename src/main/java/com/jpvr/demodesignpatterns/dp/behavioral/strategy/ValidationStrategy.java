package com.jpvr.demodesignpatterns.dp.behavioral.strategy;

public abstract class ValidationStrategy {

    public abstract boolean isValid(CreditCard creditCard);

    protected boolean passesLuhn(String ccNumber) {

        int sum = 0;
        boolean alternate = false;

        for(int i = ccNumber.length() - 1; i >= 0; i--) {

            int n = Integer.parseInt(ccNumber.substring(i, i+1));

            if (alternate) {

                n *= 2;
                if ( n > 9 ) {

                    n = (n % 10) + 1;
                } // end if ( n > 9 )
            } // end if (alternate)

            sum += n;
            alternate = !alternate;
        } // end iteration

        return (sum % 10 == 0);
    } // end boolean passesLuhn(String ccNumber)
} // end abstract class ValidationStrategy
