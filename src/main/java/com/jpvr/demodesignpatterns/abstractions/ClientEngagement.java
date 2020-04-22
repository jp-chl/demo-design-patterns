package com.jpvr.demodesignpatterns.abstractions;

public class ClientEngagement {

    private final String client;
    private final int hoursWorked;
    private int id;

    public ClientEngagement(String client, int hoursWorked) {
        this.client = client;
        this.hoursWorked = hoursWorked;
    }

    public String getClient() {
        return client;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public int getId() {
        return id;
    }
} // end class ClientEngagement
