package com.sda.racecondition;

public class IncreaseCounterTask implements Runnable {

    private static final int ITERATION = 100;
    private final Counter counter;

    public IncreaseCounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < ITERATION; ++i) {
            counter.increment();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
