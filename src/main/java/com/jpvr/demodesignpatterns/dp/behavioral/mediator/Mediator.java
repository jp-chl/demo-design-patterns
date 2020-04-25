package com.jpvr.demodesignpatterns.dp.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private List<Light> lights = new ArrayList<>();

    public void registerLight(Light light) {

        lights.add(light);
    } // end void registerLight(Light light)

    public void turnOnAllLights() {

        switchAllLights(true);
    } // end void turnOnAllLights()

    public void turnOffAllLights() {

        switchAllLights(false);
    } // end void turnOffAllLights()

    private void switchAllLights(boolean onCommand) {

        for(Light light : lights) {

            if ( onCommand && !light.isOn() ) {

                light.toggle();
            } else if ( !onCommand && light.isOn() ) {

                light.toggle();
            } // end else if ( !onCommand && light.isOn() )
        } // end iteration
    } // end void switchAllLights(boolean onCommand)
} // end class Mediator
