package JUCBASE;

// 测试线程强制执行
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("vip coming:"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin, "a");
        thread.start();


        // 主线程
        for (int i = 0; i < 300; i++) {
            if(i == 200){
                // 让主线程等着，vip线程先执行完，再说。 少用，会让线程阻塞
                thread.join();
            }

            System.out.println("main "+i);
        }
    }
}
