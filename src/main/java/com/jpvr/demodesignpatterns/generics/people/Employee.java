package com.jpvr.demodesignpatterns.generics.people;

public class Employee extends Person {

    public Employee(String name, int age) {
        super(name, age);
    } // end Employee(String name, int age)

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
} // end class Employee extends Person
