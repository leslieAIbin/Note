package com.dutlzn.juc.lock.mylock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeThread {
    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

//    private static Lock lock = new ReentrantLock();
    // 用自己实现的锁
    private static Lock lock = new MyLock();
    /**
     * 每次调用对num进行++操作
     */
//
//    public  static void inCreate() {
//        // 非原子性操作
//        num++;
//    }
    public static void inCreate() {
        // 上锁
        lock.lock();
        // 非原子性操作
        num++;
        // 释放锁
        lock.unlock();
    }

    public static void test() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    inCreate();

                    // 线程适当休眠
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //每个线程执行完成之后，调用countdownLatch
                countDownLatch.countDown();
            }).start();

        }

            while(true){
                if(countDownLatch.getCount() == 0){
                    System.out.println(num);
                    break;
                }
            }
        }
    }



