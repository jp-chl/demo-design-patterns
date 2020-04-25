package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.strategy.AmexStrategy;
import com.jpvr.demodesignpatterns.dp.behavioral.strategy.CreditCard;
import com.jpvr.demodesignpatterns.dp.behavioral.strategy.Person;
import com.jpvr.demodesignpatterns.dp.behavioral.strategy.VisaStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTests {

    @Test
    public void strategyDemo() {

        CreditCard amexCard = new CreditCard(new AmexStrategy());

        amexCard.setNumber("379185883464283");
        amexCard.setDate("04/2020");
        amexCard.setCvv("123");

        System.out.println("Is Amex valid: " + amexCard.isValid());
        assertTrue(amexCard.isValid());


        CreditCard invalidAmexCard = new CreditCard(new AmexStrategy());

        invalidAmexCard.setNumber("379185883464282"); // last digit different
        invalidAmexCard.setDate("04/2020");
        invalidAmexCard.setCvv("123");

        System.out.println("Is Amex valid: " + invalidAmexCard.isValid());
        assertFalse(invalidAmexCard.isValid());


        CreditCard visaCard = new CreditCard(new VisaStrategy());

        visaCard.setNumber("4539589763663402");
        visaCard.setDate("04/2020");
        visaCard.setCvv("123");

        System.out.println("Is Visa valid: " + visaCard.isValid());
        assertTrue(visaCard.isValid());
    } // end void strategyDemo()
    @Test
    public void everydayDemo() {

        Person peter = new Person("peter", "2222222", 39);
        Person john = new Person("john", "3333333", 40);
        Person james = new Person("james", "4444444", 38);

        List<Person> people = new ArrayList<>();
        people.add(peter);
        people.add(john);
        people.add(james);

        System.out.println("Not sorted");
        printContents(people);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                if (o1.getAge() > o2.getAge()) {

                    return 1;
                } else if (o1.getAge() < o2.getAge()) {

                    return -1;
                }

                return 0;
            }
        });

        System.out.println("\nSorted by age");
        printContents(people);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("\nSorted by name");
        printContents(people);
    } // end void everydayDemo()

    private void printContents(List<Person> people) {

        for(Person person : people) {
            System.out.println("person = " + person.getName());
        }
    }


} // end class StrategyTests
