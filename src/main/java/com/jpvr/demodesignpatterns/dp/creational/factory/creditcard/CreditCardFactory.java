package com.jpvr.demodesignpatterns.dp.creational.factory.creditcard;

public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore) {

        if ( creditScore > 650 ) {

            return new AmexFactory();
        } else {

            return new VisaFactory();
        }
    } // end static getCreditCardFactory(int score)

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract Validator getValidator(CardType cardType);
} // end abstract class CreditCardFactory
