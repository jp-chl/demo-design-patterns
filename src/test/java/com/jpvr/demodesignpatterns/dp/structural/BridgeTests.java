package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.shape1.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BridgeTests {

    @Test
    public void testDBDriver() {

        try {

            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());

            final String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

            Connection conn = DriverManager.getConnection(dbUrl);

            Statement statement = conn.createStatement();

            statement.executeUpdate(
                    "CREATE TABLE " +
                            "Address (ID INT, " +
                            "StreetName VARCHAR(20)," +
                            " City VARCHAR(20))");

            System.out.println("Table created");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    } // end void testDBDriver()

    @Test
    public void Shape1BridgeTest() {

        Circle circle = new BlueCircle();

        Square square = new RedSquare();

        Square greenSquare = new GreenSquare();

        circle.applyColor();
        square.applyColor();
        greenSquare.applyColor();
    } // end void Shape1BridgeTest()

} // end class BridgeTests
