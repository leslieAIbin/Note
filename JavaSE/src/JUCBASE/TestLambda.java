package JUCBASE;

// 推导lambda 表达式
public class TestLambda {
    // 3 静态内部类
    static class Like2 implements ILike {
        @Override
        public void Lambda() {
            System.out.println("I like lambda2");
        }
    }


    public static void main(String[] args) {
        // 4 局部内部类
        class Like3 implements  ILike {
            @Override
            public void Lambda() {
                System.out.println("I like lambda3");
            }
        }




        ILike like = new Like();
        like.Lambda();

        like = new Like2();
        like.Lambda();

        like = new Like3();
        like.Lambda();

        // 5 匿名内部类 没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void Lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.Lambda();

        // 6 lambda简化
        like = () -> {
            System.out.println("I like lambda5");
        };
        like.Lambda();


    }
}

// 1 定义一个函数式接口
interface ILike {
    void Lambda();
}

// 2 实现类
class Like implements ILike {
    @Override
    public void Lambda() {
        System.out.println("I like lambda");
    }
}
