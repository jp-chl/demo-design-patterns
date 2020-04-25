package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.interpreter.AndExpression;
import com.jpvr.demodesignpatterns.dp.behavioral.interpreter.Expression;
import com.jpvr.demodesignpatterns.dp.behavioral.interpreter.OrExpression;
import com.jpvr.demodesignpatterns.dp.behavioral.interpreter.TerminalExpression;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterTests {

    @Test
    public void everydayDemo() {

        String input = "Lions, and tiger, and bears! Oh my!";

        Pattern p = Pattern.compile("(lion|cat|dog|wolf|bear|human|tiger|liger)");
        Matcher m = p.matcher(input);

        while( m.find() ) {

            System.out.println("m.group() = " + m.group());
        }
    } // end void everydayDemo()


    @Test
    public void expressionInterpreterTest() {

        //String context = "Lions";
//        String context = "Tigers";
//        String context = "Bears";
//        String context = "Lions Tigers";
//        String context = "Lions Bears";
        String context = "Tigers Bears";

        Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    } // end void expressionInterpreterTest()

    static Expression buildInterpreterTree() {

        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        // Tigers and Bears
        Expression alternation1 = new AndExpression(terminal2, terminal3);

        // Lions or (Tigers and Bears)
        Expression alternation2 = new OrExpression(terminal1, alternation1);

        return new AndExpression(terminal3, alternation2);
    } // end static Expression buildInterpreterTree()

} // end class InterpreterTests
