package com.sda.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements Counter {

    private AtomicInteger atomicInteger;

    public AtomicIntegerCounter() {
        atomicInteger = new AtomicInteger(0);
    }

    @Override
    public void increment() {
        atomicInteger.incrementAndGet();
    }

    @Override
    public int getCounter() {
        return atomicInteger.get();
    }
}
