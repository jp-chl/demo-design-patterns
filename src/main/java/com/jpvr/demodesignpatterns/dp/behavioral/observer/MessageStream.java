package com.jpvr.demodesignpatterns.dp.behavioral.observer;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageStream extends Subject {

    private Deque<String> messageHistory = new ArrayDeque<>();

    @Override
    void setState(String message) {

        messageHistory.add(message);
        this.notifyObservers();
    } // end setState(String message)

    @Override
    String getState() {

        return messageHistory.getLast();
    } // end String getState()
} // end class MessageStream extends Subject
