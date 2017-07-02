package com.sda.hello;

public class ThreadDemo {

    public static void main(String[] args) {

        Runnable runnable = ()-> System.out.println("Hello from a new thread");

        Thread thread = new Thread(runnable);

        thread.start();

    }
}
