package com.jpvr.demodesignpatterns.dp.behavioral.mediator;

import com.jpvr.demodesignpatterns.dp.behavioral.mediator.Command;

// concrete command
public class TurnOnAllLightsCommand implements Command {

    private Mediator mediator;

    public TurnOnAllLightsCommand(Mediator mediator) {

        this.mediator = mediator;
    } // end constructor

    @Override
    public void execute() {

        mediator.turnOnAllLights();
    } // end void execute()
} // end class TurnOnAllLightsCommand implements Command
