package com.dutlzn.juc.Hang;

public class WaitDemo implements Runnable{

    private static Object object = new Object();
    private static Object waitObj = new Object();

    @Override
    public void run() {
        // 持有资源
        synchronized (waitObj){
            System.out.println(Thread.currentThread().getName() + "占用资源");
            try {
                waitObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new WaitDemo(), " 对比线程");
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (waitObj) {
            waitObj.notify();
        }


    }
}
