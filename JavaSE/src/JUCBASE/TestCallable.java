package JUCBASE;

// 线程创建方式三，实现callable接口
// 可以返回值
// 可以抛出异常

import java.util.concurrent.*;

/**
 *
 */
public class TestCallable implements Callable<Boolean> {
    private String url;// 网络图片地址
    private String name;// 保存的文件名


    public TestCallable(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载的文件名:"+name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testThread1 = new TestCallable("https://img2020.cnblogs.com/blog/1418974/202003/1418974-20200320135649063-435423503.png",
                "1.jpg");
        TestCallable testThread2 = new TestCallable("https://img2020.cnblogs.com/blog/1418974/202003/1418974-20200320135721808-908348729.png",
                "2.jpg");
        TestCallable testThread3 = new TestCallable("https://img2020.cnblogs.com/blog/1418974/202003/1418974-20200320135956283-652116004.png" ,
        "3.jpg");


        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> r1 = service.submit(testThread1);
        Future<Boolean> r2 = service.submit(testThread2);
        Future<Boolean> r3 = service.submit(testThread3);

        // 获取结果
        boolean b1 = r1.get();
        boolean b2 = r2.get();
        boolean b3 = r3.get();

        // 关闭服务
        service.shutdown();






    }


}



