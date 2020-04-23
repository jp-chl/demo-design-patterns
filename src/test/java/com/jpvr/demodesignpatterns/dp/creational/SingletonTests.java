package com.jpvr.demodesignpatterns.dp.creational;

import org.junit.jupiter.api.Test;

public class SingletonTests {

    @Test
    public void testSingleton() {

        Runtime singletonRuntime = Runtime.getRuntime();

        singletonRuntime.gc();

        System.out.println(singletonRuntime);

        Runtime anotherInstance = Runtime.getRuntime();

        System.out.println(anotherInstance);

        if (singletonRuntime == anotherInstance) {
            System.out.println("same instance");
        }
    } // end

    @Test
    public void dbSingletonDemo() {

        DbSingleton instance = DbSingleton.getInstance();
        //DbSingleton testConst = new DbSingleton();

        System.out.println(instance);

        DbSingleton anotherInstance = DbSingleton.getInstance();

        System.out.println(anotherInstance);
    }
} // end class SingletonTests

