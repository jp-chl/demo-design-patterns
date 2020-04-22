package com.jpvr.demodesignpatterns.abstractions;

public class Query {

    private String client;
    private int atLeastHoursWorked;

    public Query client(String client) {
        this.client = client;
        return this;
    }

    public Query atLeastHoursWorked(int atLeastHoursWorked) {
        this.atLeastHoursWorked = atLeastHoursWorked;
        return this;
    }

    public String getClient() {
        return client;
    }

    public int getAtLeastHoursWorked() {
        return atLeastHoursWorked;
    }


} // end class Query
