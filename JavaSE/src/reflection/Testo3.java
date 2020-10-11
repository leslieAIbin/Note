package reflection;

// 测试创建Class类的创建方式有哪些
public class Testo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        // 通过对象获得
        Class c1 = person.getClass();

        // forname获得
        Class c2 = Class.forName("reflection.Student");

        // 通过类名
        Class c3 = Student.class;

        // 基本内置类的包装类都有一Type属性
        Class c4 = Integer.TYPE;

        // 获得父类类型
        Class c5 = c1.getSuperclass();


        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c4);
        System.out.println(c5);

    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Student extends  Person {
    public Student() {
        this.name = "学生";
    }
}

class Teather extends Person {
    public Teather() {
        this.name = "老师";
    }
}