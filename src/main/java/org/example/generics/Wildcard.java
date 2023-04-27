package org.example.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Wildcard {

    /**
     * Unbounded Wildcard
     */
    public static List<Object> joinLists(List<?> firstList, List<?> secondList) {
        List<Object> objectList = new ArrayList<>();

        objectList.addAll(firstList);
        objectList.addAll(secondList);

        return objectList;
    }

    /**
     * Bounded lower Wildcard
     */
    public static String getElementClassesConcatenated(Collection<? super Double> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : collection) {
            stringBuilder.append(object.getClass());
        }
        return stringBuilder.toString();
    }

    /**
     * Bounded upper Wildcard
     * It is also an example of Consumer that extends
     */
    public static double sumElements(Collection<? extends Number> collection) {
        double sum = 0.0;
        for (Number number : collection)
            sum += number.doubleValue();
        return sum;
    }

    /**
     * Producer that super
     */
    public static List<Object> consumerList(Integer i, Double d, Float f, Short s) {
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(i);
        numbers.add(d);
        numbers.add(f);
        numbers.add(s);

        return new ArrayList<>(numbers);
    }

    public static List<Number> joinNumberLists(List<? extends Number> firstList, List<? extends Number> secondList) {
        List<Number> numberList = new ArrayList<>();

        numberList.addAll(firstList);
        numberList.addAll(secondList);

        return numberList;
    }

    public static List<Object> toObjectList(List<Integer> populatedIntegerList) {
//        List<Object> objectList = populatedIntegerList; // Error
//        List<Object> objectList = (List<Object>) populatedIntegerList; // Error

        List<?> wildcardList = populatedIntegerList;

        return (List<Object>) wildcardList; // Unchecked cast
    }

}
