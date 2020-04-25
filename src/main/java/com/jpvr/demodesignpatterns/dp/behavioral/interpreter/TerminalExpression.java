package com.jpvr.demodesignpatterns.dp.behavioral.interpreter;

import java.util.StringTokenizer;

public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    } // end TerminalExpression(String data)

    @Override
    public boolean interpret(String context) {

        StringTokenizer st = new StringTokenizer(context);

        while( st.hasMoreTokens() ) {

            String test = st.nextToken();
            if ( test.equals(data) ) {

                return true;
            }
        } // end iteration


        return false;
    } // end boolean interpret(String context)
} // end class TerminalExpression implements Expression
