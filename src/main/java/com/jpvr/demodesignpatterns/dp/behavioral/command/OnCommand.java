package com.jpvr.demodesignpatterns.dp.behavioral.command;

public class OnCommand implements Command {

    private Light light;

    public OnCommand(Light light) {

        this.light = light;
    } // end OnCommand(Light light)

    @Override
    public void execute() {

        light.on();
    } // end void execute()
} // end class OnCommand implements Command
