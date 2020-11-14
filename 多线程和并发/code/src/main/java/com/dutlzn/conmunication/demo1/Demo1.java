package com.dutlzn.conmunication.demo1;

public class Demo1 {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        new Thread(() -> {
            while(!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(() -> {
            synchronized (obj) {
                obj.notify();
            }
        }).start();

    }
}
