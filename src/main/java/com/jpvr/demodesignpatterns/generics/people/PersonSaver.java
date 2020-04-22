package com.jpvr.demodesignpatterns.generics.people;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

    private final RandomAccessFile file;

    public PersonSaver(File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    } // end PersonLoader(File file)

    public void save(Person person) throws IOException {

        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());
    } // end void save(Person person)s

    //public <T extends Person> void saveAll(final List<T> persons) throws IOException { // worse alternative
    public void saveAll(final List<? extends Person> persons) throws IOException { // preferable


        for(Person person: persons) {

            save(person);
        } // end iteration
    } // end void saveAll(Person[] persons)
} // end class PersonSaver