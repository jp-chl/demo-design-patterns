package com.jpvr.demodesignpatterns.dp.creational;

import com.jpvr.demodesignpatterns.dp.creational.prototype.Record;
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

} // end class PrototypeEverydayTests
