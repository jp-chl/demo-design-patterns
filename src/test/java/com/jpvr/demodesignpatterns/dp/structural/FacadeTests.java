package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.creational.SingletonDb;
import com.jpvr.demodesignpatterns.dp.structural.facade.JdbcFacade;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacadeTests {

    @Test
    public void testURLFacade() throws IOException {

        final String protocol = "http";
        final String host = "www.sitios.cl/";
        final int port = 80;
        final String file = "";

        URL url = new URL(protocol, host, port, file);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;

        while( (inputLine = bufferedReader.readLine()) != null ) {
            System.out.println(inputLine);
        }
    } // end void testURLFacade()

    @Test
    public void JdbcDemoWithoutFacadeTest() throws SQLException {

        SingletonDb instance = SingletonDb.getInstance();
        Connection conn = instance.getConnection();

        Statement sta;
        try {
            sta = conn.createStatement();
            int count = sta
                    .executeUpdate("CREATE TABLE Address (" +
                            "ID INTEGER, " +
                            "StreetName VARCHAR(20), " +
                            "City VARCHAR(20))");
            System.out.println("Table created.");
            sta.close();


            sta = conn.createStatement();
            count = sta.executeUpdate("INSERT INTO Address(ID, StreetName, City) " +
                    "VALUES (1, '1234 SOME STREET', 'LAYTON')");
            System.out.println(count + " record(s) created");
            sta.close();


            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("Select * from Address");

            while( rs.next() ) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3));
            }

            rs.close();
            sta.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end void JdbcDemoWithoutFacadeTest()

    @Test
    public void JdbcDemoWitFacadeTest() {

        JdbcFacade jdbcFacade = new JdbcFacade();

        jdbcFacade.createTable();
        jdbcFacade.insertIntoTable();
        jdbcFacade.getAddresses();
    } // end void JdbcDemoWitFacadeTest()

} // end class FacadeTests
