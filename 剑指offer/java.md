---
typora-root-url: /images
---





# 高频知识点-Java 常用类库与技巧

## String StringBuffer StringBuilder
* StringBuffer:线程安全，节省空间
* StringBuilder:高效 但线程不安全 


## Java异常
### 异常处理机制主要回答了三个问题
* what：异常类型回答了什么被抛出
* where: 异常堆栈跟踪回答了在哪里抛出
* why：异常信息回答了为什么被抛出
### Error和Exception的区别

![](/1.png)

### 从概念角度解析java的异常处理机制

* Error: 程序无法处理的系统错误，编译器不做检查 jvm相关的问题  系统崩溃 虚拟机错误 内存空间不足 方法调用栈溢出 stack over flow / out of memory  线程死锁

* Exception:    程序可以处理的异常，捕获后可能回复

  1 、RumtimeException：运行时的异常，不可预知的，程序应当自行避免。空指针异常 数组下标越界异常 算数异常 类型转换异常     

  

  可预知的，从编译器角度来讲，是必须要处理的异常，不然代码通不过

  2、 IO异常

  3、 SQL异常

总结：前者是程序无法处理的错误，后者是程序可以处理的错误

从责任角度看：

* Error: 属于JVM需要承担的责任

* RuntimeException: 是程序应当负担的责任

* Checked Exception：可检查异常是Java编译器应该负担的责任

  

详情看代码  throwable

### 常见Error以及Exception

#### RuntimeException

* NullPointerException: 空指针引用异常
* ClassCastException: 类型强制转换异常
* IllegalArgumentException: 传递非法参数异常
* IndexOutOfBoundsException: 下标越界异常
* NumberFormatException: 数字格式错误

#### 非RuntimeException

* ClassNotFoundException 找不到指定class的异常

* IOException io操作异常

  

#### Error

* NoClassDefFoundError: 找不到class定义的异常
* StackOverflowError：深递归导致栈被耗尽而抛出的异常
* OutOfMemoryError：内存溢出异常

NoClassDefFoundError的成因：

https://www.cnblogs.com/duke2016/p/9153241.html

* 类依赖的class或者jar不存在

* 类文件存在，但是存在不同的域中

* 大小写问题，javac编译的时候是无视大小写的，很有可能编译出来的class文件就与想要的文件不一样

  

### Java异常处理机制

* 抛出异常：创建异常对象，交由运行时系统处理

* 捕获异常：寻找合适的异常处理器处理异常，否则终止运行

  

try catch finally

java7 引入了try-with-resource

### 异常处理原则

* 具体明确：抛出的异常应能通过异常类名和message准确说明异常的类型和产生和异常的原因

* 提早抛出：应尽可能早的发现并抛出异常，便于精确定位问题

* 延迟捕获：异常的捕获和处理应尽可能延迟，让掌握更多信息的作用域来处理异常

  

### 高效主流的异常处理框架

在用户看来，应用系统发生的所有异常都是应用系统内部的异常

* 设计一个通用的继承自RuntimeException的异常来统一处理异常
* 其余异常都同意转译为上述异常AppException
* 在catch之后，抛出上述异常的子类，并提供足以定位的信息
* 由前端接受AppException做统一处理

if比try catch 执行效率高

#### try-catch的性能

* try-catch块影响jvm的性能
* 异常对象实例需要保存栈快照等信息，开销较大

## Java集合框架

### 数据结构考点

* 数组和链表的区别

* 链表的操作：反转、链表环路检测、双向链表、循环链表相关操作

* 队列 栈的应用

* 二叉树的遍历方式及其递归和非递归的实现

* 红黑树的旋转

  

### 算法考点

* 内部排序，递归排序，交换排序（冒泡，快排），选择排序，插入排序

* 外部排序，应掌握如何利用有限的内存配合海量的外部存储来处理超大的数据集，写不出来也要由相关的思路

  

### 考点扩展

* 哪些排序是不稳定的（快排，堆排），稳定意味着什么
* 不同数据集，各种排序最好、最差的情况
* 如何优化算法

![](/3.png)

### List Set

![](/4.png)

### List

ArrayList grow 方法扩容

ArrayList和LinkedList没有用到锁和CAS的技术，是线程不安全的；Vector是Java早期提供线程安全的数组，方法加上synchronized同步锁（串行），不适用于高并发且对性能有较高要求的场景。

**ArrayList如何扩容？**

ArrayList第一次插入元素时分配10（默认）个对象空间。当添加第11个元素的时候，会扩容1.5倍(10*1.5=15)，当添加到16个元素的时候扩容为15*1.5=22，以此类推。  ArrayList每次扩容都是通过Arrays.copyof(elementData, newCapacity)来实现的。

### **Set**

**HashSet**的底层是HashMap，通过add将元素以键的形式保存在map中，值是final的Object。

**TreeSet**的底层是NavigableMap，通过add将元素以键的形式保存在map中，值是final的Object。NavigableMap是个接口，由TreeMap实现。核心在于排序，保证元素有序。

1）自然排序，让对象所属的类去实现comparable接口，无参构造。基于元素对象自身实现的comparable接口的自然排序。

2）比较器接口comparator，带参构造。基于更为灵活不与单元绑定的comparator接口客户化排序。

自然排序

客户化排序

**set怎么保证元素唯一性？**

set保证里面元素的唯一性靠两个方法，equals()和hashCode()方法。

往set里面添加数据的时候一般会有隐式的操作。

先是判断set集合中是否有与新添加数据的hashcode值一致的数据，

如果有，那么将再进行第二步调用equals方法再进行一次判断；

假如集合中没有与新添加数据hashcode值一致的数据，那么将不调用eqauls方法。

 

### Map

Map集合用于保存具有映射关系的数据，Map保存的数据都是key-value对的，也就是key-value组成的键值对的。Map里面的key是不可以重复的，用于标示集合里面的每项数据的，Map里面的value则是可以重复的。key是通过set组织起来的，value是通过Collection组织起来的。

![](/5.png)

### HashMap HashTable ConccurentHashMap

HashMap 存储内容是键值对映射。在Java8以前，是数组+链表的组成。数组的特点是查询快，增删慢；而链表的特点是查询慢，增删快，HashMap结合了两者的优势。HashMap是非Synchronized，所以是线程不安全的，但是效率高。

HashMap的数组长度在未赋初始值的时候，默认长度是16的，一个长度为16的数组中，每个元素存储的就是链表的头节点。通过类似于hash(key.hashCode) % len，哈希函数取模的操作获得要添加的元素所要存放的数组的位置。实际上，HashMap的哈希算法是通过位运算来进行的，相对于取模运算，效率更高。这里面有一个极端的情况，如果添加到哈希表里面的不同的值的键位通过哈希散列运算，总是得出相同的值即分配到同一个桶中，这样会是某个桶中链表的长度变得很长，由于链表查询需要从头部开始逐个遍历，因此，在最坏的情况下HashMap性能恶化，从O(1)变成了O(n)。

![](/6.png)

在Java8以后，HashMap采用了数组 + 链表 + 红黑树的组成。Java8以后使用常量TREEIFY_THRESHOLD来控制是否将链表转换为红黑树来存储数据。这意味着，即使在最坏的情况下，HashMap的性能从**O(n)提高到O（logn）。**

![](/7.png)

HashMap源码中成员变量Node<K,V>[] table可以看作是Node<K,V>这个数组和链表组成的复合结构。数组被分为一个个的bucket桶，通过hash值决定了键值对在这个数组的寻址，hash值相同的键值对则以链表的形式来存储。链表的大小超过TREEIFY_THRESHOLD 默认是8这个值的时候，就会被改造成红黑树。而当某个桶上面的元素总数因为删除变得低于阈值UNTREEIFY_THRESHOLD =6之后，红黑树又被转换为链表以保证更高的性能。

**构造函数中table数组并没有在最初就初始化好，而是仅仅给成员变量赋初始值，所以HashMap是layload的原则首次使用时才会被初始化。**

**put方法的逻辑，如下所示：**

1）如果HashMap未被初始化过，则进行初始化操作。  （resize既可以初始化 又可以扩容）

2）对Key求Hash值，然后再计算table数组的下标。

3）如果没有碰撞，table数组里面对应的位置还没有键值对，则将键值对直接放入对应的table数组位置（桶）中。

4）如果碰撞了，table数组这个位置有元素了，以链表的方式链接到后面。

5）如果链表长度超过阈值，就把链表转成红黑树。

6）如果链表长度低于6，就把红黑树转回链表。

7）如果节点已经存在就键位对应的旧值进行替换。所谓的节点存在即key值已经存在于HashMap中了，我们找到这个key值将key对应的新值替换掉它对应的旧值。

8）如果桶满了（容量16*加载因子0.75），需要扩容了，就需要resize（扩容2倍后重排）。

**get方法的逻辑**：使用键对象的hashcode，通过hash算法找到bucket的位置，找到bucket的位置后调用key的equals方法找到链表中正确的节点，最终找到要找的值并返回。

**HashMap如何有效减少碰撞？**

树化这种被动的方式可以提升性能，哈希运算也是提升性能的关键。

1）扰动函数，促使元素位置分布均匀，减少碰撞的机率。原理就是如果两个不相等的对象返回不同的hashcode，或者元素位置尽量的分布均匀些，那么碰撞的机率就会小些，意味着很多元素就可以通过数组来直接去获取了，这样可以提升hashMap的性能。哈希算法的内部实现，是让不同对象返回不同的hashcode值。

2）其次，如果使用final对象，并采用合适的equals()和hashCode()方法，将会减少碰撞的发生。不可变性使得能够缓存不同键的hashcode，这将提高获取对象的速度，而使用String、Integer这样的wrapper类作为键是非常好的选择。因为它们是final，并且重写了hashcode方法和equals方法。不可变性final是必要的，因为为了要计算hashcode，就要防止键值改变，如果键值在放入时和获取时返回不同的hashcode，就不能从hashMap中找到想要的对象了。

**HashMap从获取hash到散列的过程**

不使用hashcode()方法获取的值，是因为key.hashCode()方法返回的是int类型的散列值，如果直接使用这个散列值作为下标去访问hashMap数组，考虑到二进制的32位带符号的int值的范围呢-2147483648——2147483647，前后区间大概有40亿的映射空间，只要哈希函数映射的均匀松散，一般应用是很难出现碰撞的，但是40亿长度的数组在内存中是放不下的，况且HashMap在扩容之前数组默认大小是16，所以直接拿这个散列值使用不现实的。

h >>> 16右移16位（高位数移动到低位），再和自己做异或操作。这样做是为了混合原始哈希码的高位与低位，以此来加大低位的随机性，而且混合后的低位参杂了高位部分的特征，这样高位的信息也变相保存了下来。这样做主要从速度、功效、质量进行考虑的，可以在数组table的length在比较小的时候，也能保证考虑到高低bit都参与到哈希的运算中，同时也不会有太大的开销。

![](/8.png)

 hashMap含参的构造器，可以传入初始化的hashMap的初始化大小的，根据传入的初始化值，换算成2的n次方，转换成最接近的2的倍数的值，这样做是为了通过哈希运算定位桶的时候，能实现用与操作来代替取模进而获得更好的效果。

**hashMap的扩容resize**

1）hashMap的扩容，就是重新计算容量，向hashMap对象中不停的添加元素，而hashMap对象内部的数组无法装载更多的元素时，对象就需要扩大数组的长度了，才能装入更多的元素。java中的数组是无法进行自动扩容的，hashMap的扩容，是使用新的大的数组替换小的数组。

2）hashMap的默认负载因子是0.75f，当hashMap填满了75%的bucket的时候呢，就会创建原来hashMap大小2倍的bucket数组，来重新调整map的大小，并将原来的对象放入的新的bucket数组中。

HashMap扩容的问题，多线程环境下，调整大小会存在条件竞争，容易造成死锁。rehashing是一个比较耗时的过程，由于需要将原先的hashMap中的键值对重新移动的新的hashMap中去，是一个比较耗时的过程。



**为什么要两倍扩容？**

 

　这个很简单，首先我们考虑一个问题，为什么hashmap的容量为2的幂次方，查看源码即可发现在计算存储位置时，计算式为：

```
    (n-1)&hash(key)
```

　　容量n为2的幂次方，n-1的二进制会全为1，位运算时可以充分散列，避免不必要的哈希冲突。

　　所以扩容必须2倍就是为了维持容量始终为2的幂次方

**负载因子为什么是0.75？**

提高空间利用率和 减少查询成本的折中，泊松分布0.75的话碰撞最

https://www.cnblogs.com/aspirant/p/11470928.html

**为什么节点数为8时转换为红黑树？**

https://blog.csdn.net/baidu_37147070/article/details/98785367

**Hashtable**

线程安全的，因为在方法都加了synchronized关键字，和Collections.synchronizedMap(map)效果一样，唯一的区别就是锁定的对象不同而已，都是串行执行的，效率比较低。为了提升多线程下的执行性能，引入了ConcurrentHashMap。

**ConcurrentHashMap**

无论是Hashtable还是使用synchronizedMap包装了的hashMap，当多线程并发的情况下，都要竞争同一把锁，导致效率极其低下，而在jdk1.5以后，为了改进HashTable的缺点，ConcurrentHashMap应运而生。

如何优化Hashtable？

1）通过锁细粒度化，将整锁拆解成多个锁进行优化。对象锁之间是不相互制约的，因此，我们可以将原本一个锁的行为拆分成多个锁，早期的ConcurrentHashMap也是这样做的。ConcurrentHashMap早期使用的是分段锁技术（由数组和链表组成），将锁一段一段的进行存储，然后给每一段数据配一把锁即Segment，当一个线程占用一把锁即Segment时，然后访问其中一段数据的时候，位于其他Segment的数据也能被其他线程同时访问，默认是分配16个Segment，理论上比Hashtable效率提升了16倍。相比于早期的HashMap，就是将hashMap的table数组逻辑上拆分成多个子数组，每个子数组配置一把锁，线程在获取到某把分段锁的时候，比如下图获取到编号为7的Segment之后，才能操作这个子数组，而其他线程想要操作该子数组，只能被阻塞。但是如果其他线程操作的是其他未被占用的Segment所管辖的子数组，是不会被阻塞的。

![](/9.png)

可以将分段锁拆分的更细，或者不使用分段锁，而是table里面的每个bucket都用一把不同的锁进行管理，ConcurrentHashMap的效率就得到了更好的提高。

2）jdk1.8以后，ConcurrentHashMap使用的**CAS + synchronized**保证并发安全。同时，也做了进一步的优化，使用了数组 + 链表 + 红黑树的组合。synchronized只锁定当前链表或者红黑树的首节点，这样，只要哈希不冲突，就不会产生并发，效率得到了进一步的提高。ConcurrentHashMap的结构参考了jdk1.8以后的hashMap来设计的。

ConcurrentHashMap是出自于JUC包的，ConcurrentHashMap有很多地方和hashMap类似的，包含属性参数之类的。

put方法的逻辑

1）判断Node[]数组是否初始化，没有则进行初始化操作。

2）通过hash定位数组的索引坐标，是否有Node节点，如果没有则使用CAS进行添加（链表的头节点），添加失败则进入下次循环，继续尝试添加。

3）检查内部是否正在扩容，如果正在扩容，就调用helpTransfer方法，就帮助它一块扩容。

4）如果f!=null，头节点不为空，则使用synchronized锁住头节点的元素对象（链表、红黑二叉树的头元素）。如果是Node链表结构，则执行链表的添加操作。如果是TreeNode（树形结构）则执行树添加操作。

5）判断链表长度已经到达临界值默认8，当节点数超过这个值就需要把链表转换成树结构了。

ConcurrentHashMap总结

jdk1.8的实现，也是锁分离的思想，比Segment锁拆的更细，只要哈希不冲突，就不会出现并发或者锁的情况。

1）首先使用无锁操作CAS插入头节点，失败则循环重试。如果插入失败，则说明有别的线程插入头节点了，需要再次循环进行操作。

2）若头节点已经存在，则通过synchronized尝试获取头节点的同步锁，再进行操作。性能比Segment分段锁又提高了很多。

### Hashtable、HashMap、ConcurrentHashMap的区别

1）HashMap线程不安全的，底层是通过数组 + 链表 + 红黑树来实现。

2）Hashtable是线程安全的，底层是数组 + 链表来实现。实现线程安全的方式，是在修改数组的时候锁住整个hashtable，效率很低下的。

3）ConcurrentHashMap是线程安全的，CAS + 同步锁，底层是数组 + 链表 + 红黑树来实现。是对hashtable进行了优化，通过将锁细粒度化到table的每个元素来提升并发性能。

4）HashMap的key、value均可以为null，而其它的两个类Hashtable、ConcurrentHashMap不支持的。

[Java：CAS(乐观锁)](https://www.jianshu.com/p/ae25eb3cfb5d)、[红黑树](https://www.jianshu.com/p/e136ec79235c)