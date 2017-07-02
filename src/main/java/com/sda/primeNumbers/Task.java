package com.sda.primeNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kornel on 29.06.17.
 */
public class Task implements Runnable {
    Finder finder = new Finder();
    private int from;
    private int to;
    private List<Integer> listOfPrimes = new ArrayList<>();


    public Task(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public List<Integer> getListOfPrimes() {
        return listOfPrimes;
    }

    @Override
    public void run() {
        listOfPrimes = finder.find(from, to);
    }
}
