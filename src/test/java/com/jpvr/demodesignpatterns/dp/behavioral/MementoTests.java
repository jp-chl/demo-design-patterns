package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.memento.Caretaker;
import com.jpvr.demodesignpatterns.dp.behavioral.memento.Employee;
import com.jpvr.demodesignpatterns.dp.behavioral.memento.EmployeeNotUsingMemento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MementoTests {

    @Test
    public void everydayDemo() {

        EmployeeNotUsingMemento employee = new EmployeeNotUsingMemento();
        employee.setName("jp");
        employee.setAddress("address 1");
        employee.setPhone("2222222");

        EmployeeNotUsingMemento.serialize(employee);

        EmployeeNotUsingMemento sameEmployee = EmployeeNotUsingMemento.deserialize();

        System.out.println(sameEmployee);
    } // end void everydayDemo()

    @Test
    public void shouldHandlesEmployeeHistory() {

        Caretaker caretaker = new Caretaker();

        Employee employee = new Employee();
        employee.setName("jp");
        employee.setAddress("address 1");
        employee.setPhone("2222222");

        System.out.println("employee ORIGINAL   : " + employee);
        assertEquals("2222222", employee.getPhone());
        caretaker.save(employee);

        employee.setPhone("3333333");

        caretaker.save(employee);
        System.out.println("employee AFTER save:  " + employee);
        assertEquals("3333333", employee.getPhone());

        // we don't call save() after this phone update
        employee.setPhone("4444444");

        caretaker.revert(employee);
        System.out.println("employee RESTORED:    " + employee);
        assertEquals("3333333", employee.getPhone());

        caretaker.revert(employee);
        System.out.println("employee ORIGINAL:    " + employee);
        assertEquals("2222222", employee.getPhone());
    } // end void shouldHandlesEmployeeHistory()
} // end class MementoTests
