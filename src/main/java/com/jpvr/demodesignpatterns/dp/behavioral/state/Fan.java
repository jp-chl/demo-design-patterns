package com.jpvr.demodesignpatterns.dp.behavioral.state;

public class Fan {

    State fanOffState;
    State fanLowState;
    State fanMedState;
    State fanHigState;

    State state;

    public Fan() {

        fanOffState = new FanOffState(this);
        fanLowState = new FanLowState(this);
        fanMedState = new FanMedState(this);
        fanHigState = new FanHigState(this);

        state = fanOffState;
    } // end Fan()

    public void pullChain() {

        state.handleRequest();
    } // end void pullChain()

    @Override
    public String toString() {

        return state.toString();
    } // end String toString()

    public State getFanOffState() {
        return fanOffState;
    } // end State getFanOffState()

    public State getFanLowState() {

        return fanLowState;
    } // end State getFanLowState()

    public State getFanMedState() {
        return fanMedState;
    } // end State getFanMedState()

    public State getFanHigState() {
        return fanHigState;
    } // end State getFanHigState()

    public void setState(State state) {

        this.state = state;
    } // end void setState(State state)
} // end class Fan
