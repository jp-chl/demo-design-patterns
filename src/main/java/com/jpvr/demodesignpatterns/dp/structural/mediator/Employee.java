package com.jpvr.demodesignpatterns.dp.structural.mediator;

import java.io.*;

// originator
//@SuppressWarnings("serial")
public class Employee implements Serializable {

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

    public static void serialize(Employee employee) {

        try (   FileOutputStream fileOut = new FileOutputStream(SERIALIZABLE_PATH);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                ) {

            out.writeObject(employee);

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end static Employee serialize(Employee employee)

    public static Employee deserialize() {

        Employee employee = null;

        try (   FileInputStream fileIn = new FileInputStream(SERIALIZABLE_PATH);
                ObjectInputStream in = new ObjectInputStream(fileIn);) {

            employee = (Employee) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employee;
    } // end static Employee deserialize()
} // end class Employee
