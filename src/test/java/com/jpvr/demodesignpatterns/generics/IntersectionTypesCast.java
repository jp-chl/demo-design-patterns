package com.jpvr.demodesignpatterns.generics;

import org.junit.jupiter.api.Test;

import java.io.*;

public class IntersectionTypesCast {

    @Test
    public void test() throws IOException, ClassNotFoundException {

        Runnable helloWorld = (Serializable & Runnable) () -> {

            System.out.println("Hello world!");
        };
        helloWorld.run();

        File file = File.createTempFile("runnable", "tmp");
        file.deleteOnExit();
        writeToFile(file, helloWorld);

        final Runnable runnable = (Runnable) readFromFile(file);
        runnable.run();

    } // end

    private void writeToFile(final File file, Object object) throws IOException {

        try(ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(object);
        }
    } // end

    private Object readFromFile(final File file) throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(file))) {

            return ois.readObject();
        }
    } // end
} // end class IntersectionTypesCast
