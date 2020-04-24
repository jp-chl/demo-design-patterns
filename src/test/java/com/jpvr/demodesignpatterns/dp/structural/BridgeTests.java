package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.bridge.*;
import com.jpvr.demodesignpatterns.dp.structural.bridge.shape1.*;
import com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Blue;
import com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Color;
import com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Green;
import com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Red;
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
    public void Shape1NotBridgeTest() {

        Circle circle = new BlueCircle();

        Square square = new RedSquare();

        Square greenSquare = new GreenSquare();

        circle.applyColor();
        square.applyColor();
        greenSquare.applyColor();
    } // end void Shape1NotBridgeTest()

    @Test
    public void Shape2BridgeTest() {

        Color blue = new Blue();

        com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Shape square = new com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Square(blue);

        Color red = new Red();

        com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Shape circle = new com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Circle(red);

        Color green = new Green();
        com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Shape greenCircle = new com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Circle(green);

        com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Shape greenSquare = new com.jpvr.demodesignpatterns.dp.structural.bridge.shape2.Square(green);

        square.applyColor();
        circle.applyColor();
        greenCircle.applyColor();
        greenSquare.applyColor();
    } // end void Shape2BridgeTest()

    @Test
    public void shouldCreateMovieTest() {

        Movie movie = new Movie();
        movie.setClasification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        Printer moviePrinter = new MoviePrinter(movie);

        Formatter printFormatter = new PrintFormatter();
        String printedMaterial = moviePrinter.print(printFormatter);
        System.out.println(printedMaterial);

        Formatter htmlFormatter = new HtmlFormatter();
        String htmlMaterial = moviePrinter.print(htmlFormatter);
        System.out.println(htmlMaterial);
    } // end
} // end class BridgeTests
