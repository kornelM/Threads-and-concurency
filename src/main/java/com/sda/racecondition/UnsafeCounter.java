package com.sda.racecondition;

public class UnsafeCounter implements Counter {

    private int counter;

    public UnsafeCounter() {
    }

    @Override
    public void increment(){
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }

}
