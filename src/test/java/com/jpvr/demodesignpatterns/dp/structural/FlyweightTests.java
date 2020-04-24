package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.flyweight.InventorySystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlyweightTests {

    @Test
    public void testNativeFlyweight() {

        Integer firstInteger = Integer.valueOf(5);
        Integer secondInteger = Integer.valueOf(5);
        Integer thirdInteger = Integer.valueOf(10);

        final int hashCodeFirstInteger = System.identityHashCode(firstInteger);
        final int hashCodeSecondInteger = System.identityHashCode(secondInteger);
        final int hashCodeThirdInteger = System.identityHashCode(thirdInteger);

        assertEquals(hashCodeFirstInteger, hashCodeSecondInteger);
        assertNotEquals(hashCodeFirstInteger, hashCodeThirdInteger);
    } // end void testNativeFlyweight()

    @Test
    public void testInventorySystem() {

        InventorySystem inventorySystem = new InventorySystem();

        final String ROOMBA_PRODUCT = "Roomba";
        final String BOSE_PRODUCT = "Bose Headphones";
        final String SAMSUNG_PRODUCT = "Samsung TV";

        inventorySystem.takeOrder(ROOMBA_PRODUCT, 221);
        inventorySystem.takeOrder(BOSE_PRODUCT, 361);
        inventorySystem.takeOrder(SAMSUNG_PRODUCT, 432);
        inventorySystem.takeOrder(SAMSUNG_PRODUCT, 323);
        inventorySystem.takeOrder(ROOMBA_PRODUCT, 563);
        inventorySystem.takeOrder(BOSE_PRODUCT, 321);
        inventorySystem.takeOrder(ROOMBA_PRODUCT, 234);
        inventorySystem.takeOrder(SAMSUNG_PRODUCT, 54);
        inventorySystem.takeOrder(ROOMBA_PRODUCT, 34);
        inventorySystem.takeOrder(BOSE_PRODUCT, 365);
        inventorySystem.takeOrder(SAMSUNG_PRODUCT, 332);
        inventorySystem.takeOrder(ROOMBA_PRODUCT, 456);

        inventorySystem.process();

        System.out.println(inventorySystem.report());
    } // end void testInventorySystem()
} // end class FlyweightTests
