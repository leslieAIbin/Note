package JUCBASE;

// 测试礼让线程
// 看cpu心情
public class TestYeild {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"A").start();
        new Thread(myYield, "B").start();
    }
}


class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "thread start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+ "thread stop");
    }

}
