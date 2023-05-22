package org.example.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OptionalTest {

    @Test
    void shouldMakeDataTypeChangeAndDoubleTheValue() {
        // given
        int value = 100;

        Optional<Integer> optionalInteger = Optional.ofNullable(value);
        Optional<Byte> optionalFiltered = optionalInteger.filter(e -> e > 10).map(Integer::byteValue);

        // when
        Integer optionalFlattened = optionalInteger.filter(e -> e > 10).map(e -> e*2).orElse(0);

        // then
        assertFalse(optionalFiltered.isEmpty());
        assertEquals(value*2, optionalFlattened);
    }

}
