package com.dutlzn.juc.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute( ()-> {
            System.out.println(Thread.currentThread().getName());
        });

    }
}
