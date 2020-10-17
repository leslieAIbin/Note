package com.dutlzn.juc.Thread;

/**
 * 多线程睡眠测试
 */

class SleepObjA implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "\tA start");

            try {
                System.out.println(i + "\tA sleep start");
                Thread.sleep(100);
                System.out.println(i + "\tA sleep over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "\tA over");
        }
    }
}

class SleepObjB implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "\tB start");

            try {
                System.out.println(i + "\tB sleep start");
                Thread.sleep(100);
                System.out.println(i + "\tB sleep over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "\tB over");
        }
    }
}

public class ThreadSleepDemo {
    public static void main(String[] args) {
        new Thread(new SleepObjA()).start();
        new Thread(new SleepObjB()).start();
    }
}
