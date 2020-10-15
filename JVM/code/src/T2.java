
class MyNumber {
    // int number = 10; // 会卡死
    volatile  int number = 10;

    public void addTo1205() {
        this.number = 1205;
    }
}

/**
 * JMM = 可见性（通知机制） a线程改了，b线程立马被通知，过来拿值
 */
public class T2 {
    public static void main(String[] args){
        MyNumber  myNumber = new MyNumber();
        new Thread(() -> {
            System.out.println("A come ");
            // 暂停一会线程
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myNumber.addTo1205(); // 将10 修改为 1205
            System.out.println(Thread.currentThread().getName() + "\t" +
                    myNumber.number);

        }, "A").start();

        System.out.println("test");

        while(myNumber.number == 10){
            // 需要有一种通知机制告诉main线程，number已经修改为1205，跳出1205
            // 实际上，线程a已经修改了number但是没有人去通知main线程 所以卡死在这里

        }

        System.out.println(Thread.currentThread().getName()+"\t"+ "mission is over");

    }
}


