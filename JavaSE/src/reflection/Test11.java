package reflection;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
// 通过反射获取泛型
public class Test11 {
    public void test01(Map<String, User> map,
                       List<User> list){
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = Test11.class.getMethod("test01", Map.class, List.class);

        // 获得泛型的参数类型
        Type[] genericParameterTypes = test01.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("####"+genericParameterType);
            // 是不是结构化参数类型
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }

            }
        }

        System.out.println("===================");
        Method test02 = Test11.class.getMethod("test02", null);
        Type genericParameterType = test02.getGenericReturnType();
        if(genericParameterType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }

        }

    }
}
