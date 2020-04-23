package com.jpvr.demodesignpatterns.dp.creational;

public class DbSingleton {

    private static DbSingleton instance = new DbSingleton();

    private DbSingleton() {}

    public static DbSingleton getInstance() {

        return instance;
    } // end

} // end class DbSingleton
