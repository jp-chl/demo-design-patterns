package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.adapter.Employee;
import com.jpvr.demodesignpatterns.dp.structural.adapter.EmployeeClient;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AdapterTests {

    @Test
    public void test() {

        Integer[] arrayOfInts = new Integer[] {42,43,44};

        List<Integer> listOfInts = Arrays.asList(arrayOfInts);

        System.out.println(arrayOfInts);

        System.out.println(listOfInts);
    } // end

    @Test
    public void shouldCreateEmployee() {

        EmployeeClient client = new EmployeeClient();

        List<Employee> employees = client.getEmployeeList();

        System.out.println(employees);
    } // end void shouldCreateEmployee()

} // end
