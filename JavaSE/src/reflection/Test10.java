package reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 分析性能问题
public class Test10 {
    static long epoch = 1000000000;
    // 普通方式调用
    public static  void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for(long i = 0;i<epoch;i++){
            user.getName();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("普通方法执行的时间:"+(endTime-startTime)+"ms");

    }
    // 反射
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
//        Class c1 = Class.forName("reflection.User");
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
//        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for(long i = 0;i<epoch;i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方法执行的时间:"+(endTime-startTime)+"ms");

    }

    // 反射 关闭安全检测
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
//        Class c1 = Class.forName("reflection.User");
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for(long i = 0;i<epoch;i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("关闭安全检测反射方法执行的时间:"+(endTime-startTime)+"ms");

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
