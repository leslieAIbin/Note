package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 动态创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.User");
        
        // 构造一个对象
        User user = (User)c1.newInstance(); // 调用了类的无参构造器
        System.out.println(user);

        // 通过构造器创建对象
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)declaredConstructor.newInstance("luzhening", 0, 1);
        System.out.println(user2);

        // 通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke 激活
        // （对象，“方法的值”）
        setName.invoke(user3, "luzhenning");
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);// 可以访问private变量 关闭安全检测就可以了
        name.set(user4, "luzhening2");
        System.out.println(user4.getName());

    }
}
