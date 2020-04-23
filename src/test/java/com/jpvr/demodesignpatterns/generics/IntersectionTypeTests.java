package com.jpvr.demodesignpatterns.generics;

import com.jpvr.demodesignpatterns.generics.people.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

public class IntersectionTypeTests {

    @Test
    public void readPersonFromFile() throws IOException {

        final String filename = "people.txt";

        Person donDraper = new Person("Don Draper", 89);
        new PersonSaver(new File(filename)).save(donDraper);

        DataInputStream stream = new DataInputStream(new FileInputStream(filename));

        Person person = read(stream);
        System.out.println(person);

        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
        person = read(randomAccessFile);
        System.out.println(person);
    } // end

    private <T extends DataInput & Closeable> Person read(final T source) {

        try( T input = source ) {

            return new Person(input.readUTF(), input.readInt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end

    private Person read(final DataInputStream source) {

        try( DataInputStream input = source ) {

            return new Person(input.readUTF(), input.readInt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end
} // end class IntersectionTypeTests