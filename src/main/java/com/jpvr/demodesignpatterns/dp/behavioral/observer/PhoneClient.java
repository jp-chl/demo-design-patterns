package com.jpvr.demodesignpatterns.dp.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class PhoneClient extends Observer {

    public PhoneClient(Subject subject) {

        this.subject = subject;
        subject.attach(this);
    } // end PhoneClient(Subject subject)

    public void addMessage(String message) {

        subject.setState("Message [" +message + "] sent from phone");
    } // end void addMessage(String message)

    @Override
    void update() {

        System.out.println("Phone Stream: " + subject.getState());
    } // end void update()
} // end class PhoneClient
