import java.util.Random;

public class JVMCode {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        //返回 Java虚拟机试图使用的最大内存量。物理内存的1/4（-Xmx）
        long maxMemory = Runtime.getRuntime().maxMemory() ;
        //返回 Java虚拟机中的内存总量(初始值)。物理内存的1/64（-Xms）
        long totalMemory = Runtime.getRuntime().totalMemory() ;
        System.out.println("MAX_MEMORY =" + maxMemory +"(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("DEFALUT_MEMORY = " + totalMemory + " (字节)、" + (totalMemory / (double)1024 / 1024) + "MB");

        System.out.println((305664+ 699392)/1024);

        // 模拟OOM
//        String str = "luzhenning";
//        while(true){
//            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
//        }

        byte[] bytes = new byte[40*1024*1024];


    }
}
