package com.jpvr.demodesignpatterns.dp.behavioral.memento;

import java.io.*;

// originator
//@SuppressWarnings("serial")
public class EmployeeNotUsingMemento implements Serializable {

    private static final String SERIALIZABLE_PATH = "/tmp/employee.ser";

    private String name;
    private String address;
    private String phone;

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

    public static void serialize(EmployeeNotUsingMemento employeeNotUsingMemento) {

        try (   FileOutputStream fileOut = new FileOutputStream(SERIALIZABLE_PATH);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                ) {

            out.writeObject(employeeNotUsingMemento);

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end static Employee serialize(Employee employee)

    public static EmployeeNotUsingMemento deserialize() {

        EmployeeNotUsingMemento employeeNotUsingMemento = null;

        try (   FileInputStream fileIn = new FileInputStream(SERIALIZABLE_PATH);
                ObjectInputStream in = new ObjectInputStream(fileIn);) {

            employeeNotUsingMemento = (EmployeeNotUsingMemento) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employeeNotUsingMemento;
    } // end static Employee deserialize()
} // end class EmployeeNotUsingMemento
