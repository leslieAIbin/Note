package com.dutlzn.juc.Unsafe;

import java.util.concurrent.CountDownLatch;

// 线程不安全例子
public class UnsafeDemo {
    private static  int num = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    static synchronized void inCreate() {
        num++;
    }

    public static void main(String[] args) {
        System.out.println("unsafe test");
//        inCreate();
//        System.out.println(num);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    inCreate();

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //每个线程执行完成之后，调用countdownLatch
                countDownLatch.countDown();
            }).start();

        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println(num);

        while(true){
            if(countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }
    }

}
