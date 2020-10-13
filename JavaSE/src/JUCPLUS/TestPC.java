package JUCPLUS;

import java.lang.reflect.ParameterizedType;

// 测试消费者 生产者模型->管程法 利用缓冲区
// 生产者，消费者，产品，缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producter(container).start();
        new Consumer(container).start();
    }

}

// 生产者
class Producter extends Thread {
    SynContainer container;

    public Producter(SynContainer container){
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产力"+i+"只鸡");
        }
    }

}

// 消费者
class Consumer extends  Thread {
    SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    // 消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop().id + "只鸡");
        }
    }
}

// 产品
class Chicken {
    public int id;// 产品编号
    public Chicken(int id){
        this.id = id;
    }
}

// 缓冲区
class SynContainer {
    // 需要容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;
    // 生产者 丢入产品
    public synchronized void push(Chicken chicken) {
        // 如果容器满了，就需要等待消费者消费
        // 脏读 if--->while （https://blog.csdn.net/qq_36974281/article/details/81951006）
        while(count == chickens.length){
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 没有满，我们就需要丢入产品
        chickens[count++] = chicken;
        this.notifyAll();
    }
    // 消费者 消费产品
    public synchronized Chicken pop() {
        // 判断能否消费
        if(count == 0){
            //等待胜生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果可以消费
        count--;
        Chicken chicken =chickens[count];
        // 吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }
}
