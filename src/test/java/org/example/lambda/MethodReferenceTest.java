package org.example.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodReferenceTest {

    @Test
    void shouldGetMessageFromStaticMethodReference() {
        // given
        String response;

        // when
        response = MethodReference.staticMethodReference();

        // then
        final String finalResponse = response;
        assertAll(
                () -> assertEquals(MethodReference.STATIC_MESSAGE, finalResponse)
        );
    }

    @Test
    void shouldGetMessageFromInstantiatedMethodReference() {
        // given
        String response;

        // when
        response = MethodReference.instantiatedMethodReference();

        // then
        final String finalResponse = response;
        assertAll(
                () -> assertEquals(MethodReference.INSTANTIATED_MESSAGE, finalResponse)
        );
    }

    @Test
    void shouldGetMessageWithConstructorMethodReference() {
        // given
        String response;

        // when
        response = MethodReference.constructorMethodReference();

        // then
        final String finalResponse = response;
        assertAll(
                () -> assertEquals(Message.MESSAGE, finalResponse)
        );
    }

}
