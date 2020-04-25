package com.jpvr.demodesignpatterns.dp.behavioral.mediator;

public class Light {

    private boolean isOn = false;

    private String location = "";

    public Light(String location) {
        this.location = location;
    }

    public void toggle() {

        if ( isOn() ) {

            off();
        } else {

            on();
        }

        isOn = !isOn;
    } // end void toggle()

    public void on() {

        System.out.println(location + " switched on");
    } // end void on()

    public void off() {

        System.out.println( location + " switched off");
    } // end void off()

    public boolean isOn() {
        return isOn;
    } // end boolean isOn()

    public String getLocation() {
        return location;
    } // end String getLocation()
} // end class Light
