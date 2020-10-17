package com.dutlzn.juc;

// 死锁

public class DeadLockDemo {
    private static final Object objectA = new Object();
    private static final Object objectB = new Object();

    public static void main(String[] args) {


        new Thread(() -> {
            System.out.println("A come in");
            synchronized (objectA) {

                // 增加线程休眠，就会有死锁发生
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB) {
                    System.out.println("A 抓住了 B 的头发");
                }
            }
        }).start();


        new Thread(() -> {
            System.out.println("B come in");
            synchronized (objectB) {
                synchronized (objectA){
                    System.out.println("B 抓住了 A 的头发");
                }
            }
        }).start();


//        错误效果不明显， Thread.sleep 可以放大错误
//        new Thread(() -> {
//            System.out.println("A come in");
//            synchronized (objectA) {
//                synchronized (objectB) {
//                    System.out.println("A 抓住了 B 的头发");
//                }
//            }
//        }).start();
//
//
//        new Thread(() -> {
//            System.out.println("B come in");
//            synchronized (objectB) {
//                synchronized (objectA){
//                    System.out.println("B 抓住了 A 的头发");
//                }
//            }
//        }).start();
    }
}
