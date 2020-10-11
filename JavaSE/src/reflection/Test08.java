package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获取类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 1
        Class c1 = Class.forName("reflection.User");
        // 2
        User user = new User();
        c1 = user.getClass();
        // 获取类的名字
        System.out.println(c1.getName());// 获得包名+类名
        System.out.println(c1.getSimpleName()); // 获得类名
        // 获得类的属性 只能找到public属性
        System.out.println("==================");
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 可以找到所有的属性
        System.out.println("==================");
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法 本类及其父类所有public方法
        System.out.println("==================");
        Method[] methods = c1.getMethods();
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 本类的所有方法
        System.out.println("==================");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        // 获取指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName =  c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        // 获得指定构造器 本类public
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        // 本类所有
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        // 获得指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);


    }
}
