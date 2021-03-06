package JUCBASE;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟倒计时
 */
public class TestSleep2 implements  Runnable{

    // 模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"\t"+num--);
            if(num<=0){
                break;
            }
        }
    }

    // 打印当前系统系统



    @Override
    public void run() {

    }

    public static void main(String[] args) {
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());// 更新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
