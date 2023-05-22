package org.example.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PrivateInnerClassTest {

    @Test
    void shouldAccessPrivateMethodOnPrivateInnerClass() {
        // given
        int testNum = 4;
        int result = 0;

        // when
        try {
            result = PrivateInnerClass.returnFromPrivate(testNum);

        // then
        } catch (Exception e) {
            fail("asd");
        }

        assertEquals(testNum * 2, result);
    }

}
