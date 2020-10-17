package com.dutlzn.juc.Interrupt;

public class UnsafeWithStop implements Runnable{
    private int i = 0;
    private int j = 0;

    @Override
    public void run() {
        i++;

        // 该线程还在休眠，主线程已经结束了
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        j++;
    }

    public void printf(){
        System.out.println("val of i: "+i +"\t val of j: "+j);
    }

    public static void main(String[] args) {
        UnsafeWithStop unsafeWithStop = new UnsafeWithStop();
        Thread thread = new Thread(unsafeWithStop);
        thread.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.stop();
        unsafeWithStop.printf();
    }
}
