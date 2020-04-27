package com.jpvr.demodesignpatterns.dp.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototypes examples for unique new instances of movies and books
 */
public class Registry {

    public static enum KIND {

        MOVIE, BOOK
    };

    private Map<KIND, Item> items = new HashMap<KIND, Item>();

    //public Item createItem(String type) {
    public Item createItem(KIND type) {

        Item item = null;

        try {

            item = (Item) (items.get(type)).clone();
        } catch ( CloneNotSupportedException e ) {
            e.printStackTrace();
        }

        return item;
    } // end Item createItem(String type)

    public Registry() {
        loadItems();
    } // end

    private void loadItems() {

        Movie movie = new Movie();
        movie.setTitle("movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        //items.put("Movie", movie);
        //final KIND movieKind = KIND.MOVIE;
        items.put(KIND.MOVIE, movie);

        Book book = new Book();
        book.setNumberOfPages(335);
        book.setPrice(19.99);
        book.setTitle("book");
        //items.put("Book", book);
        items.put(KIND.BOOK, book);

    } // end void loadItems()
} // end class Registry
