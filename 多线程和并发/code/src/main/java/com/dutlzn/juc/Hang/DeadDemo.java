package com.dutlzn.juc.Hang;

/**
 * suspend 死锁问题
 */
public class DeadDemo implements Runnable{

    private static Object object = new Object();

    @Override
    public void run() {
        // 持有资源
        synchronized (object){
            System.out.println(Thread.currentThread().getName() + "占用资源");
            Thread.currentThread().suspend();
        }

        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DeadDemo(), " 对比线程");
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.resume();


        Thread thread2 = new Thread(new DeadDemo(), "死锁线程");

        thread2.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        thread2.resume();
    }
}
