package com.sda.racecondition;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kornel on 29.06.17.
 */
public class CounterTest {

    private Counter counter;

    @Before
    public void setUp() {
        counter = new UnsafeCounter();
    }

    @Test
    public void testCountToThree() {
        counter.increment();
        counter.increment();
        counter.increment();

        Assert.assertEquals(3, counter.getCounter());
    }

    @Test
    public void shouldReturn300WhenRunMultiTHread() throws InterruptedException {

        Task increment = new Task(counter, 100);
        Thread first = new Thread(increment);
        Thread second = new Thread(increment);
        Thread third = new Thread(increment);


        first.start();
        second.start();
        third.start();

        first.join();
        second.join();
        third.join();


        Assert.assertEquals(300, counter.getCounter());
    }


    static class Task implements Runnable {
        private Counter counter;
        private int iterationNumber;

        public Task(Counter counter, int iterationNumber) {
            this.counter = counter;
            this.iterationNumber = iterationNumber;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterationNumber; i++) {
                counter.increment();
            }
        }
    }


    @Test
    public void shouldReturn10WhenRunMultiThread() {

        for (int i = 0; i < 10; i++) {
            counter.increment();
        }

        Assert.assertEquals(10, counter.getCounter());
    }


    @Test
    public void shouldReturn1000000000WhenRunMutliThread() throws InterruptedException {

        Task myTask = new Task(counter, 30000);

        Thread firstThread = new Thread(myTask);
        Thread secondThread = new Thread(myTask);
        Thread thirdThread = new Thread(myTask);

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();

        Assert.assertEquals(90000, counter.getCounter());

    }
}
