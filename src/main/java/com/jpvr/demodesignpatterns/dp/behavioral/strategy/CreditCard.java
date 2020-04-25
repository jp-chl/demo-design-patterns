package com.jpvr.demodesignpatterns.dp.behavioral.strategy;

public class CreditCard {

    private String number;
    private String date;
    private String cvv;

    private ValidationStrategy strategy;

    public CreditCard(ValidationStrategy strategy) {
        this.strategy = strategy;
    } // end CreditCard(ValidationStrategy strategy)

    /**
     * Not necessarily must be implemented in this pattern
     * @return
     */
    public boolean isValid() {

        return strategy.isValid(this);
    } // end boolean isValid()

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
} // end class CreditCard
