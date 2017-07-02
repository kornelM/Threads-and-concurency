package com.sda.deadlock;

public class CommonResource {

    public void boo(){
        System.out.println("Inside boo()");
        synchronized (Integer.class){
            System.out.println("boo:I want to execute internal block");
            synchronized (Long.class){
                System.out.println("boo:Inside internal block");
            }
        }
    }


    public void foo(){
        System.out.println("Inside foo()");
        synchronized (Long.class){
            System.out.println("foo:I want to execute internal block");
            synchronized (Integer.class){
                System.out.println("foo:Inside internal block");
            }
        }
    }

}
