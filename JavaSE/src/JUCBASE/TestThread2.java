package JUCBASE;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// 练习thread 实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;// 网络图片地址
    private String name;// 保存的文件名


    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载的文件名:"+name);
    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("https://img2020.cnblogs.com/blog/1418974/202003/1418974-20200320135649063-435423503.png",
                "1.jpg");
        TestThread2 testThread2 = new TestThread2("https://img2020.cnblogs.com/blog/1418974/202003/1418974-20200320135721808-908348729.png",
                "2.jpg");
        TestThread2 testThread3 = new TestThread2("https://img2020.cnblogs.com/blog/1418974/202003/1418974-20200320135956283-652116004.png" ,
                "3.jpg");

        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

// 下载器
class WebDownLoader {
    // 下载方法
    public void downloader(String url, String name)  {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
            // 捕获io异常
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
