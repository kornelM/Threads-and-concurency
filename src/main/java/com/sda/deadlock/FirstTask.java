package com.sda.deadlock;

public class FirstTask implements Runnable {

    private final CommonResource commonResource;

    public FirstTask(CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        commonResource.boo();
        takeANap();
        commonResource.foo();
    }

    private void takeANap()  {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
