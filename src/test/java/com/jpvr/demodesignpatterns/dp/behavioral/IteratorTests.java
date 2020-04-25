package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.iterator.BikeRepository;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class IteratorTests {

    @Test
    public void BikeRepositoryIteratorTest() {

        BikeRepository repo = new BikeRepository();

        repo.addBike("Oxford");
        repo.addBike("Trek");
        repo.addBike("Canon");

        for(int i=0; i<8; i++) {
            repo.addBike("model" + i + "");
        }

        Iterator<String> bikeIterator = repo.iterator();

        while ( bikeIterator.hasNext() ) {

            final String nextBike = bikeIterator.next();
            System.out.println(nextBike);

            if (nextBike.equals("Trek")) {
                System.out.println("Removing bike ("+nextBike+")...");
                bikeIterator.remove();
            }
        } // end iteration

        System.out.println("------\n");

        for(String bike : repo) {
            System.out.println(bike);
        } // end iteration

    } // end void BikeRepositoryIteratorTest()
} // end class IteratorTests
