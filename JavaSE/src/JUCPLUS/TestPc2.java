package JUCPLUS;

// 测试 生产者消费者， 标记位， 信号灯法
public class TestPc2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

// 生产者 --> 演员
class Player extends  Thread {
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                this.tv.play("生活大爆炸");
            } else {
                this.tv.play("破产姐妹");
            }
        }
    }
}
// 消费者 --> 观众
class Watcher extends  Thread {
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
// 产品 --> 节目
class TV {
    // 演员等待，观众等待
    // 观众观看，演员等待
    String video;// 表演的节目
    boolean flag = true;

    // 表演
    public synchronized void play(String video){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了:"+video);
        // 通知观众观看
        this.notifyAll();// 通知 唤醒
        this.video = video;
        this.flag = !this.flag;
    }

    // 观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了"+video);
        // 通知演员表演
        this.notifyAll();
        this.flag = !this.flag;

    }
}
