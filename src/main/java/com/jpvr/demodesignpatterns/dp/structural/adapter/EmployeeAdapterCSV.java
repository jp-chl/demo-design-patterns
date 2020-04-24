package com.jpvr.demodesignpatterns.dp.structural.adapter;

public class EmployeeAdapterCSV implements Employee {

    private EmployeeCSV instance;

    public EmployeeAdapterCSV(EmployeeCSV employeeFromCSV) {

        instance = employeeFromCSV;
    } // end EmployeeAdapterCSV(EmployeeCSV employeeFromCSV)


    @Override
    public String getId() {
        return instance.getId() + "";
    } // end

    @Override
    public String getFirstName() {
        return instance.getFirstName();
    } // end

    @Override
    public String getLastName() {
        return instance.getLastName();
    } // end

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    } // end

    @Override
    public String toString() {
        return "EmployeeAdapterCSV{" +
                "id=" + instance.getId() +
                '}';
    }
} // end class EmployeeAdapterCSV
