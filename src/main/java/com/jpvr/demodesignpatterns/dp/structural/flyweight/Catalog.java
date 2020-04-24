package com.jpvr.demodesignpatterns.dp.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Catalog acts as a factory and cache for Item flyweight objects
 */
public class Catalog {

    private Map<String, Item> items = new HashMap<String, Item>();

    // factory method
    public Item lookup(String itemName) {

        if ( !items.containsKey(itemName) ) {

            items.put(itemName, new Item(itemName));
        } // end if

        return items.get(itemName);
    } // end Item lookup(String itemName)

    public int totalItemsMade() {

        return items.size();
    } // end int totalItemsMade()

} // end class Catalog
