package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.people.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonStorageTests {

    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlson = new Employee("Peggy Olson", 65);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @BeforeAll
    public void setup() throws FileNotFoundException {

        file = new File("person.txt");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    } // end setup()

    @Test
    public void test() {

        //List<? extends Person> people = new ArrayList<>();
        List<? extends Person> people = new ArrayList<>();
        //people.add(new Partner("jp", 10));
        //people.add(new Person("es", 20));
        people.add(null);

        final Person person1 = people.get(0);

        String a = null;
    } // end

    @Test
    public void savesAndLoadsPerson() throws Exception {

        Person person = new Person("Bob", 20);
        saver.save(person);

        assertEquals(person, loader.load());

    } // end void savesAndLoadsPerson()

    @Test
    public void savesAndLoadsArraysOfPeople() throws IOException, ClassNotFoundException {

//        //Person[] persons = new Person[2];
////        Partner[] partners = new Partner[2];
////        Person[] persons = partners; // covariant
//
//        Employee[] employees = new Employee[2];
//        Person[] persons = employees;
//
//        persons[0] = donDraper;
//        persons[1] = bertCooper;

        List<Partner> persons = new ArrayList<>();
        persons.add(donDraper);
        persons.add(bertCooper);

        saver.saveAll(persons);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    } // end void savesAndLoadsArraysOfPeople()

    @Test
    public void loadsListsOfPeople() throws Exception {

        saver.save(donDraper);
        saver.save(peggyOlson);

        //List<Person> people = new ArrayList<>();
        List<Object> people = new ArrayList<>();
        loader.loadAll(people);

        assertEquals(donDraper, people.get(0));
        assertEquals(peggyOlson, people.get(1));

    } // end void loadsListsOfPeople()
} // end class PersonStorageTests
