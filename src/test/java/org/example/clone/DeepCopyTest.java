package org.example.clone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeepCopyTest {

    @Test
    void shouldNotGetSameStringReference() throws CloneNotSupportedException {
        // given
        DeepCopy deepCopy = new DeepCopy();

        // when
        DeepCopy deepCopyCloned = (DeepCopy) deepCopy.clone();

        // then
        assertAll(
                "Asserting DeepCopy fields after cloning",
                () -> assertEquals(deepCopy.getA(), deepCopyCloned.getA()),
                () -> assertNotEquals(deepCopy.getString(), deepCopyCloned.getString())
        );
    }

}
