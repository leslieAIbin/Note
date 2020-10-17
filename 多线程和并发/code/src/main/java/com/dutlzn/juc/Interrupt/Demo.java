package com.dutlzn.juc.Interrupt;

public class Demo implements Runnable{
    private static int index = 0;

    @Override
    public void run() {
        while(true){
            index++;
            System.out.println(index + "\t" +Thread.currentThread().getName());

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new Demo());
        thread.start();

        // 主线程睡眠
        try {
            Thread.sleep(4*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 废弃方法,不推荐使用
        thread.stop();

    }
}
