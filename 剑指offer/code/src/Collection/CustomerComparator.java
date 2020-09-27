package Collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 客户化排序，实现Comparator，然后实现compare方法
 */
public class CustomerComparator implements Comparator<Customer> {
 
    @Override
    public int compare(Customer c1, Customer c2) {
        // 对姓名进行排序
        if (c1.getName().compareTo(c2.getName()) > 0) {
            return -1;
        }
        if (c1.getName().compareTo(c2.getName()) < 0) {
            return 1;
        }
 
        // 对年龄进行排序
        if (c1.getAge() - c2.getAge() > 0) {
            return -1;
        }
        if (c1.getAge() - c2.getAge() < 0) {
            return 1;
        }
        return 0;
    }
 
    public static void main(String[] args) {
        // 此时既使用了自然排序，也使用了客户化排序，在客户化排序和自然排序共存的情况下，最终结果以客户化排序优先。
        // 查看TreeMap源码的getEntry(key)方法。可以看到先使用客户化排序得到的结果。
        Set<Customer> set = new TreeSet<>(new CustomerComparator());
        Customer customer1 = new Customer("张三三", 16);
        Customer customer2 = new Customer("李四四", 19);
        Customer customer3 = new Customer("王五五", 20);
        set.add(customer1);
        set.add(customer2);
        set.add(customer3);
        Iterator<Customer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Customer next = iterator.next();
            System.out.println(next.getName() + " " + next.getAge());
        }

        System.out.println(1>>>16);
    }
}