package syn;

// 不安全取钱
public class UnsafeBank {
    public static void main(String[] args) {
        // 账户
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account, 50,"你");
        Drawing gf = new Drawing(account, 100, "女朋友");
        you.start();
        gf.start();
    }
}



// 账户
class Account {
    int money;// 余额
    String name; //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行
class Drawing extends Thread {
    Account account; // 账户
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name ){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.nowMoney = nowMoney;
    }

    // synchronized默认锁的是this

    @Override
    public void run() {
      synchronized (account) {
          // 判断有没有钱
          if(account.money - drawingMoney < 0){
              System.out.println(Thread.currentThread().getName() + " 钱不够，取不了");
              return ;
          }

          try {
              // 放大问题的发生性
              Thread.sleep(10);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          // 卡内余额 = 余额 - 你取的钱
          account.money -= drawingMoney;
          // 你手里的钱
          nowMoney += drawingMoney;

          System.out.println(account.name + "余额:"+account.money);
          // this.getName() = Thread.currentThread().getName()
          System.out.println(this.getName() + "手里的钱:"+nowMoney);
      }
    }
}
//
//// 银行
//class Drawing extends Thread {
//    Account account; // 账户
//    // 取了多少钱
//    int drawingMoney;
//    // 现在手里有多少钱
//    int nowMoney;
//
//    public Drawing(Account account, int drawingMoney, String name ){
//        super(name);
//        this.account = account;
//        this.drawingMoney = drawingMoney;
//        this.nowMoney = nowMoney;
//    }
//
//    // synchronized默认锁的是this
//
//    @Override
//    public void run() {
//        // 判断有没有钱
//        if(account.money - drawingMoney < 0){
//            System.out.println(Thread.currentThread().getName() + " 钱不够，取不了");
//            return ;
//        }
//
//        try {
//            // 放大问题的发生性
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 卡内余额 = 余额 - 你取的钱
//        account.money -= drawingMoney;
//        // 你手里的钱
//        nowMoney += drawingMoney;
//
//        System.out.println(account.name + "余额:"+account.money);
//        // this.getName() = Thread.currentThread().getName()
//        System.out.println(this.getName() + "手里的钱:"+nowMoney);
//    }
//}