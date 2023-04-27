package org.example.multithread.phaser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class DeregisterTest {

    @Test
    void shouldTestArriveAndDeregister() {
        // given
        Phaser phaser = null;

        // when
        try {
            phaser = Deregister.arriveAndDeregister();
        }

        // then
        catch (Throwable e) {
            fail("The method must not throw any error");
        }

        Phaser finalPhaser = phaser;
        assertAll(
                () -> assertNotNull(finalPhaser),
                () -> assertFalse(finalPhaser.isTerminated()),
                () -> assertEquals(2, finalPhaser.getPhase()),
                () -> assertEquals(2, finalPhaser.getRegisteredParties())
        );
    }

    @Test
    void shouldTerminateThePhaser() {
        // given
        Phaser phaser = null;

        // when
        try {
            phaser = Deregister.terminatePhaser();
        }

        // then
        catch (Throwable e) {
            fail("The method must not throw any error");
        }

        Phaser finalPhaser = phaser;
        assertAll(
                () -> assertNotNull(finalPhaser),
                () -> assertTrue(finalPhaser.isTerminated()),
                () -> assertTrue(finalPhaser.getPhase() < 0),
                () -> assertEquals(0, finalPhaser.getRegisteredParties())
        );
    }

    @Test
    void shouldTestTheManualWaiting() {
        // given
        Phaser phaser = null;

        // when
        try {
            phaser = Deregister.manualWaiting();
        }

        // then
        catch (Throwable e) {
            fail("The method must not throw any error");
        }

        Phaser finalPhaser = phaser;
        assertAll(
                () -> assertNotNull(finalPhaser),
                () -> assertFalse(finalPhaser.isTerminated()),
                () -> assertEquals(1, finalPhaser.getPhase()),
                () -> assertEquals(3, finalPhaser.getRegisteredParties())
        );
    }

}
