package com.jpvr.demodesignpatterns.dp.creational;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

    // Lazily loaded, and thread safe (volatile)
    private static volatile DbSingleton instance = null;

    private static volatile Connection conn = null;

    private DbSingleton() {

        try {

            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {

            e.printStackTrace();
        }

        if ( conn != null) {

            throw new RuntimeException("Use getConnection()");
        }

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

    // public for the sake of style
    public Connection getConnection() {

        if ( conn == null) {

            synchronized (DbSingleton.class) {

                if ( conn == null) {

                    try {

                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                } // end if ( conn == null) {
            } // end synchronized (DbSingleton.class)
        } // end if ( conn == null)

        return conn;
    } // end Connection getConnection()
} // end class DbSingleton
