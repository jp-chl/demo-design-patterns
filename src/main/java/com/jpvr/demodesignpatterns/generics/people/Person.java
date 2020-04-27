package com.jpvr.demodesignpatterns.generics.people;

import java.util.Objects;

public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {

        Objects.requireNonNull(name);

        this.name = name;
        this.age = age;
    } // end Person(String name, int age)

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return Objects.equals(name, person.name);
    } // end boolean equals(Object o)

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    } // end int hashCode()

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    } // end String toString()
} // end class Person
