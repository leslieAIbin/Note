package ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解

public class Test03 {

    // 可以没有顺序
    @MyAnnotation2(name= "luzhenning", age= 12, id = 1, schools={"大连理工","东北大学"})
    public void test() {
    }

    // value 可以省略value=
    @MyAnnotation3(12)
    public void test01() {}

    public static void main(String[] args) {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数： 参数类型+ 参数名()
    // 如果没有默认值 就必须要给注解赋值
    String name() default "";
    int age() default 20;
    // 如果默认值为-1，就代表不存在这个值
    int id() default -1;

    String[] schools() default {"西华大学", "东华大学"};
}


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    int value();
}