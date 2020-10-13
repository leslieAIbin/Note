package JUCBASE;

// 静态代理模式
// 真实对象 和 代理对象 都要实现同一个接口
// 代理对象要代理真实角色
// 代理对象可以完成真实角色完成不了的很多事情
// 真实对象可以专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();

        // Thread就相当于婚庆公司，代理类， runable接口是真实角色
        new Thread( () -> System.out.println("我爱你")).start();

        // 真实对象交给代理对象
        new WeddingCompany(you).HappyMarry();

    }
}


interface Marry {
    void HappyMarry();

}

// 真实角色
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("小明要结婚了，超级开心");
    }
}
// 代理角色，帮助你结婚
class WeddingCompany implements Marry {
    // 代理谁？ 真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();// 这就是真实角色
        after();
    }

    private void after() {
        System.out.println("收尾款");
    }

    private void before() {
        System.out.println("布置");
    }
}