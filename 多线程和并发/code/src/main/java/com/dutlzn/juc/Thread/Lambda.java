package com.dutlzn.juc.Thread;

public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
