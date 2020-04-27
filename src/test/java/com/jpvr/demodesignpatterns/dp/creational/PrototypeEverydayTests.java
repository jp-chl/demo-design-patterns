package com.jpvr.demodesignpatterns.dp.creational;

import com.jpvr.demodesignpatterns.dp.creational.prototype.Movie;
import com.jpvr.demodesignpatterns.dp.creational.prototype.Record;
import com.jpvr.demodesignpatterns.dp.creational.prototype.Registry;
import com.jpvr.demodesignpatterns.dp.creational.prototype.Statement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrototypeEverydayTests {

    @Test
    public void cloningPrototypeTest() {


        String sql = "select * from movies where title = ?";

        List<String> parameters = new ArrayList<>();
        parameters.add("movie");

        Record record = new Record();

        Statement firstStatement = new Statement(sql, parameters, record);

        System.out.println(firstStatement.getSql());
        System.out.println(firstStatement.getParameters());
        System.out.println(firstStatement.getRecord());

        Statement secondStatement = firstStatement.clone();

        System.out.println(secondStatement.getSql());
        System.out.println(secondStatement.getParameters());
        System.out.println(secondStatement.getRecord());

    } // end void cloningPrototypeTest()

    @Test
    public void shouldCreateRegistryPrototype() {

        Registry registry = new Registry();
        //Movie movie = (Movie) registry.createItem("Movie");
        Movie movie = (Movie) registry.createItem(Registry.KIND.MOVIE);
        movie.setTitle("New title");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        //Movie anotherMovie = (Movie) registry.createItem("Movie");
        Movie anotherMovie = (Movie) registry.createItem(Registry.KIND.MOVIE);
        anotherMovie.setTitle("Yet a new title");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());
    } // end void shouldCreateRegistryPrototype()


} // end class PrototypeEverydayTests
