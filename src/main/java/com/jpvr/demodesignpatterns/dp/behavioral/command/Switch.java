package com.jpvr.demodesignpatterns.dp.behavioral.command;

// invoker
public class Switch {

    public void storeAndExecute(Command command) {
        command.execute();
    }

}
