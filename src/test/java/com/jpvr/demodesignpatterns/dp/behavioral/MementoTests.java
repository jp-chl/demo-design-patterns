package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.structural.mediator.Employee;
import org.junit.jupiter.api.Test;

public class MementoTests {

    @Test
    public void everydayDemo() {

        Employee employee = new Employee();
        employee.setName("jp");
        employee.setAddress("address 1");
        employee.setPhone("2222222");

        Employee.serialize(employee);

        Employee sameEmployee = Employee.deserialize();

        System.out.println(sameEmployee);
    } // end void everydayDemo()
} // end class MementoTests
