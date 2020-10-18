package com.dutlzn.juc.lock.mylock;

import java.util.concurrent.locks.Lock;

// 可重入测试
public class ReetryDemo {
    private Lock lock = new MyLock();

    public void methodA() {
        lock.lock();
        System.out.println("进入方法a");
        methodB();
        lock.unlock();
    }

    public void methodB() {
        lock.lock();
        System.out.println("进入方法b");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReetryDemo reetryDemo = new ReetryDemo();
        reetryDemo.methodA();
    }


}
