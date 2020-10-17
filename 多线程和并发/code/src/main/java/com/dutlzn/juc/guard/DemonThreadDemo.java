package com.dutlzn.juc.guard;

/**
 * 守护线程 测试
 */
public class DemonThreadDemo implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DemonThreadDemo());
        thread.setDaemon(true);
        thread.start();
        // 主线程休眠两秒
        Thread.sleep(2000L);

    }
}
