package com.jpvr.demodesignpatterns.dp.structural;

public class EmployeeAdapterLdap implements Employee {

    private EmployeeLdap instance;

    public EmployeeAdapterLdap(EmployeeLdap employeeFromLdap) {

        instance = employeeFromLdap;
    } // end EmployeeAdapterLdap(EmployeeLdap employeeFromLdap)


    @Override
    public String getId() {
        return instance.getCn();
    } // end

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    } // end

    @Override
    public String getLastName() {
        return instance.getSurname();
    } // end

    @Override
    public String getEmail() {
        return instance.getMail();
    } // end

    @Override
    public String toString() {
        return "EmployeeAdapterLdap{" +
                "id=" + instance.getCn() +
                '}';
    } // end toString()
} // end EmployeeAdapterLdap(EmployeeLdap employeeFromLdap)
