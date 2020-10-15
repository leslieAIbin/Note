public class MyObject {

    public static void m1() {
        m1();
    }


    public void change(int a ){
        a = 10;
    }
    public static void main(String[] args) {
        // jdk是自带的
        Object object = new Object();
        // 这个模板是哪个快递员拿来的
        System.out.println(object.getClass().getClassLoader());
//        System.out.println(object.getClass().getClassLoader().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());

        System.out.println("==============================");

        // 自定义的
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());

        //
//        Thread t1 = new Thread();
////        t1.start();
//        t1.start();
//        Throwable


//        m1();
        int a = 100;
        myObject.change(a);
        System.out.println(a);

        String str = "lzn";

    }
}
