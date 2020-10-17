package com.dutlzn.juc.Thread;

public class Test {
    private static int a = 100;
    static {
        System.out.println(a);
        a = 200;
        System.out.println(a);
    }

    public static void main(String[] args) {

    }
}
