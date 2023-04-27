package org.example.multithread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RunnableExampleTest {

    @Test
    void shouldGenerateTwoThreads() {
        log.info("In shouldGenerateTwoThreads, runnable1 and runnable2 (after converted to threads) are executed over new threads");
        Runnable runnable1 = new RunnableExample();
        Runnable runnable2 = new RunnableExample();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

    @Test
    void shouldGenerateTwoRunnable() {
        log.info("In shouldGenerateTwoRunnable, runnable1 and runnable2 are executed over main thread");
        Runnable runnable1 = new RunnableExample();
        Runnable runnable2 = new RunnableExample();

        runnable1.run();
        runnable2.run();
    }

}
