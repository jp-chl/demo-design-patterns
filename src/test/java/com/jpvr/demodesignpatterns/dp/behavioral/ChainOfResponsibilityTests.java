package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.chain.*;
import org.junit.jupiter.api.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainOfResponsibilityTests {

    private static final Logger logger = Logger.getLogger(ChainOfResponsibilityTests.class.getName());

    @Test
    public void everydayDemo() {

        logger.setLevel(Level.FINER);

        ConsoleHandler handler = new ConsoleHandler();

        handler.setLevel(Level.FINER);
        logger.addHandler(handler);

        logger.finest("Finest level of logging"); // this one won't print
        logger.finer("Finer level, but not as fine as finest");
        logger.fine("Fine, but not as finer or finest");
    } // end void everydayDemo()

    @Test
    public void organizationalChainOfResponsibilityTest() {

        Director director = new Director();
        VP vp = new VP();
        CEO ceo = new CEO();

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        Request request = new Request(RequestType.CONFERENCE, 500);
        director.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 1000);
        director.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 2000);
        director.handleRequest(request);
    } // end void organizationalChainOfResponsibilityTest()
} // end class ChainOfResponsibilityTests
