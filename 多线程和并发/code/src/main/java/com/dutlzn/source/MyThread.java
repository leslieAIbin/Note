package com.dutlzn.source;

public class MyThread extends Thread{
    private boolean flag = false;
    Object obj = new Object();

    @Override
    public void run() {
        while(!flag) {
//            synchronized (obj) {
//                try {
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    System.out.println("线程处于阻塞状态时，中断线程，就会抛出异常");
//                    e.printStackTrace();
//                }
//            }
            System.out.println("无敌");
        }
    }

    public void toStop() {
        this.flag = !this.flag;
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1000);

//        t.toStop();// 通知线程t关闭
//        t.join();// 等待线程t退出while循环，自行退出
//        t.interrupt();
//        针对 wait() sleep() join()
//        中断：https://blog.csdn.net/smiles13/article/details/81292608

//                t.toStop();// 通知线程t关闭
//        t.join();// 等待线程t退出while循环，自行退出
//        t.yeild();

//        sleep执行后线程进入阻塞状态
//
//        yield执行后线程进入就绪状态
//        Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。

//
//        join执行后线程进入阻塞状态
//        https://www.zhihu.com/question/35926652
    }

}
