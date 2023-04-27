package org.example.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTypesTest {

    @Test
    void shouldLaunchCheckedException() {
        // given

        // when
        Executable executable = ExceptionTypes::throwCheckedException;

        // then
        assertThrows(Exception.class, executable);
    }

    @Test
    void shouldLaunchUncheckedException() {
        // given

        // when
        Executable executable = ExceptionTypes::throwUncheckedException;

        // then
        assertThrows(RuntimeException.class, executable);
    }

}
