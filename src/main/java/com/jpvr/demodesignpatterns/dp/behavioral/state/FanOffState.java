package com.jpvr.demodesignpatterns.dp.behavioral.state;

public class FanOffState extends State {

    private Fan fan;

    public FanOffState(Fan fan) {

        this.fan = fan;
    } // end FanOffState(Fan fan)

    @Override
    public void handleRequest() {
        System.out.println("Turning fan on to low.");
        fan.setState(fan.getFanLowState());
    } // end void handleRequest()

    @Override
    public String toString() {
        return "Fan is off.";
    } // end String toString()
} // end class FanOffState extends State
