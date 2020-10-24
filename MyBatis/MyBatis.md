---
typora-root-url: /images
---

# MyBatis

# 参考资料：

http://www.mybatis.cn/679.html

# 目标



了解->会用->入门->熟悉->拓展

# MyBatis基本工作原理

## 概括

一句话来概括，先封装sql，接着调用jdbc操作数据库，最后把数据库返回的表结果封装成Java类

## 过程

mybatis应用程序通过**SqlSessionFactoryBuilder**从mybatis-config.xml配置文件中构建出**SqlSessionFactory**，然后，**SqlSessionFactory**的实例直接开启一个**SqlSession**，再通过**SqlSession**实例获得**Mapper**对象并运行**Mapper****映射的SQL**语句，完成对数据库的CRUD和事务提交，之后关闭SqlSession。如下图所示：

![](/1.PNG)

 ## JDBC和MyBatis核心对象

**MyBatis**的核心对象**（SqlSession，Executor）**与**JDBC**的核心对象**（Connection，Statement）**相互对应

### jdbc核心对象

（1）DriverManager，用于注册数据库连接
（2）Connection，与数据库连接对象
（3）Statement/PrepareStatement，操作数据库SQL语句的对象
（4）ResultSet，结果集或一张虚拟表

### Mybatis核心对象

（1）SqlSession对象，该对象中包含了执行SQL语句的所有方法【1】。类似于JDBC里面的Connection 【2】。
（2）Executor接口，它将根据SqlSession传递的参数动态地生成需要执行的SQL语句，同时负责查询缓存的维护。类似于JDBC里面的Statement/PrepareStatement。
（3）MappedStatement对象，该对象是对映射SQL的封装，用于存储要映射的SQL语句的id、参数等信息。
（4）ResultHandler对象，用于对返回的结果进行处理，最终得到自己想要的数据格式或类型。可以自定义返回类型。



备注【1】和备注【1】的说明如下：

在JDBC中，Connection不直接执行SQL方法，而是利用Statement或者PrepareStatement来执行方法。

> 在使用JDBC建立了连接之后，可以使用Connection接口的createStatement()方法来获取Statement对象，也可以调用prepareStatement()方法获得PrepareStatement对象，通过executeUpdate()方法来执行SQL语句。

而在MyBatis中，SqlSession对象包含了执行SQL语句的所有方法。但是它是**委托Executor执**行的。

从某种意义上来看，MyBatis里面的SqlSession类似于JDBC中的Connection，他们都是委托给其他类去执行。

最后说一点，虽然SqlSession对象包含了执行SQL语句的所有方法，但是它同样包括了：

```xml
<T> T getMapper(Class<T> type);
```

**所以SqlSession也可以委托给映射器来执行数据的增删改查操作。如**下代码所示：

```java
// 获得mapper接口的代理对象
PersonMapper pm = session.getMapper(PersonMapper.class);
// 直接调用接口的方法，查询id为1的Peson数据
Person p2 = pm.selectPersonById(1);
```

这上面来看，SqlSession是不是也类似于JDBC中的Connection呢。



## MyBatis工作原理及核心流程



![](/2.png)

相似流程：



（1）读取MyBatis的配置文件。**mybatis-config.xml**为MyBatis的全局配置文件，用于配置数据库连接信息。

（2）加载映射文件。映射文件即SQL映射文件，该文件中配置了操作数据库的SQL语句，需要在MyBatis配置文件mybatis-config.xml中加载。mybatis-config.xml 文件可以加载多个映射文件，每个文件对应数据库中的一张表。

（3）构造会话工厂。通过MyBatis的环境配置信息构建会话工厂**SqlSessionFactory**。

（4）创建会话对象。由会话工厂创建SqlSession对象，该对象中包含了执行SQL语句的所有方法。

（5）Executor执行器。MyBatis底层定义了一个Executor接口来操作数据库，它将根据SqlSession传递的参数动态地生成需要执行的SQL语句，同时负责查询缓存的维护。

（6）MappedStatement对象。在Executor接口的执行方法中有一个MappedStatement类型的参数，该参数是对映射信息的封装，用于存储要映射的SQL语句的id、参数等信息。

（7）输入参数映射。输入参数类型可以是Map、List等集合类型，也可以是基本数据类型和POJO类型。输入参数映射过程类似于JDBC对preparedStatement对象设置参数的过程。

（8）输出结果映射。输出结果类型可以是Map、List等集合类型，也可以是基本数据类型和POJO类型。输出结果映射过程类似于JDBC对结果集的解析过程。





# MyBatis核心对象SqlSession介绍

## 1、SqlSession 简介

关于SqlSession的作用，官方文档是这样介绍的：

```xml
The primary Java interface for working with MyBatis.
Through this interface you can execute commands, get mappers and manage transactions.
```

翻译为：SqlSession是MyBatis的关键对象，通过这个接口可以操作命令，管理事务等。

需要注意的是：虽然SqlSession提供select/insert/update/delete方法，在旧版本中使用使用SqlSession接口的这些方法，但是新版的Mybatis中就会建议使用Mapper接口的方法。

## 1.1、SqlSession旧版本用法：

```java
Person p = session.selectOne("cn.mybatis.mydemo.mapper.PersonMapper.selectPersonById", 1);
```

## 1.2、SqlSession新版本用法（推荐用法）：

```java
// 获得mapper接口的代理对象
PersonMapper pm = session.getMapper(PersonMapper.class);
// 直接调用接口的方法，查询id为1的Peson数据
Person p = pm.selectPersonById(1);
```

## 2、MyBatis的SqlSession与JDBC的Connection对比

SqlSession对象，该对象中包含了执行SQL语句的所有方法，类似于JDBC里面的Connection。这种“类似”体现在以下几个方面：

（1）在JDBC中，Connection不直接执行SQL方法，而是生成Statement或者PrepareStatement对象，利用Statement或者PrepareStatement来执行增删改查方法。
（2）在MyBatis中，SqlSession可以直接执行增删改查方法，例如：<T> T selectOne(String statement);int insert(String statement, Object parameter);等，也可以获取映射器Mapper：<T> T getMapper(Class<T> type);然后通过映射器来执行增删改查操作。如下代码所示：

```java
// 获得mapper接口的代理对象
PersonMapper pm = session.getMapper(PersonMapper.class);
// 直接调用接口的方法，查询id为1的Peson数据
Person p = pm.selectPersonById(1);
```

## 3、SqlSession 线程安全性分析

SqlSession是应用程序与持久存储层之间执行交互操作的一个单线程对象，也是MyBatis执行持久化操作的关键对象。

SqlSession对象完全包含以数据库为背景的所有执行SQL操作的方法，它的底层封装了JDBC连接，可以用SqlSession实例来直接执行已映射的SQL语句。

SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。也不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。如果你现在正在使用一种 Web 框架，要考虑 SqlSession 放在一个和 HTTP 请求对象相似的作用域中。换句话说，每次收到的 HTTP 请求，就可以打开一个 SqlSession，返回一个响应，就关闭它。这个关闭操作是很重要的，你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭。

可以考虑使用ThreadLocal来封装SqlSession，关于ThreadLocal的用法，请参考：[ThreadLocal的使用场景：Web容器、Spring容器、日志打印](http://www.mybatis.cn/archives/646.html)

## 4、SqlSession 的常用方法如下:

（1）int insert(String statement)。插入方法，参数statement是在配置文件中定义的<insert.../>元素的id，返回执行SQL语句所影响的行数。

（2）int insert(String statement，Object parameter)。插入方法，参数statement是在配置文件中定义的<insert.../>元素的id，parameter是插入所需的参数，通常是对象或者Map，返回执行SQL语句所影响的行数。

（3）int update(String statement) 。更新方法，参数statement是在配置文件中定义的<update.../>元素的id，返回执行SQL语句所影响的行数。

（4）int update(String statement，Object parameter)。更新方法，参数statement是在配置文件中定义的<update.../>元素的id，parameter是插入所需的参数，通常是对象或者Map，返回执行SQL语句所影响的行数。

（5）int delete(String statement) 。删除方法，参数statement是在配置文件中定义的<delete.../>元素的id。返回执行SQL语句所影响的行数。（6）int delete(String statement，Object parameter)。删除方法，参数statement 是在配置文件中定义的<delete.../>元素的id，parameter是插入所需的参数，通常是对象或者Map，返回执行SQL语句所影响的行数。

（7）<T> T selectOne(String slatement)。查询方法，参数statement是在配置文件中定义的<select.../>元素的id，返回执行SQL语句查询结果的泛型对象，通常查询结果只有一条数据时才使用。

（8）<T> T selectOne(String statement，Object parameter)。查询方法，参数statement是在配置文件中定义的<select.../>元素的id，parameter是查询所需的参数，通常是对象或者Map，返回执行SQL语句查询结果的泛型对象，通常查询结具只有一条数据时才使用。

（9）<E> List<E> selectList(String statemenl)。查询方法，参数是在配置文件中定义的<select.../>素的id，返回执行SQL话句查询结果的泛型对象的集合。

（10）<E> List<E> selectList(String statement，Object parameter)。查询方法，参数statement是在配置文件中定义的<select../>元素的id，parameter是查询所需的参数，通常是对象或者Map，返回执行SQL语句查询结果的泛型对象的集合。

（11）<E> List<E> selectList(String statement，Object parameter，RowBounds rowBounds)。查询方法，参数statement是在配置文件中定义的<select.../>元素的id，parameter是查询所需的参数，通常是对象或者Map，RowBounds对象用于分页，它的两个属性: offset指查询的当前页数; limit指当前页显示多少条数据。返回执行SQL语句查询结果的泛型对象的集合。

（12）<K，V> Map<K，V> selectMap(String statement，String mapKey) 。查询方法，参数statement是在配置文件中定义的<select.../>元素的id，mapKey是返回数据的其中一个列名，执行SQL语句查询结果将会被封装成一个Map集合返回，key就是参数mapKey传入的列名，value是封装的对象。

（13）<K，V> Map<K，V> selectMap(String statement，0bject parameler，Sting mapKey)。查询方法，参数statement是在配置文件中定义的<select.../>元素的id，parameter是查询所需的参数，通常是对象或者Map，mapKey 是返回数据的其中一个列名，执行SQL语句查询结果将会被封装成一个Map集合返回，key就是参数mapKey传入的列名，value是封装的对象。

（14）<K，V> Map<K，V>selectMap(Sting statement，Object parameter，Sting mapKey，RowBounds rowBounds)。查询方法，参数statement 是在配置文件中定义的<select.../>元素的id，parameter 是否询所需的参数，通常是对象或者Map，mapKey 是返回数据的其中一个列名，RowBounds 对象用于分页。执行SQL 语句查询结果将会被封装成一个Map集合返回，key就是参数mapKey传入的列名，value是封装的对象。

（15）void select(String statement，ResultHandler handler)。查询方法，参数statement是在配置文件中定义的<select../>元素的id，ResultHandler对象用来处理查询返回的复杂结果集，通常用于多表查询。

（16）void select(String statement，Object parameter，ResultHander handler)。查询方法，参数statement是在配置文件中定义的<select../>元素的id，parameter 是查询所需的参数，通常是对象或者Map， ResultHandler对象用来处理查询返回的复杂结果集，通常用于多表查询。

（17）void select(String statement，Object parameter，RowBounds rowBounds，ResultHandr handler)。查询方法，参数statement是在配置文件中定义的<select.../>元素的id，是查询所需的参数，通常是对象或者Map，RowBounds 对象用于分页，ResultHandr对象用来处理查询返回的复杂结果集，通常用于多表查询。

（18）void commit()。提交事务。

（19）void rollback()。回滚事务。

（20）void close()。关闭SqlSession对象。

（21）Connection getConnection()。获得JDBC的数据库连接对象。

（22）<T> T getMapper(Class<T> type)。返回mapper接口的代理对象，该对象关联了SqlSession对象，开发者可以通过该对象直接调用方法操作数据库，参数type是Mapper的接口类型。Mybatis官方手册建议通过mapper对象访问MyBatis。

## 5、SqlSession.getMapper方法详解

SqlSession有一个重要的方法getMapper，顾名思义，这个方式是用来获取Mapper映射器的。更多介绍请参考：[《深入浅出MyBatis映射器》](http://www.mybatis.cn/archives/707.html)

## 6、SqlSession与Executor

SqlSession只是一个前台客服，真正发挥作用的是Executor，对SqlSession方法的访问最终都会落到Executor的相应方法上去。Executor分成两大类：一类是CachingExecutor，另一类是普通的Executor。

（1）CachingExecutor有一个重要属性delegate，它保存的是某类普通的Executor，在构造函数时候传入。执行数据库update操作时，它直接调用delegate的update方法，执行query方法时先尝试从cache中取值，取不到再调用delegate的查询方法，并将查询结果存入cache中。

（2）普通Executor分三类：SimpleExecutor、ReuseExecutor和BatchExecutor。它们都继承于BaseExecutor，BatchExecutor专门用于执行批量sql操作，ReuseExecutor会重用Statement执行sql操作，SimpleExecutor只是简单执行sql。

SimpleExecutor是一种常规执行器，每次执行都会创建一个Statement，用完后关闭。
ReuseExecutor是可重用执行器，将Statement存入map中，操作map中的Statement而不会重复创建Statement。
BatchExecutor是批处理型执行器，doUpdate预处理存储过程或批处理操作，doQuery提交并执行过程。

总之，Executor最终是通过JDBC的java.sql.Statement来执行数据库操作。

# MyBatis是什么

orm 数据库 工具

MyBatis是一个优秀的持久层框架，它对JDBC的操作数据库的过程进行封装。这个封装的路线是这样的：

**java.sql.Statement -> MyBatis的Executor -> MyBatis的SqlSession**





jdbc有经常手动开关数据库的问题



MyBatis使开发者只需要关注 SQL 本身，而不需要花费精力去处理例如注册驱动、创建Connection、创建Statement、手动设置参数、结果集检索等JDBC繁杂的过程代码。

MyBatis通过xml或注解的方式将要执行的各种Statement（Statement、PreparedStatement、CallableStatement）配置起来，并通过Java对象和Statement中的SQL进行映射生成最终执行的SQL语句，最后由MyBatis框架执行SQL并将结果映射成Java对象并返回。

# 分析原生态JDBC程序中存在的问题

## 原生态JDBC程序代码

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Test
{
    public static void main(String[] args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            //1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8","root", "root");

            //3、定义sql语句，?表示占位符
            String sql = "select * from user where username = ?";

            //4、获取预处理statement
            preparedStatement = connection.prepareStatement(sql);

            //5、设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "admin");

            //6、向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();

            //7、遍历查询结果集
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("username"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //8、释放资源
            if (resultSet != null)
            {
                try
                {
                    resultSet.close();
                }
                catch (SQLException e)
                {

                    e.printStackTrace();
                }
            }
            if (preparedStatement != null)
            {
                try
                {
                    preparedStatement.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

        }

    }

}
```

## JDBC问题总结

（1）数据库连接频繁开启和关闭，会严重影响数据库的性能。

（2）代码中存在硬编码，分别是数据库部分的硬编码和SQL执行部分的硬编码。

# SqlSessionFactory

SqlSessionFactory是MyBatis中的一个重要的对象，它是用来**创建SqlSession对象**的，而**SqlSession用来操作数据库**的。

