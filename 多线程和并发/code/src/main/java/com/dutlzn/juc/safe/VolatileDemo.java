package com.dutlzn.juc.safe;

public class VolatileDemo implements Runnable{
    private static volatile  boolean flag = true;

    @Override
    public void run() {
        while(flag){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
