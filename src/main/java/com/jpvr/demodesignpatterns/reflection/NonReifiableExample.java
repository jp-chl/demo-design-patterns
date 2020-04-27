package com.jpvr.demodesignpatterns.reflection;

import java.util.ArrayList;
import java.util.List;

public class NonReifiableExample<T> {

    public static void main(String[] args) {
        new NonReifiableExample<String>().main();
    }

    private void main() {

        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        System.out.println("strings = " + strings.getClass());
        System.out.println("integers = " + integers.getClass());
        System.out.println(strings.getClass() == integers.getClass());

        List<? extends Number> numbers = new ArrayList<>();
        System.out.println("numbers = " + numbers.getClass());
    } // end void main()
} // end class NonReifiableExample
