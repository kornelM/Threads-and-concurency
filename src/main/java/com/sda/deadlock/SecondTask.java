package com.sda.deadlock;

public class SecondTask implements Runnable {

    private final CommonResource commonResource;

    public SecondTask(CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        commonResource.foo();
        takeANap();
        commonResource.boo();
    }

    private void takeANap()  {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
