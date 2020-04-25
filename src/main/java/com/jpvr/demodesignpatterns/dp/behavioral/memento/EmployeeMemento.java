package com.jpvr.demodesignpatterns.dp.behavioral.memento;

// memento
public class EmployeeMemento {

    private String name;
    private String phone;

    /**
     * memento selects which members to know about
      */
    // private String address;

    public EmployeeMemento(String name, String phone) {

        this.name = name;
        this.phone = phone;
    } // end EmployeeMemento(String name, String address)

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
} // end class EmployeeMemento
