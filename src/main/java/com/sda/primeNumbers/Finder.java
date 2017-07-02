package com.sda.primeNumbers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder implements PrimeFounder {
    private int from;
    private int to;
    private int numberOfThreads;

//    @Override
//    public List<Integer> find(int from, int to) {
//        List<Integer> listOfPrimes = new ArrayList<>();
//        //Thread[] arrayOfThreads = new Thread[numberOfThreads];
//
//        int num;
//
//        for (int i = from; i <= to; i++) {
//            int counter = 0;
//            for (num = i; num >= 1; num--) {
//                if (i % num == 0) {
//                    counter = counter + 1;
//                }
//            }
//            if (counter == 2) {
//                //Appended the Prime number to the String
//                listOfPrimes.add(i);
//            }
//        }
//        return listOfPrimes;
//    }

    @Override
    public List<Integer> find(int from, int to) {
        List<Integer> listOfPrimes = new ArrayList<>();

        int num;

        for (int i = from; i <= to; i++) {
            if (i % 2 != 0 || i == 2) {
                int counter = 0;
                for (num = i; num >= 1; num--) {
                    if (i % num == 0) {
                        counter = counter + 1;
                    }
                }
                if (counter == 2) {
                    //Appended the Prime number to the String
                    listOfPrimes.add(i);
                }
            }
        }
        return listOfPrimes;
    }

    public  List<Integer> divideOnScopes(int from, int to, int numberOfThreads) {
        List<Integer> listOfBottomsAndTops = new ArrayList<>();
        int topMinusBottom = to - from;
        int topMinusBottomDividedByNumberOfThread = topMinusBottom / numberOfThreads;
        int bottom = from;
        int top = bottom + topMinusBottomDividedByNumberOfThread;

        listOfBottomsAndTops.add(bottom);
        listOfBottomsAndTops.add(top);

        if (topMinusBottomDividedByNumberOfThread % 2 == 0) {
            for (int i = 1; i < numberOfThreads; i++) {
                bottom = top + 1;
                top = bottom + topMinusBottomDividedByNumberOfThread - 1;

                listOfBottomsAndTops.add(bottom);
                listOfBottomsAndTops.add(top);
            }
        } else {
            for (int i = 0; i < numberOfThreads - 1; i++) {
                bottom += topMinusBottomDividedByNumberOfThread + 1;
                if (i == numberOfThreads - 2)
                    top += topMinusBottomDividedByNumberOfThread + 1;
                else
                    top += topMinusBottomDividedByNumberOfThread + 1;

                listOfBottomsAndTops.add(bottom);
                listOfBottomsAndTops.add(top);
            }
        }
        return listOfBottomsAndTops;
    }

//    public List<Integer> divideOnScopes(int from, int to, int numberOfThreads) throws InterruptedException {
//        List<Integer> listOfPrimes = new ArrayList<>();
//        int bottom;
//        int top;
//
//        int topMinusBottom = to - from;
//        int topMinusBottomDividedByNumberOfThread = topMinusBottom / numberOfThreads;
//
//        bottom = from;
//        top = bottom + topMinusBottomDividedByNumberOfThread;
//
//        listOfPrimes.addAll(find(bottom, top));
//        //System.out.println(bottom + " - " + top); // just for control
//
//        List<Thread> runThreads = new ArrayList<>();
//        List<Task> tasks = new ArrayList<>();
//        if (topMinusBottomDividedByNumberOfThread % 2 == 0) {
//            for (int i = 1; i < numberOfThreads; i++) {
//                bottom = top + 1;
//                top = bottom + topMinusBottomDividedByNumberOfThread - 1;
//                Task task = new Task(bottom,top);
//                Thread thread = new Thread(task);
//                thread.start();
//                runThreads.add(thread);
//                tasks.add(task);
//            }
//
//        } else {
//            for (int i = 0; i < numberOfThreads - 1; i++) {
//                bottom += topMinusBottomDividedByNumberOfThread + 1;
//                if (i == numberOfThreads - 2)
//                    top += topMinusBottomDividedByNumberOfThread + 1;
//                else
//                    top += topMinusBottomDividedByNumberOfThread + 1;
//                listOfPrimes.addAll(find(bottom, top));
//            }
//        }
//
//        //waiting for threads
//        for(Thread thread:runThreads){
//            thread.join();
//        }
//
//        for(Task task:tasks){
//            listOfPrimes.addAll(task.getListOfPrimes());
//        }
//
//
//        return listOfPrimes;
//    }

    public List<Integer> getPrimes(List<Integer> listOfBottomsAndTops) throws InterruptedException {
        List<Thread> runThreads = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        List<Integer> listOfPrimes = new ArrayList<>();

        for (int i = 0, j = 1; i < listOfBottomsAndTops.size(); i += 2, j += 2) {
            Task task = new Task(listOfBottomsAndTops.get(i), listOfBottomsAndTops.get(j));
            Thread thread = new Thread(task);
            System.out.println("Hello in thread " + i + 1);
            thread.start();
            runThreads.add(thread);
            tasks.add(task);
        }
        for(Thread thread:runThreads){
            thread.join();
        }
            for (Task task : tasks) {
            listOfPrimes.addAll(task.getListOfPrimes());
        }
        return listOfPrimes;
    }

    public static void main(String[] args) throws InterruptedException {
        Finder finder = new Finder();
        List<Integer> scope = finder.divideOnScopes(1,10000000,5);
        List<Integer> listOfAllPrimes = finder.getPrimes(scope); // from, to, number of threads

        for (Integer integer : listOfAllPrimes)
            System.out.print(integer + ", ");

        Writer wr = null;
        try {
            wr = new FileWriter("primes.txt");
            wr.write(String.valueOf(listOfAllPrimes));
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//
//        List<Integer> listOfPrimes1 = finder.find(0, 10);
//        List<Integer> listOfPrimes2 = finder.find(11, 20);
//        List<Integer> listOfPrimes3 = finder.find(21, 30);
//        List<Integer> listOfPrimes4 = finder.find(31, 40);
//        List<Integer> listOfPrimes5 = finder.find(41, 50);
//        List<Integer> listOfPrimes6 = finder.find(51, 60);
//        List<Integer> listOfPrimes7 = finder.find(61, 70);
//        List<Integer> listOfPrimes8 = finder.find(71, 80);
//        List<Integer> listOfPrimes9 = finder.find(81, 90);
//        List<Integer> listOfPrimes10 = finder.find(91, 100);
//
//        List<Integer> listOfAllPrimes = new ArrayList<>();
//
//        listOfAllPrimes.addAll(listOfPrimes1);
//        listOfAllPrimes.addAll(listOfPrimes2);
//        listOfAllPrimes.addAll(listOfPrimes3);
//        listOfAllPrimes.addAll(listOfPrimes4);
//        listOfAllPrimes.addAll(listOfPrimes5);
//        listOfAllPrimes.addAll(listOfPrimes6);
//        listOfAllPrimes.addAll(listOfPrimes7);
//        listOfAllPrimes.addAll(listOfPrimes8);
//        listOfAllPrimes.addAll(listOfPrimes9);
//        listOfAllPrimes.addAll(listOfPrimes10);
    }
}
