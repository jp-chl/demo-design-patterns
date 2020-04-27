package com.jpvr.demodesignpatterns.dp.creational.factory.creditcard;

public class AmexFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {

        switch (cardType) {

            case GOLD:
                return new AmexGoldCreditCard();

            case PLATINUM:
                return new AmexPlatinumCreditCard();

            default:
                break;
        }

        return null;
    } // end CreditCard getCreditCard(CardType cardType)

    @Override
    public Validator getValidator(CardType cardType) {

        switch (cardType) {

            case GOLD:
                return new AmexGoldValidator();
            case PLATINUM:
                return new AmexPlatinumValidator();

            default:
                break;
        }

        return null;
    } // end Validator getValidator(CardType cardType)
} // end class AmexFactory extends CreditCardFactory
