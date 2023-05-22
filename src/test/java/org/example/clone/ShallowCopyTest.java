package org.example.clone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShallowCopyTest {

    @Test
    void shouldGetSameStringReference() throws CloneNotSupportedException {
        // given
        ShallowCopy shallowCopy = new ShallowCopy();

        // when
        ShallowCopy shallowCopyCloned = (ShallowCopy) shallowCopy.clone();

        // then
        assertAll(
                "Asserting ShallowCopy fields after cloning",
                () -> assertEquals(shallowCopy.getA(), shallowCopyCloned.getA()),
                () -> assertEquals(shallowCopy.getString(), shallowCopyCloned.getString())
        );
    }

}
