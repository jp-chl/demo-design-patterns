package com.jpvr.demodesignpatterns.generics.people;

public class Partner extends Person {

    public Partner(String name, int age) {
        super(name, age);
    } // end Partner(String name, int age)

    @Override
    public String toString() {
        return "Partner{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    } // end  String toString()
} // end class Partner extends Person
