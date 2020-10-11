package JUCBASE;

// 创建线程方式一： 继承Thread 重写run()方法 调用start开启线程
// 总结： 线程开启，不一定立即执行，由cpu调度执行
public class Test01 extends Thread{
    @Override
    public void run() {
        // run 方法线程体
        for(int i = 0 ;i<20;i++){
            System.out.println("我在看代码---"+i);
        }
    }

    public static void main(String[] args) {
        // main线程 主线程
        // 创建一个线程对象
        Test01 test01 = new Test01();
        // 调用start() 方法开启线程
        test01.start();
        for(int i = 0;i<20;i++){
            System.out.println("我在学习多线程---"+i);
        }

    }
}
