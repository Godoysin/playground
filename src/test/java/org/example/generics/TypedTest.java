package org.example.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypedTest {

    @Test
    void shouldGetLengthFromGenericMethod() {
        // given
        Integer[] integers = {1, 2};

        // when
        int length = Typed.getLengthWithGenericMethod(integers);

        // then
        assertEquals(integers.length, length);
    }

    @Test
    void shouldGetValueAsString() {
        // given
        Integer integer = 1;

        // when
        String string = Typed.toString(integer);

        // then
        assertEquals(integer.toString(), string);
    }

}
