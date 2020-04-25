package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.iterator.BikeRepository;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class IteratorTests {

    @Test
    public void BikeRepositoryIteratorTest() {

        BikeRepository repository = new BikeRepository();

        repository.addBike("Oxford");
        repository.addBike("Trek");
        repository.addBike("Canon");

        Iterator<String> bikeIterator = repository.iterator();

        while ( bikeIterator.hasNext() ) {
            System.out.println(bikeIterator.next());
        } // end iteration
    } // end void BikeRepositoryIteratorTest()
} // end class IteratorTests
