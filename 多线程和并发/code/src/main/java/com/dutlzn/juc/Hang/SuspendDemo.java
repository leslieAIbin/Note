package com.dutlzn.juc.Hang;

// 线程挂起操作测试
public class SuspendDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                "\t执行run方法准备调用Suspend方法");

        // 线程挂起
        Thread.currentThread().suspend();

        System.out.println(Thread.currentThread().getName() +
                "\t执行run方法，调用Suspend方法结束");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SuspendDemo());

        thread.start();

        // 休眠一下主线程，让效果更加明显
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 线程唤醒
        thread.resume();



    }
}
