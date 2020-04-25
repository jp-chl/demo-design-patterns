package com.jpvr.demodesignpatterns.dp.behavioral.state;

public class FanHigState extends State {

    private Fan fan;

    public FanHigState(Fan fan) {

        this.fan = fan;
    } // end FanHigState(Fan fan)

    @Override
    public void handleRequest() {
        System.out.println("Turning fan off.");
        fan.setState(fan.getFanOffState());
    } // end void handleRequest()

    @Override
    public String toString() {
        return "Fan is on high.";
    } // end String toString()
} // end class FanHigState extends State
