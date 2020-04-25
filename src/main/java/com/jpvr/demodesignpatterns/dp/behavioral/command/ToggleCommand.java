package com.jpvr.demodesignpatterns.dp.behavioral.command;

public class ToggleCommand implements Command {

    private Light light;

    public ToggleCommand(Light light) {
        this.light = light;
    } // end ToggleCommand(Light light)

    @Override
    public void execute() {

        light.toggle();
    } // end void execute()
} // end class ToggleCommand implements Command
