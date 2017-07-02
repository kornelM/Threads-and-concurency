package com.sda.deadlock;

public class DeadlockDemo {

    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();

        Runnable firstTask = new FirstTask(commonResource);
        Runnable secondTask = new SecondTask(commonResource);

        Thread firstThread = new Thread(firstTask);
        Thread secondThread = new Thread(secondTask);

        firstThread.start();
        secondThread.start();
    }
}
