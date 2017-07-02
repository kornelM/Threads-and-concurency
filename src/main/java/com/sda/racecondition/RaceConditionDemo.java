package com.sda.racecondition;

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = null;
        counter = new UnsafeCounter();

        Runnable firstTask = new IncreaseCounterTask(counter);
        Runnable secondTask = new IncreaseCounterTask(counter);
        Runnable thirdTask = new IncreaseCounterTask(counter);


        Thread firstThread = new Thread(firstTask);
        Thread secondThread = new Thread(secondTask);
        Thread thirdThread = new Thread(thirdTask);

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();

        System.out.println("Counter = "+counter.getCounter());

    }



}
