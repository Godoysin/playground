package org.example.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoxTest {

    @Test
    void shouldCreateBoxWithInteger() {
        // given
        Integer i = 1;

        // when
        Box<Integer> integerBox = new Box<>(i);

        // then
        assertEquals(i, integerBox.getT());
    }

}
