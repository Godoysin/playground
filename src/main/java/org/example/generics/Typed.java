package org.example.generics;

public class Typed {

    /**
     * Generic method
     */
    public static <E> int getLengthWithGenericMethod(E[] array) {
        return array.length;
    }

    /**
     * Generic method upper-bounded
     */
    public static <T extends Number> String toString(T number) {
        return number.toString();
    }

}
