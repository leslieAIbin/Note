package Collection;
import java.util.*;

/**
 * 自然排序，实现了Comparable自然排序的接口，实现了该接口就要实现equals和hashcode方法和compareTo方法。
 * 为了使Customer类在添加了treeSet之后可以正确排序，
 * 要求Customer类里面的equals方法和compareTo方法按照相同的规则来比较两个对象是否相等。
 */
public class Customer implements Comparable {
    private String name;
    private int age;
 
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    @Override
    public boolean equals(Object obj) {
        // 两个对象相等返回true
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        final Customer other = (Customer) obj;
 
        if (this.name.equals(other.name) && this.age == other.getAge()) {
            return true;
        } else {
            return false;
        }
    }
 
    @Override
    public int hashCode() {
        // 重新了equals方法，就要重新hashcode方法
        int result;
        result = (name == null) ? 0 : name.hashCode();
        result = 29 * result + age;
        // 如果两个对象是相等的，那么hashcode返回值必须是相等的
        return result;
    }
 
    @Override
    public int compareTo(Object o) {
        // compareTo返回值大于0，说明Customer1大于Customer2，反之Customer1小于Customer2；如果等于0，Customer1等于Customer2
        Customer other = (Customer) o;
        // 先按照name属性排序
        if (this.name.compareTo(other.getName()) > 0) {
            return 1;
        }
        if (this.name.compareTo(other.getName()) < 0) {
            return -1;
        }
 
        // 再按照age属性排序
        if (this.age > other.getAge()) {
            return 1;
        }
        if (this.age < other.getAge()) {
            return -1;
        }
        return 0;
    }
 
    public static void main(String[] args) {
        Set<Customer> set = new TreeSet<>();
        Customer customer1 = new Customer("tom", 16);
        Customer customer2 = new Customer("tom", 19);
        Customer customer3 = new Customer("tom", 20);
        set.add(customer1);
        set.add(customer2);
        set.add(customer3);
 
        // 循环遍历
        for (Customer c : set) {
            System.out.println(c.getName() + " , " + c.getAge());
        }
    }
}