package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.state.Fan;
import org.junit.jupiter.api.Test;

public class StateTests {


    @Test
    public void stateMachineDemo() {

        Fan fan = new Fan();
        System.out.println(fan + "\n");

        fan.pullChain();
        System.out.println(fan + "\n");

        fan.pullChain();
        System.out.println(fan + "\n");

        fan.pullChain();
        System.out.println(fan + "\n");

        fan.pullChain();
        System.out.println(fan + "\n");

    } // end void stateMachineDemo()


    @Test
    public void everydayDemo() {

        InnerFan fan = new InnerFan();

        System.out.println("fan = " + fan + "\n");

        fan.pullChain();
        System.out.println("fan = " + fan + "\n");

        fan.pullChain();
        System.out.println("fan = " + fan + "\n");

        fan.pullChain();
        System.out.println("fan = " + fan + "\n");

    } // end void everydayDemo()

    class InnerFan {

        final static int OFF = 0;
        final static int LOW = 1;

        int state = OFF;

        public InnerFan() {
        }

        public void pullChain() {

            if (state == OFF) {

                System.out.println("Turning fan on to low");
                state = LOW;
            } else if (state == LOW) {

                System.out.println("Turning fan off");
                state = OFF;
            }
        } // end void pullChain()

        @Override
        public String toString() {

            if (state == OFF) {

                return "Fan is off";

            } else if (state == LOW) {

                return "Fan is on low";
            }

            return "Invalid state";
        } // end String toString()
    } // end inner class Fan

} // end class StateTests
