package com.dutlzn.juc.safe;

/**
 * 懒汉式
 * 在需要的时候 实例化
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public LazySingleton getInstance() {
        if(lazySingleton == null){
            return new LazySingleton();
        } else {
            return lazySingleton;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
            }).start();
        }
    }
}
