package com.jpvr.demodesignpatterns.dp.behavioral.memento;

public class Employee {

    private String name;
    private String address;
    private String phone;

    public EmployeeMemento save() {
        return new EmployeeMemento(name, phone);
    } // end EmployeeMemento save()

    public void revert(EmployeeMemento employeeMemento) {
        this.name = employeeMemento.getName();
        this.phone = employeeMemento.getPhone();
    } // end void revert(EmployeeMemento employeeMemento)


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    } // end String toString()
} // end class Employee
