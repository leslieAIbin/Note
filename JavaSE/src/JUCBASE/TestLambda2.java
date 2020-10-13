package JUCBASE;



public class TestLambda2 {
    // 静态内部类
    static class Love2 implements  ILove{
        @Override
        public void love(int a) {
            System.out.println("I love you 2");
        }
    }

    public static void main(String[] args) {
        // 内部类
        class Love3 implements ILove {
            @Override
            public void love(int a) {
                System.out.println("I love you 3");
            }
        }

        ILove love = new Love();
        love.love(12);

        love = new Love2();
        love.love(12);

        love = new Love3();
        love.love(12);

        // 匿名内部类
        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I love you 4");
            }
        };
        love.love(12);

        // lambda
        love = (int a ) -> {
            System.out.println("i love you 5"+a);
        };
        love.love(520);

        // 简化1 参数类型
        love = (a) -> {
            System.out.println("i love you"+a);
        };
        love.love(520);

        // 简化2 括号
        love = a -> {
            System.out.println("i love you --> "+ a);
        };
        love.love(520);

        // 简化3 去掉花括号
        love = a -> System.out.println("i love you-->"+a);
        // 多个参数也可以去掉参数类型 要去掉就都去掉，必须加上括号
        // 前提是函数式接口
        // lambda表达式只能由一行代码的情况下才能简化为一行，如果有多行，难么就用代码块包裹
        love.love(520);

        // runnable是一个接口 函数式接口

    }
}
interface ILove {
    void love(int a);
}

class Love implements  ILove {
    @Override
    public void love(int a) {
        System.out.println("i love you 1");
    }
}
