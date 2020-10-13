package JUCBASE;

// 创建线程方式二，实现runnable接口，重写run ，执行线程需要丢入runnable接口的实现类，调用start
public class TestThread03 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            System.out.println(i+"\t"+"我在看代码");
        }
    }

    public static void main(String[] args) {
        // main线程，主线程
        // 创建runnable实现类
        TestThread03 testThread03 = new TestThread03();
        // 创建线程对象，通过线程来开启我们的线程，代理
        Thread thread = new Thread(testThread03);

        thread.start();

        for(int i = 0;i<20;i++){
            System.out.println(i+"\t"+"我在看多线程");
        }

    }
}
