package com.dutlzn.juc.safe;


/**
 * 饿汉式单例模式
 * 在类加载的时候，就已经有实例化了
 *
 */
public class HungerSingleton {
    private static HungerSingleton ourInstance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return ourInstance;
    }

    private HungerSingleton() {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(
                    () -> {
                        System.out.println(HungerSingleton.getInstance());
                    }
            ).start();
        }
    }
}
