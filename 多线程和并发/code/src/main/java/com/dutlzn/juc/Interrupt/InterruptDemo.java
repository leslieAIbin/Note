package com.dutlzn.juc.Interrupt;

public class InterruptDemo implements Runnable {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());

        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();


    }
}
