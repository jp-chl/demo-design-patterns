package com.jpvr.demodesignpatterns.dp.behavioral.memento;

import java.util.Stack;

// caretaker
public class Caretaker {

    private Stack<EmployeeMemento> employeeHistory = new Stack<>();

    public void save(Employee employee) {

        employeeHistory.push(employee.save());
    } // end void save(Employee employee)

    /**
     * by reference
     * @param employee
     */
    public void revert(Employee employee) {

        employee.revert(employeeHistory.pop());
    } // end void revert(Employee employee)

} // end class Caretaker
