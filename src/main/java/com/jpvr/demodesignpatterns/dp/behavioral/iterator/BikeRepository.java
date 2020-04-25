package com.jpvr.demodesignpatterns.dp.behavioral.iterator;

import java.util.Iterator;

public class BikeRepository implements Iterable<String> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int NEXT_CAPACITY = 5;

    private String[] bikes;
    private int index;

    public BikeRepository() {
        bikes = new String[INITIAL_CAPACITY];
        index = 0;
    } // end BikeRepository()

    public void addBike(String bikeModel) {

        final int bikesLength = bikes.length;

        if ( index == bikesLength  ) {

            String[] largerBikesArray = new String[bikesLength + NEXT_CAPACITY];

            System.arraycopy(bikes, 0, largerBikesArray, 0, bikesLength);

            bikes = largerBikesArray;

            largerBikesArray = null;
        } // end if ( index == bikes.length )

        bikes[index] = bikeModel;
        index++;
    } // end void addBike(String bikeModel)

    @Override
    public Iterator<String> iterator() {

        Iterator<String> iterator = new Iterator<String>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {

                return (currentIndex < bikes.length) && (bikes[currentIndex] != null);
            } // end boolean hasNext()

            @Override
            public String next() {

                return bikes[currentIndex++];
            } // end String next()

            @Override
            public void remove() {
                //throw new UnsupportedOperationException("implementation pending");

                for(int i=currentIndex; i<bikes.length; i++) {

                    String nextBike = bikes[i];
                    bikes[i-1] = nextBike;
                } // end iteration

                bikes[bikes.length - 1] = null;

                currentIndex--;
            } // end void remove()
        }; // end Iterator methods

        return iterator;
    } // end Iterator<String> iterator()


} // end class BikeRepository
