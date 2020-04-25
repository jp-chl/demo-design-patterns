package com.jpvr.demodesignpatterns.dp.behavioral.state;

public class FanLowState extends State {

    private Fan fan;

    public FanLowState(Fan fan) {

        this.fan = fan;
    } // end FanLowState(Fan fan)

    @Override
    public void handleRequest() {
        System.out.println("Turning fan on to med.");
        fan.setState(fan.getFanMedState());
    } // end void handleRequest()

    @Override
    public String toString() {
        return "Fan is on low.";
    } // end String toString()
} // end class FanLowState extends State
