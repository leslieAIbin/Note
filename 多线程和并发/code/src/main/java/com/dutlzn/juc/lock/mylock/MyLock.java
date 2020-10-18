package com.dutlzn.juc.lock.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
    // 当前有没有锁
    private boolean isHoldLock = false;

    // 上锁的线程
    private Thread holdLockThread = null;

    // 重入次数
    private int reentryCount = 0;

    /**
     * 同一个时刻能且仅能有一个线程获取到锁，
     * 其他线程，只能等待该线程释放锁之后才能获取锁
     */
    @Override
    public synchronized void lock() {
        if (isHoldLock && Thread.currentThread() != holdLockThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        reentryCount++;
    }

    @Override
    public synchronized void unlock() {

        // 判断当前线程是否是持有锁的线程，是，重入次数减去1，不是就是不做处理
        if(Thread.currentThread() == holdLockThread) {
            reentryCount--;
            if(reentryCount == 0){
                notify();
                isHoldLock = false;
            }
        }

    }



    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
