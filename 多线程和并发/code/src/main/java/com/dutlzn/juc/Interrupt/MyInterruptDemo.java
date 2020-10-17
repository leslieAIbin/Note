package com.dutlzn.juc.Interrupt;


public class MyInterruptDemo implements Runnable{

    public static volatile boolean FLAG = true;

    @Override
    public void run() {
        while(FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyInterruptDemo());
        thread.start();


        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FLAG = false;
    }
}
