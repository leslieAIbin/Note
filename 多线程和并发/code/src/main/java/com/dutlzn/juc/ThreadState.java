package com.dutlzn.juc;

import java.io.IOException;

public class ThreadState {
    public static void main(String[] args) {
        // Runnable
//        Thread thread = new Thread(
//                ()->{
//                    try {
//                        System.in.read();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
//        thread.start();

//        // Blocked
//        Object obj = new Object();
//        Thread thread0 = new Thread(
//                ()->{
//                    synchronized (obj) {
//                        try {
//                            Thread.sleep(1000_000_000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }
//        );
//        thread0.start();
//
//        // 主线程延时
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Thread thread2 = new Thread(
//                () -> {
//                    synchronized (obj){
//
//                    }
//                }
//        );
//        thread2.start();

        // wait
        Object obj = new Object();

        Thread thread3 = new Thread(
                ()->{
                    synchronized (obj){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread3.start();




    }
}
