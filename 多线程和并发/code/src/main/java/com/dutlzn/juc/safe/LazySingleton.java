package com.dutlzn.juc.safe;

/**
 * 懒汉式
 * 在需要的时候 实例化
 */
public class LazySingleton {

    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public  static  LazySingleton getInstance() {
        if(lazySingleton == null){
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 锁住

            synchronized (LazySingleton.class) {
                if(lazySingleton == null){
                    lazySingleton =  new LazySingleton();
                }
            }
        }

        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }
}
