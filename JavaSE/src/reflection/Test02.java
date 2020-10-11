package reflection;


// 实体类 Pojo or Entity
class User {
    private String name;
    private int id;
    private int age;


    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Test02 extends  Object {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的class对象
        // 不确定是什么?
        Class c1 = Class.forName("reflection.User");
        System.out.println(c1);
        Class c2 = Class.forName("reflection.User");
        Class c3 = Class.forName("reflection.User");
        Class c4 = Class.forName("reflection.User");

        // 看是不是相等直接看hashCode
        // 一个类在内存中只有一个class对象
        // 一个类被加载之后，类的整个结构都会被封装在class对象中
        // class 本身也是一个类
        // class对象只能由系统建立对象
        // 一个加载的类在jvm中只会有一个class实例
        // 一个class对象对应的是一个加载到jvm中的一个class文件
        // 每个类的实例都会记得自己是由哪个class实例生成的
        // 通过class可以完整得到一个类中的所有被加载的结构
        // class类是reflection的根源，针对 动态加载、运行的类，唯有先获得相应的class对象

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());


    }
}
