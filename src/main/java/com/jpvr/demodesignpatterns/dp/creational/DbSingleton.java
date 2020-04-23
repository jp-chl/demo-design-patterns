package com.jpvr.demodesignpatterns.dp.creational;

public class DbSingleton {

    // Eagerly loaded (created even if it's not being used)
    private static DbSingleton instance = new DbSingleton();

    private DbSingleton() {}

    public static DbSingleton getInstance() {

        return instance;
    } // end

} // end class DbSingleton
