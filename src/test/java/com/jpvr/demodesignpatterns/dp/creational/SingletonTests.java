package com.jpvr.demodesignpatterns.dp.creational;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    } // end void testSingleton()

    @Test
    public void dbSingletonDemo() {

        SingletonDb instance = SingletonDb.getInstance();
        //DbSingleton testConst = new DbSingleton();

        System.out.println(instance);

        SingletonDb anotherInstance = SingletonDb.getInstance();

        System.out.println(anotherInstance);
    } // end void dbSingletonDemo() {

    @Test
    public void shouldCreateOnlyOneDBConnection() throws SQLException {

        SingletonDb instance = SingletonDb.getInstance();

        long timeBefore = System.nanoTime();
        Connection conn = instance.getConnection();
        long timeAfter = System.nanoTime();

        System.out.println("timeAfter - timeBefore = " + (timeAfter - timeBefore));

        Statement sta;
        try {
            sta = conn.createStatement();
            int count = sta
                    .executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
                            + " City VARCHAR(20))");
            System.out.println("Table created.");
            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        timeBefore = System.nanoTime();
        conn = instance.getConnection();
        timeAfter = System.nanoTime();

        System.out.println("timeAfter - timeBefore = " + (timeAfter - timeBefore));

        try {
            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("Select * from Address");

            System.out.println(rs);
            rs.close();
            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end void shouldCreateOnlyOneDBConnection()
} // end class SingletonTests

