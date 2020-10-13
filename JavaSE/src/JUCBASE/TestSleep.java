package JUCBASE;

// 测试线程休眠 模拟网络延时 放大问题的发生性
public class TestSleep implements Runnable{
    // 票数
    private static int ticketNums = 100;
    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0) break;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"--->拿到了 第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"小明").start();
        new Thread(testSleep, "小张").start();
        new Thread(testSleep, "小红").start();


    }
}
