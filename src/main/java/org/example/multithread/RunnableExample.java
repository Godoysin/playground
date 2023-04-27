package org.example.multithread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableExample implements Runnable {

    @Override
    public void run() { log.info("do something in a thread"); }

}
