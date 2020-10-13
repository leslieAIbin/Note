package syn;




// 不安全的买票
// 线程不安全，有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "小明").start();
        new Thread(buyTicket, "小红").start();
        new Thread(buyTicket, "小黑").start();
    }
}

class BuyTicket implements Runnable {
    // 票
    private int ticketNums = 100;
    // 外部停止方式
    private boolean flag = true;

    @Override
    public void run() {
        while(true) {
            synchronized ((Integer)ticketNums){
                buy();
            }
        }
    }

    // synchronized 同步方法 锁的是this
    private   void buy() {
        // 判断是不是有票
        if(ticketNums <= 0) {
            flag = false;
            return ;
        }

        // 模拟延时
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 买票
        System.out.println(Thread.currentThread().getName() +
                "---->buy " + ticketNums-- + " ticket");
    }
}



//
//// 不安全的买票
//// 线程不安全，有负数
//public class UnsafeBuyTicket {
//    public static void main(String[] args) {
//        BuyTicket buyTicket = new BuyTicket();
//        new Thread(buyTicket, "小明").start();
//        new Thread(buyTicket, "小红").start();
//        new Thread(buyTicket, "小黑").start();
//    }
//}
//
//class BuyTicket implements Runnable {
//    // 票
//    private int ticketNums = 100;
//    // 外部停止方式
//    private boolean flag = true;
//
//    @Override
//    public void run() {
//        // 买票
//        while(flag){
//          buy();
//        }
//    }
//
//    // synchronized 同步方法 锁的是this
//    private synchronized  void buy() {
//        // 判断是不是有票
//        if(ticketNums <= 0) {
//            flag = false;
//            return ;
//        }
//
//        // 模拟延时
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 买票
//        System.out.println(Thread.currentThread().getName() +
//                "---->buy " + ticketNums-- + " ticket");
//    }
//}
//
