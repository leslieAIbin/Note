package ann;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    // 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // 不推荐使用
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }


    // 镇压警告 可以放到类或者方法上
    @SuppressWarnings("all")
    public void test02() {
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
