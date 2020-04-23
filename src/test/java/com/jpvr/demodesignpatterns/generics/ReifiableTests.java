package com.jpvr.demodesignpatterns.generics;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReifiableTests {

    @Test
    public void shouldCheckClassTypes() {

        final String intClassName = ""+int.class+"";
        assertEquals("int", intClassName);

        final String stringClassName = ""+String.class+"";
        assertEquals("class java.lang.String", stringClassName);

        final List<?> wildcards = new ArrayList<>();
        final String wildcardsClassName = ""+wildcards.getClass()+"";
        assertEquals("class java.util.ArrayList", wildcardsClassName);

        final List<String> wildcards2 = new ArrayList<>();
        final String wildcardsClassName2 = ""+wildcards2.getClass()+"";
        assertEquals("class java.util.ArrayList", wildcardsClassName2);

        final List rawList = new ArrayList();
        final String rawListClassName = ""+rawList.getClass()+"";
        assertEquals("class java.util.ArrayList", rawListClassName);
        assertEquals(rawList.getClass(), wildcards.getClass());

        final int[] intArray = new int[0];
        final String intArrayClassName = ""+intArray.getClass()+"";
        assertEquals("class [I", intArrayClassName);

        final List[] listArray = new List[0];
        final String listArrayClassName = ""+listArray.getClass()+"";
        assertEquals("class [Ljava.util.List;", listArrayClassName);

        List<String> strings = new ArrayList<>();
        //final Class<? extends List> arrayListClass = strings.getClass();
        final Class<?> arrayListClass = strings.getClass();

        final TypeVariable<? extends Class<?>>[] typeParameters = arrayListClass.getTypeParameters();
        System.out.println("typeParameters = " + Arrays.toString(typeParameters));

        assertEquals("class java.util.ArrayList", arrayListClass.toString());
        assertEquals("public class java.util.ArrayList<E>", arrayListClass.toGenericString());
    } // end

    @Test
    public void shouldGetInformationAboutStringListClass() {

        final Class<StringList> stringListClass = StringList.class;

        final Type arrayListOfString = stringListClass.getGenericSuperclass();

        ParameterizedType parameterizedType = (ParameterizedType) arrayListOfString;

        final String stringListClassParameter = Arrays.toString(parameterizedType.getActualTypeArguments());
        assertEquals("[class java.lang.String]", stringListClassParameter);
    } // end

    public static class StringList extends ArrayList<String> {}

} // end class ReifiableTests
