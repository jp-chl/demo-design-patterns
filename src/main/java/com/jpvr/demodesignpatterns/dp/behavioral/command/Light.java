package com.jpvr.demodesignpatterns.dp.behavioral.command;

// receiver
public class Light {

    private boolean isOn = false;

    public void toggle() {

        if ( isOn ) {

            off();
        } else {

            on();
        }

        isOn = !isOn;
    } // end void toggle()

    public void on() {

        System.out.println("Light switched on");
    }

    public void off() {

        System.out.println("Light switched off");
    }
}
