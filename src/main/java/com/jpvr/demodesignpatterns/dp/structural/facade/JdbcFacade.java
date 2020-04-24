package com.jpvr.demodesignpatterns.dp.structural.facade;

import com.jpvr.demodesignpatterns.dp.creational.SingletonDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcFacade {

    SingletonDb instance = null;

    public JdbcFacade() {
        this.instance = SingletonDb.getInstance();
    } // end constructor

    public int createTable() {

        int count = 0;

        try (   Connection conn = instance.getConnection();
                Statement sta = conn.createStatement();
                ) {

            count = sta.executeUpdate("CREATE TABLE Address (" +
                            "ID INTEGER, " +
                            "StreetName VARCHAR(20), " +
                            "City VARCHAR(20))");

            System.out.println("Table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    } // end int createTable()

    public int insertIntoTable() {

        int count = 0;

        try (   Connection conn = instance.getConnection();
                Statement sta = conn.createStatement();
        ) {

            count = sta.executeUpdate("INSERT INTO Address(ID, StreetName, City) " +
                    "VALUES (1, '1234 SOME STREET', 'LAYTON')");

            System.out.println(count + " record(s) created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    } // end int insertIntoTable()

    public List<Address> getAddresses() {

        List<Address> addresses = new ArrayList<>();

        try (   Connection conn = instance.getConnection();
                Statement sta = conn.createStatement();
                ResultSet rs = sta.executeQuery("Select * from Address");
        ) {

            while( rs.next() ) {

                final String id = rs.getString(1);
                final String streetName = rs.getString(2);
                final String city = rs.getString(3);

                Address address = new Address();
                address.setId(id);
                address.setStreetName(streetName);
                address.setCity(city);

                addresses.add(address);

                System.out.println("record retrieved (" + id + ", " + streetName + ", " + city + ")");
            } // end iteration
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    } // end List<Address> getAddresses()

    private class Address {

        private String id;
        private String streetName;
        private String city;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    } // end class Address
} // end class JdbcFacade
