package org.example.defavlt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IDefaultTest {

    @Test
    void shouldBeAnInterface() {
        // given

        // when
        Class interfaceClass = IDefault.class;

        // then
        assertTrue(interfaceClass.isInterface());
    }

}
