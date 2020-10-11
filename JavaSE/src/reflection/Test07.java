package reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类的加载器的父类加载器-->扩展类
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展加载器的父类---> 根加载器(c/c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        // 测试jdk内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        // 如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /**
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\charsets.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\access-bridge-64.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\cldrdata.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\dnsns.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\jaccess.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\jfxrt.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\localedata.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\nashorn.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\sunec.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\sunjce_provider.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\sunmscapi.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\sunpkcs11.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\ext\zipfs.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\jce.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\jfr.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\jfxswt.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\jsse.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\management-agent.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\resources.jar;
         * C:\Users\lzn\.jdks\corretto-1.8.0_265\jre\lib\rt.jar;
         * D:\code\note\JavaSE\out\production\JavaSE;
         * D:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2\lib\idea_rt.jar
         */

        // 双亲委派机制 为了安全
        // java.lang.String  --> 用户类加载器有没有这个包 --> 扩展 --> 根

    }
}
