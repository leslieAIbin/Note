package JUCBASE;

// 测试停止线程
// 1 建议线程正常停止 -->  利用次数、不建议死循环
// 2 建议使用标志位 --> 设置标记
// 3 不要使用stop或者destroy等过时，或者jdk不推荐使用的方法
public class TestStop implements Runnable{
    // 1 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run....Thread"+i++);
        }
    }

    // 设置一个公开的方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop stop = new TestStop();
        new Thread(stop).start();

        for(int i = 0;i<20;i++){
            System.out.println("main...."+i);

            if(i == 10){

                // 调用标志位切换方法，停止线程
                stop.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
