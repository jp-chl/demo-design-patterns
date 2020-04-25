package com.jpvr.demodesignpatterns.dp.behavioral.observer;

public class TabletClient extends Observer {

    public TabletClient(Subject subject) {

        this.subject = subject;
        subject.attach(this);
    } // end TabletClient(Subject subject)

    public void addMessage(String message) {

        subject.setState("Message [" +message + "] sent from tablet");
    } // end void addMessage(String message)

    @Override
    void update() {

        System.out.println("Tablet Stream: " + subject.getState());
    } // end void update()
} // end class TabletClient extends Observer
