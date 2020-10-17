package com.dutlzn.juc.Thread;

// 匿名内部类
public class MyThread2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.setName("线程3");

        thread.start();
    }
}
