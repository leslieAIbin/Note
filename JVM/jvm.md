---

typora-root-url: /images
---



# Java虚拟机(JVM)笔记

参考

https://www.jianshu.com/p/9e6841a895b4



# JVM架构图

淘宝大神的那本书  深入理解jvm

大数据 还是 java都要

* 请你谈谈堆jvm的理解？java8的虚拟机有什么更新？（java8之前和java8之后虚拟机的区别）
* 什么是OOM？什么是StackOverflowError?有哪些方法分析？ 是错误还是异常
* jvm的常用参数调优你知道是哪些吗？
* 谈谈jvm中，对类加载器的理解

## jvm体系结构概述

jvm位置

![](/1.png)

**jvm是运行在操作系统之上的，与硬件没有直接的交互**

可不可以直接调用底层的硬件？native jai java本地接口 去调用底层的硬件接口

jvm体系结构概览

![](/2.png)



亮点的地方有两个特点：

* 所有线程共享（灰色是线程私有）
* 亮色地方存在垃圾回收

# 类加载器

方法区不是放方法的地方，放类的描述信息，放模板的地方。

![](/3.png)

类装载器，类似快递员，不是只有一种，

class.forName("") 根据这个类的模板生成一个实例

Car Class被装载进了方法区

car1 car2 car3一样是因为来自于同一个模板

模板是一个，实例有n个

java图标是一杯咖啡，cafe babe 就是文件开头特定标识

装载器三个，四个



![](/4.png)



jre ( java run environment ) rt.jar 里面有lang object.class  被启动类加载器 加载了

随着java世界的变化，后面添加的扩展包，用扩展类加载器， javax..

1. 启动类加载器;
2. 扩展类加载器:
3. 用户自定义加载器:
4. 系统加载器:





sun.misc.Launcher$  就是rt.jar/sum/misc 路径下的 Launcher.class

JVM相关调用的入口程序

classLoader 

双亲委派 机制 

我爸是李刚，有事找我爹

先去最上面的找，找不到，就去下一层

沙箱安全机制 不加载源代码，防止污染代码

https://blog.csdn.net/qq_30336433/article/details/83268945



![](/5.png)



**executing engine** 执行引擎负责解释命令，提交操作系统执行



首先加载的是Bootstrap加载器，由于JVM中有java.lang.String这个类，所以会首先加载这个类，而不是自己写的类，而这个类中并无main方法，所以会报“在类 java.lang.String 中找不到 main 方法”。

这个问题就涉及到，如果有两个相同的类，那么java到底会用哪一个？如果使用用户自己定义的java.lang.String，那么别使用这个类的程序会去全部出错，所以，为了保证用户写的源代码不污染java出厂自带的源代码，而提供了一种“双亲委派”机制，保证“沙箱安全”。即先找到先使用。



# 本地接口

![](/6.png)

多线程的6个状态

两个thread.start() 为什么会报错？

```
if (threadStatus != 0)    throw new IllegalThreadStateException();
```

Thread类中竟然有一个只有声明没有实现的方法，并使用`native`关键字。用native表示，也此方法是系统级（底层操作系统或第三方C语言）的，而不是语言级的，java并不能对其进行操作。native方法装载在native method stack中。 特殊的栈

（微服务）不关心内部的东西，只关心他的接口 SpringClound



为什么是native



# PC寄存器

pc寄存器记录了方法之间的调用和执行情况，类似排版值日表、

from 地址1 to 地址2

他是当前线程所执行的字节码的行号指示器

![](/7.png)

**native方法不归java管，所以计数器是空的**

pc寄存器在cpu内，就相当于排版值日表，火车的连接器

几乎不存在gc垃圾回收 几十kb  

多线程.start()不一定马上启动，在CPU和操作系统调度下执行 真正启动的是start0()

native是一个关键字，声明有，无实现。



# 方法区

![](/8.png)

- 所有线程共享（灰色是线程私有）

- 亮色地方存在垃圾回收 

  方法区 绝对不是放方法的地方，他是存储的每一个类的结构信息(比如static) 模板信息

  永久代和元空间的解释：
  方法区是一种规范，类似于接口定义的规范：`List list = new ArrayList();`
  把这种比喻用到方法区则有：

  接口  f = new 实现类()

  1. java 7中：`方法区 f = new 永久代();`
  2. java 8中：`方法去 f = new 元空间();`

  Car Class 就是模板信息 就在方法区里

# 栈

最重要的是堆 和 java栈

**栈管运行，堆管存储**

e.printStackTrace()

new 出来的放在堆里面

controller->service->dao 栈

程序 = 算法 + 数据结构

程序 = 框架 + 业务逻辑



队列FIFO

栈 FILO

![](/9.png)



栈操作：pc寄存器





```java
// 输入参数 方法就是一颗子弹，输入参数输出参数就是子弹壳
public int add(int x, int y){
    // 方法内的参数
    int result = -1;
    result  = x+y;
    // 输出参数
    return result;
}

public static void main(String[] args){
    // 
    Person p1 = new Person();
}
```



java方法 进入了虚拟机中，就成了栈帧

![](/10.png)

[Java基础-方法区以及static的内存分配图](https://www.cnblogs.com/lwthad/p/10258278.html)

https://www.cnblogs.com/lwthad/p/10258278.html



**注意：**

- 栈管运行，堆管存储

- 栈是线程私有，不存在垃圾回收

- 栈帧的概念：java中的方法被扔进虚拟机的栈空间之后就成为“栈帧”，比如main方法，是程序的入口，被压栈之后就成为栈帧。

  

![](/11.PNG)





![](/12.png)



m1 {

m1()

}

m1就是子弹，压多了，就会stackOverflowError  SOF

方法深度调用，把栈给撑爆了

这个是错误还是异常？错误，如果是异常，可以throw 

serializable <----Throwable < ---- Exception 

serializable <----Throwable <---Error

![](/13.png)





# 栈 堆 方法区的交互关系



![](/14.png)

HotSpot：如果没有明确指明，JDK的名字就叫HotSpot

元数据：描述数据的数据（即模板，也就是“大Class”）
上面的关系图的一个实例为下图：

![](/15.png)





高斯林提出了一套jdk接口规范，sun实现了这些接口规范就是HotSpot

java 最好的两家公司 阿里巴巴 + 美团 大数据 



# Heap堆结构简介

堆不是线程私有的，有垃圾回收机制

放的类元数据



新生区， 养老区，永久区

![](/16.png)



养老区，老年区

![](/17.png)

**注意：**

-  **Java 7**之前和图上一模一样，**Java 8**把**永久区**换成了**元空间** 
- **堆逻辑上由”新生+养老+元空间“三个部分组成，物理上由”新生+养老“两个部分组成**
- 当执行`new Person()；`时，其实是new在新生区的伊甸园区，然后往下走，走到养老区，但是并未到元空间。



# Heap堆new对象

![](/18.png)



注意：

- GC发生在伊甸园区，当对象快占满新生代时，就会发生YGC（Young GC，轻量级GC）操作，伊甸园区基本全部清空
- 幸存者0区(S0)，别名“from区”。伊甸园区没有被YGC清空的对象将移至幸存者0区，幸存者1区别名“to 区”
- 每次进行YGC操作，幸存的对象就会从伊甸园区移到幸存者0区，如果幸存者0区满了，就会继续往下移，如果经历数次YGC操作对象还没有消亡，最终会来到养老区
- 如果到最后，养老区也满了，那么就对养老区进行FGC(Full GC，重GC)，对养老区进行清洗
- 如果进行了多次FGC之后，还是无法腾出养老区的空间，就会报**OOM（out of Memory）**异常
- **from区和to区位置和名分不是固定的，每次GC过后都会交换，GC交换后，谁空谁是to区**
- https://blog.csdn.net/z453588/article/details/83743837

S0 = from



# TransferValue

-----



基本类型传递复印件

只是对我手上的复印件进行操作

班长手上的原册没有改变

---



引用类型传的是同样的引用地址



String 和 其他类引用变量有不一样

String 也是引用类型，照理来说，如果进入一个函数更改，最后他的值也会更改

但实际上String类型变量没有改变，这是因为**字符串常量池**的缘故



此时内存中没有abc，在常量池中新建了abc,main方法中的引用变量指向abc

然后当str被传入方法中，方法汇总的引用也指向abc

但是当方法执行str="xxx"这行代码时，由于常量池中并没有“xxx”，所以将会在常量池中新建一个xxx

由方法中的引用变量指向它

Java的TransferValue中，传基本类型的值原值不变，传引用类型的参数，参数变化，原引用的值也会发生改变。但是在常量池中的引用类型变量除外



# 对象的生命周期和GC

From和to位置和名次不是固定不变的，每次gc之后会有交换

![](/19.png)





**注意：**

- 整个堆分为新生区和养老区，新生区占整个堆的1/3，养老区占2/3。新生区又分为3份：伊甸园区：幸存者0区(from区):幸存者1区(to区) = 8:1:1
- **每次从伊甸园区经过GC幸存的对象，年龄(代数)会+1**



GC之后有交换，谁空谁是to





# 永久带

![](/20.png)

临时对象，在伊甸园生，在伊甸园死

java8优化之后，很少有对象去养老区

![](/21.png)

临时对象就是说明，其在伊甸园区生，也在伊甸园区死。

**堆逻辑上由”新生+养老+元空间“三个部分组成，物理上由”新生+养老“两个部分组成，元空间也叫方法区**

**永久代(方法区)几乎没有垃圾回收，里面存放的都是加载的rt.jar等，让你随时可用**



java7 永久代， java8 元空间

逻辑上永久代加碓空间

![](/22.png)

元数据，就相当于springboot 添加的jar包



**方法区和永久代**之间的关系就像是java 接口和类的关系

https://blog.csdn.net/u010325193/article/details/86746447

这就是java7和java8的区别

##### 



# 堆参数调整

jvm 垃圾收集（java garbage collection）

![](/23.png)



面试的时候要问清楚 minor GC major GC  full GC 他问的major GC到底是哪一个？

上面的图展示的是物理上的堆，分为两块，新生区和养老区。

堆的参数主要有两个：`-Xms``Xmx`

1.  `-Xms`堆的初始化的大小
2.  `Xmx`堆的最大化

Young Gen(新生代)有一个参数`-Xmn`，这个参数可以调新生区和养老区的比例。但是，这个参数一般不调。

永久代也有两个参数：`-XX:PermSize`，`-XX:MaxPermSize`，可以分别调永久带的初始值和最大值。**Java 8 后没有这两个参数啦**，因为Java 8后元空间不在虚拟机内啦，而是在本机物理内存中

![](/24.png)

