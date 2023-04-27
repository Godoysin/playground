package org.example.lambda;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NullTest {

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of(2, true),
                Arguments.of(3_000, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void shouldCreateAnStreamThatDoNotThrowNullPointerExceptions(Integer integer, boolean result) {
        // given

        // when
        Optional<Integer> optionalInteger = Null.generateIntegerStream(integer);

        // then
        assertEquals(result, optionalInteger.isPresent());
    }

}
