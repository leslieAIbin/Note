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

