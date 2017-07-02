package com.sda.racecondition;

public class SyncCounter implements Counter {

    private int counter;

    public SyncCounter() {
    }


    @Override
    public synchronized void increment(){
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
