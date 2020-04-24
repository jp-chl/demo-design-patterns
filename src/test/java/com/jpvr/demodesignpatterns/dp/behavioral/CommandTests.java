package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.command.*;
import org.junit.jupiter.api.Test;

public class CommandTests {

    @Test
    public void commandTest() {

        Light light = new Light(); // receiver
        Switch lightSwitch = new Switch(); // invoker

        Command onCommand = new OnCommand(light); // command
        lightSwitch.storeAndExecute(onCommand);

        Command toggleCommand = new ToggleCommand(light);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);

    } // end void commandTest()


    @Test
    public void everydayDemo() {

        Task task1 = new Task(10, 12); // encapsulates request
        Task task2 = new Task(11, 13);

        Thread thread1 = new Thread(task1);
        thread1.start(); // invoker

        Thread thread2 = new Thread(task2);
        thread2.start();
    } // end void everydayDemo()

    private class Task implements Runnable {

        int num1;
        int num2;

        public Task(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        } // end constructor

        @Override
        public void run() {

            System.out.println(num1 * num2);
        } // end void run
    } // end inner class Task

} // end class CommandTests
