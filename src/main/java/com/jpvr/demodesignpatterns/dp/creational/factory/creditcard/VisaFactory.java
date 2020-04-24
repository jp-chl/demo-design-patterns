package com.jpvr.demodesignpatterns.dp.creational.factory.creditcard;

public class VisaFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {

        switch (cardType) {
            case GOLD:
                return new VisaGoldCreditCard();
            case PLATINUM:
                return new VisaBlackCreditCard();
        }

        return null;
    } // end

    @Override
    public Validator getValidator(CardType cardType) {

        return new VisaValidator();
    } // end Validator getValidator(CardType cardType)

} // end class VisaFactory
