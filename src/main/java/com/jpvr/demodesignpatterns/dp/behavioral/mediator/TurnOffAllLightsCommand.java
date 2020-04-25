package com.jpvr.demodesignpatterns.dp.behavioral.mediator;

public class TurnOffAllLightsCommand implements Command {

    private Mediator mediator;

    public TurnOffAllLightsCommand(Mediator mediator) {

        this.mediator = mediator;
    } // end constructor

    @Override
    public void execute() {

        mediator.turnOffAllLights();
    } // end void execute()
} // end class TurnOffAllLightsCommand implements Command
