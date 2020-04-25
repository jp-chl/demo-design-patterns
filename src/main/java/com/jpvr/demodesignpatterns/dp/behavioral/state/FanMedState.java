package com.jpvr.demodesignpatterns.dp.behavioral.state;

public class FanMedState extends State {

    private Fan fan;

    public FanMedState(Fan fan) {

        this.fan = fan;
    } // end FanMedState(Fan fan)

    @Override
    public void handleRequest() {
        System.out.println("Turning fan on to high.");
        fan.setState(fan.getFanHigState());
    } // end void handleRequest()

    @Override
    public String toString() {
        return "Fan is on medium.";
    } // end String toString()
} // end class FanMedState extends State
