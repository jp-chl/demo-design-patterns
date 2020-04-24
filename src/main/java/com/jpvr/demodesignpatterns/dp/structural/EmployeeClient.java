package com.jpvr.demodesignpatterns.dp.structural;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    public List<Employee> getEmployeeList() {

        List<Employee> employees = new ArrayList<>();

        Employee employeeFromDB = new EmployeeDB("1234",
                "John", "Wick", "john@wick.com");

        EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie",
                "Solo", "Han", "han@solo.com");

        employees.add(new EmployeeAdapterLdap(employeeFromLdap));

        employees.add(employeeFromDB);

        return employees;
    } // end List<Employee> getEmployeeList()
} // end class EmployeeClient
