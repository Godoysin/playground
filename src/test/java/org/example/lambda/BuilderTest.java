package org.example.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTest {

    @Test
    void shouldCreateAStringUsingStreamBuilder() {
        // given
        String expectedResult = "asd";

        // when
        String result = Builder.createAStringUsingStreamBuilder();

        // then
        assertEquals(expectedResult, result);
    }

}
