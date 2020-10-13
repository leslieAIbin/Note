package JUCBASE;

// 多个线程操作同一个对象
// 买火车票的例子
// 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱，并发问题

public class TestThread04 implements Runnable{
    // 票数
    private int ticketNums = 50;
    @Override
    public void run() {
        while(true){
            if(ticketNums<=0) break;

            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"拿到了第"+ ticketNums-- +"张票");
        }
    }

    public static void main(String[] args) {
        TestThread04 ticket = new TestThread04();
        new Thread(ticket, "陆震宁").start();
        new Thread(ticket,"袁庆").start();
        new Thread(ticket,"官汇华").start();
        new Thread(ticket,"李光哲").start();
        new Thread(ticket,"于洋").start();

    }
}
