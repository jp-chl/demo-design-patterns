package com.jpvr.demodesignpatterns.dp.behavioral.command;

import java.util.List;

public class AllLightsCommand implements Command {

    private List<Light> lights;

    public AllLightsCommand(List<Light> lights) {
        this.lights = lights;
    } // end AllLightsCommand(List<Light> lights)

    @Override
    public void execute() {

        for(Light light : lights) {

            light.toggle();
        }
    } // end void execute()
} // end class AllLightsCommand implements Command
