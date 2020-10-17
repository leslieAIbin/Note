package com.dutlzn.juc.safe;

public class SynDemo {
//    public synchronized void out() {
//        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }


//
//    public synchronized static void staticOut() {
//        System.out.println(Thread.currentThread().getName());
//
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//


    private static Object lock = new Object();
    public void myOut() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        SynDemo synDemo1 = new SynDemo();
        SynDemo synDemo2 = new SynDemo();
        new Thread(()->{
            synDemo1.myOut();
        }).start();
        new Thread(()->{
            synDemo2.myOut();
        }).start();
    }
}
