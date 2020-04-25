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

        Iterator<String> bikeIterator = repo.iterator();

//        while ( bikeIterator.hasNext() ) {
//            System.out.println(bikeIterator.next());
//        } // end iteration

        for(String bike : repo) {
            System.out.println(bike);
        } // end iteration

    } // end void BikeRepositoryIteratorTest()
} // end class IteratorTests
