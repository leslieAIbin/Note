package JUCBASE;

// 测试 守护线程
// 上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        People people = new People();
        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认是false 是用户线程
        thread.start();// 上帝守护线程启动
        Thread thread1 = new Thread(people);
        thread1.start(); // 用户线程启动

    }
}


// 上帝
class God implements  Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑着你");
        }
    }
}


// 你
class People implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        // 守护线程 gc s
        System.out.println("======GoodBye!World!========");
    }
}
