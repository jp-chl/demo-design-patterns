package com.jpvr.demodesignpatterns.dp.behavioral.mediator;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class MediatorEverydayDemo {

    private Toolkit toolkit;
    private Timer timer;

    public MediatorEverydayDemo(int seconds) {

        toolkit = Toolkit.getDefaultToolkit();

        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
        timer.schedule(new RemindTaskWithoutBeep(), seconds * 2 * 1000);
    } // end MediatorEverydayDemo(int seconds)

    public static void main(String args[]) {

        System.out.println("About to schedule task.");
        new MediatorEverydayDemo(3);
        System.out.println("Task scheduled.");
    } // end static void main(String args[])

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Time's up!");
            toolkit.beep();
        }
    } // end class RemindTask extends TimerTask

    class RemindTaskWithoutBeep extends TimerTask {
        @Override
        public void run() {
            System.out.println("Now Time's really up!");
        }
    } // end class RemindTaskWithoutBeep extends TimerTask
} // end class MediatorEverydayDemo
