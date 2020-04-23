package com.jpvr.demodesignpatterns.dp.creational;

public class DbSingleton {

    // Lazily loaded
    private static DbSingleton instance = null;

    private DbSingleton() {}

    public static DbSingleton getInstance() {

        if ( instance == null ) {
            instance = new DbSingleton();
        }
        return instance;
    } // end

} // end class DbSingleton
