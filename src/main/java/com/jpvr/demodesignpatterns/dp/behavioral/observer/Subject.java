package com.jpvr.demodesignpatterns.dp.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    abstract void setState(String state);
    abstract String getState();

    public void attach(Observer observer) {

        observers.add(observer);
    } // end void attach(Observer observer)

    public void detach(Observer observer) {

        observers.remove(observer);
    } // end void detach(Observer observer)

    public void notifyObservers() {

        for(Observer observer : observers) {

            observer.update();
        } // end iteration
    } // end void notifyObservers()
} // end abstract class Subject
