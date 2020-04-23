package com.jpvr.demodesignpatterns.dp.creational;

public class DbSingleton {

    // Lazily loaded, and thread safe (volatile)
    private static volatile DbSingleton instance = null;

    private DbSingleton() {

        // avoiding reflection
        if ( instance != null ) {
            throw new RuntimeException("Use getInstance()");
        }
    } // end private DbSingleton()

    // Thread safe version
    public static DbSingleton getInstance() {

        if ( instance == null ) {

            // rather than synchronized the method,
            // much more efficient to do it here
            synchronized (DbSingleton.class) {

                if ( instance == null ) {

                    instance = new DbSingleton();
                }
            } // end synchronized
        } // end if ( instance == null )
        return instance;
    } // end static DbSingleton getInstance()

} // end class DbSingleton
