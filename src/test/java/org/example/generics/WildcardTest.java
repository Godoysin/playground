package org.example.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardTest {

    @Test
    void shouldJoinLists() {
        // given
        List<String> stringList = new ArrayList<>();
        stringList.add("a");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        // when
        List<Object> objectList = Wildcard.joinLists(stringList, integerList);

        // then
        assertEquals("a", objectList.get(0));
        assertEquals(1, objectList.get(1));
    }

    @Test
    void shouldAppendElementsAsString() {
        // given
        List<Object> numberList = new ArrayList<>();
        numberList.add(1.1);
        numberList.add(3);
        numberList.add(new Object());

        // when
        String string = Wildcard.getElementClassesConcatenated(numberList);

        // then
        assertEquals(Double.class.toString() + Integer.class + Object.class, string);
    }

    @Test
    void shouldSumElementsAsDoublePrimitive() {
        // given
        double doubleNumber = 3.0;

        List<Number> numberList = new ArrayList<>();
        numberList.add(1.1);
        numberList.add(3);
        numberList.add(new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return doubleNumber;
            }
        });

        // when
        double d = Wildcard.sumElements(numberList);

        // then
        assertEquals(1.1 + 3 + doubleNumber, d);
    }

    @Test
    void shouldPopulateAConsumerList() {
        // given
        int i = 3;
        double d = 3.0;
        float f = 1;
        short s = 7;

        // when
        List<Object> objectList = Wildcard.consumerList(i, d, f, s);

        // then
        assertAll(
                () -> assertEquals(i, objectList.get(0)),
                () -> assertEquals(d, objectList.get(1)),
                () -> assertEquals(f, objectList.get(2)),
                () -> assertEquals(s, objectList.get(3))
        );
    }

    @Test
    void shouldJoinNumbersFromTwoChildLists() {
        // given
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.5);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        // when
        List<Number> numberList = Wildcard.joinNumberLists(doubleList, integerList);

        // then
        assertAll(
                () -> assertEquals(doubleList.get(0), numberList.get(0)),
                () -> assertEquals(integerList.get(0), numberList.get(1))
        );
    }

    @Test
    void shouldCreateAnObjectListFromIntegerList() {
        // given
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        // when
        List<Object> objectList = Wildcard.toObjectList(integerList);

        // then
        assertAll(
                () -> assertEquals(Integer.class, objectList.get(0).getClass()),
                () -> assertEquals(integerList.get(0), objectList.get(0))
        );
    }

}
