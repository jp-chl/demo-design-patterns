package com.jpvr.demodesignpatterns.dp.structural;

import com.jpvr.demodesignpatterns.dp.structural.composite.Menu;
import com.jpvr.demodesignpatterns.dp.structural.composite.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CompositeTests {

    @Test
    public void javaMapTests() {

        Map<String, String> personAttributes = new HashMap<>();

        personAttributes.put("site_role", "person");
        personAttributes.put("access_role", "limited");

        Map<String, String> groupAttributes = new HashMap<>();

        groupAttributes.put("group_role", "claims");

        Map<String, String> secAttributes = new HashMap<>();

        secAttributes.putAll(personAttributes);
        secAttributes.putAll(groupAttributes);

        System.out.println(personAttributes);
        System.out.println(groupAttributes);
        System.out.println(secAttributes);
    } // end void javaMapTests()

    @Test
    public void compositeMenuTests() {

        Menu mainMenu = new Menu("Main", "/main");

        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");
        Menu claimsSubMenu = new Menu("Claims", "/claims");

        mainMenu.add(safetyMenuItem);
        mainMenu.add(claimsSubMenu);

        MenuItem personalClaimsMenu = new MenuItem("Personal Claim", "/personalClaims");

        claimsSubMenu.add(personalClaimsMenu);

        System.out.println(mainMenu.toString());
    } // end void compositeMenuTests()
} // end class CompositeTests
