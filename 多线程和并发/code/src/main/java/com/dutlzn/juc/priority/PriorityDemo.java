package com.dutlzn.juc.priority;

/**
 * 线程优先级 测试
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "线程1");

        Thread thread2 = new Thread(() -> {
            while(true){
                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "线程2");


        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
