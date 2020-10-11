package ann;

import java.lang.annotation.*;

/**
 * 测试元注解
 */

// 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// rumtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)
// 表示是否将我们的注解生成在JAVAdoc中
@Documented
// 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}

public class Test02 {
    @MyAnnotation
    public void test() {

    }
}
