package org.example.multithread.phaser;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

@Slf4j
public class Deregister {

    public static Phaser arriveAndDeregister() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // create an instance of Phaser with 3 registered parties
        Phaser phaser = new Phaser(3);

        try {
            for (int i = 0; i < 2; i++) {
                executorService.execute(() -> {
                    log.info("About to arrive at the barrier");
                    phaser.arriveAndAwaitAdvance();
                    log.info("Moving past the phaser once");
                    phaser.arriveAndAwaitAdvance();
                    log.info("Moving past the phaser twice");
                });
            }

            log.info("Before sleep. " +
                    "\n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Non arrived parties: " + phaser.getUnarrivedParties());

            // sleep for a while to simulate work that the main thread needs to get done before
            // letting the spawn threads proceed forward.
            Thread.sleep(5000);

            log.info("Main thread arriving and unregistering");
            phaser.arriveAndDeregister();

            log.info("Past the barrier. " +
                    "\n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Non arrived parties: " + phaser.getUnarrivedParties());

            return phaser;

        } finally {
            executorService.shutdown();
        }
    }

    public static Phaser terminatePhaser() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // create an instance of Phaser with 3 registered parties
        Phaser phaser = new Phaser(2);

        try {
            for (int i = 0; i < 2; i++) {
                executorService.execute(() -> {
                    log.info("About to arrive at the barrier");
                    phaser.arriveAndAwaitAdvance();
                    log.info("Moving past the phaser once");
                    phaser.arriveAndDeregister();
                    log.info("Moving past the phaser twice");
                });
            }

            log.info("Before sleep. " +
                    "\n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Non arrived parties: " + phaser.getUnarrivedParties());

            // sleep for a while to simulate work that the main thread needs to get done before
            // letting the spawn threads proceed forward.
            Thread.sleep(5000);

            log.info("Past the barrier. " +
                    "\n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Non arrived parties: " + phaser.getUnarrivedParties());

            return phaser;

        } finally {
            executorService.shutdown();
        }
    }

    public static Phaser manualWaiting() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Creates an instance of Phaser with 2 registered parties
        Phaser phaser = new Phaser(2);

        log.info("Initial registered parties: {}", phaser.getRegisteredParties());

        // Adds 1 party
        phaser.bulkRegister(1);
        try {
            for (int i = 0; i < 2; i++) {
                executorService.execute(() -> {
                    log.info("About to arrive at the at phase: {}", phaser.getPhase());
                    phaser.arrive();
                    phaser.awaitAdvance(0);
                    log.info("Moving past the phase: {}", phaser.getPhase());
                });
            }

            // Time to let parties arrive
            Thread.sleep(2000);
            log.info("Before sleep. " +
                    "\n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Non arrived parties: " + phaser.getUnarrivedParties());

            // sleep for a while to simulate work that the main thread needs to get done before
            // letting the spawn threads proceed forward.
            log.info("Current phase: {}", phaser.getPhase());
            Thread.sleep(3000);

            executorService.execute(() -> {
                log.info("About to arrive at the at phase: {}", phaser.getPhase());
                phaser.arrive();
                phaser.awaitAdvance(0);
                log.info("Moving past to phase: {}", phaser.getPhase());
            });

            Thread.sleep(5000);

            log.info("Past the barrier. " +
                    "\n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Non arrived parties: " + phaser.getUnarrivedParties());

            return phaser;

        } finally {
            executorService.shutdown();
        }
    }
}
