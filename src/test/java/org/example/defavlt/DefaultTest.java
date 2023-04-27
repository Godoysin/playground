package org.example.defavlt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultTest {

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(3, 7),
                Arguments.of(1, 4),
                Arguments.of(1_000, 98)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void shouldHaveAccessToBothDeclaredMethods(int a, int b) {
        // given
        IDefault iDefault = new Default();

        // when
        int sum = iDefault.sum(a, b);
        int subtract = iDefault.subtract(a, b);

        // then
        assertEquals(a+b, sum);
        assertEquals(a-b, subtract);
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void shouldHaveOverwrittenSubtractMethod(int a, int b) {
        // given
        IDefault iDefault = new NewDefault();

        // when
        int sum = iDefault.sum(a, b);
        int subtract = iDefault.subtract(a, b);

        // then
        assertEquals(a+b, sum);
        assertEquals(a*b, subtract);
    }

}
