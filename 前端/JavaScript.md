---
typora-root-url: images
---

# JavaScript简介

## **一，JavaScript是什么?**

javaScript是弱类型语言,是一种基于对象和事件驱动并具有安全性能的脚本语言

弱类型语言特征:数据类型可以忽略,一个变量可以赋予不同的数据类型

标签放入css中使用就是选择器,放入到js中使用就是对象

事件驱动:鼠标点击、键盘输入等启动预先设置的相应动作

脚本语言：不需要通过服务器来执行的属于前台的语言。

------

## **二，JavaScript特点**

简单性：它是基于Java基本语句和控制流之上的简单而紧凑的设计，是学习Java的好过渡，而且，它的变量类型是采用弱类型，未采用严格的数据类型。

安全性：JS不允许访问本地硬盘，不能将数据存入到服务器上，不允许对网络文档进行修改和删除，只能通过浏览器实现信息浏览或动态交互，从而有效的防止数据的丢失。

动态性：JS可以直接对用户或客户输入做出响应，无须经过Web程序。它对用户的响应采用以事件驱动的方式进行，即由某种操作动作引起相应的事件响应，如：点击鼠标、移动窗口、选择菜单等。

跨平台性：JS依赖于浏览器本身，与操作环境无关。只要能运行浏览器的计算机，并安装了支持JS的浏览器就可以正确执行，从而实现了“编写一次，走遍天下”的梦想。

------

## **三，JavaScript作用**

1.实现网页特效

2.读写页面元素

3.表单验证

4.响应事件

5.控制浏览器中的cookies

6.制作游戏,动画

## 四，JavaScript组成

1.ECMAScript

由ECMA-262定义的ECMASctipt与Web浏览器没有依赖关系.实际上,这门语言本身并不包含输入和输出定义.ECMA-262定义的只是这门语言的基础,而在此基础之上可以构建更完善的脚步语言.它主要规定了这个语言的下列组成部分:语法,类型,语句,关键字,保留字，操作符,对象



2.文档对象模型DOM

DOM(Document Object Model)是针对XML但经过扩展用于HTML的应用程序编程接口。DOM把整个页面映射为一个多层节点结构.借助DOM提供的API,开发人员可以轻松自如的删除，添加，替换或者修改任何节点.

DOM并不只是针对于javaScript的,很多别的语言也都实现了DOM。



3.浏览器对象模型BOM(可以访问和操作浏览器窗口)

BOM真正与众不同的地方(也是经常会导致问题的地方)是它作为javaScript实现的一部分但却没有相关的标准,这个问题在HTML5中得到了解决,HTML5致力于把很多BOM功能写入正式规范。

## **五，Javascript历史和版本**

ECMAScript是一种由欧洲计算机制造商协会（ECMA）通过ECMA-262标准化的脚本程序设计语言。这种语言在万维网上应用广泛，它往往被称为JavaScript或JScript，但实际上后两者是ECMA-262标准的扩展。

详解：

http://baike.baidu.com/view/810176.htm 

JavaScript/jscript / ECMAScript 关系？

javaScript是由Netscape公司开发 .它的前身是Live Script 

Microsoft发行jscript用于internet explorer 

最初的jscript和javascript差异过大，web程序员不得不痛苦的为两种浏览器编写两种脚本。于是诞生了ECMAScript,是一种国际标准化的javascript版本。现在的主流浏览器都支持这种版本。 

## **六，Javascript和java的区别联系**

Javascript和java除了名字和语法有点像，其他没有任何的关系。主要做:富客户端开发.

做个比较是为了让大家更好地理解javascript，事实上，两个语言根本没有可比性，是完全不同的。

|            | Javascript                                                   | Java       |
| ---------- | ------------------------------------------------------------ | :--------- |
| 对象       | `**基于对象**，不能说是面向对象。比如：javascript不支持直接继承，``而要通过一个原型对象来间接实现。多态就更不支持了。它们使用一些封装好的对象，``调用对象的方法，设置对象的属性，但是它们无法让程序员派生新对象类型，``他们只能使用现有对象的方法和属性，所以当你判断一个新技术是否是面向对象的时候，``通常可以使用后两个特性加以判断，“面向对象”和“基于对象”都实现了“封装”``的概念，但“面向对象”实现了“继承”和“多态”，而“基于对象”可以不实现这些。` | 面向对象   |
| 解释和编译 | 解释                                                         | 编译、解释 |
| 变量类型   | 弱变量类型。js的弱类型是变量的弱类型                         | 强变量类型 |

# 如何在网页中加入脚本语言

## 一，js的引用方式

```html
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>JavaScript初级</title>
    <script>			function test() { alert("我的第一个js程序！"); }		</script>
</head>

<body> <input type=button value=测试 onclick="test();" /> </body>

</html>
```

2，在实际应用中考虑到脚本语言书写的代码可能会比较长，可以将脚本语言单独写在扩展明为.js的脚本文件中，然后在<script>标记中设置src属性的值为脚本文件的位置和名称 

HTML中

```html
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>JavaScript初级</title>
    <script src="2.js" type="text/javascript"></script>
</head>

<body> <input type=button value=测试 onclick="test();" /> </body>

</html>
```

2.js中

```html
function test() { alert("我的第一个js程序！"); }//不能再js文件中写：
<script>标记，这个标记是html标记!	
```

## **二，<script\>标记的使用要点**

<script>标记可以置于页面任意位置！ 

<script>定义函数一般置于<head>中 

<script>可以直接写js语句。 

注意事项:

1.<script type="text/javascript" src="js/test01.js" /> 此语法不符合html规范.

2.如果script 中存在加载外部js文件,而且又在标签中含有ja代码块,则只会下载并执行外部脚本文件,嵌入的代码会被忽略.

3.浏览器按照<script>元素在页面中出现的先后顺序对它们依次进行解析

4.如果将js放入<head>元素中引用,当js代码很多的时候,会导致浏览器在呈现页面时，出现明显的延迟,而延迟期间浏览器窗口是一片空白,为了避免这个问题,一般将全部的js放在<body>元素中页面的内容后面引用

```html
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>JavaScript初级</title>
    <script>            
        function test() { alert("我的第一个js程序！"); }        
    </script>
</head>

<body> 
    <input type=button value=测试 onclick="test();" />
    <script>            
        alert("script标记可以置于页面任意部分！甚至可以直接执行js语句！");       
    </script>
</body>

</html>
```

# 变量和数据类型

## **一，基本数据类型**

1. undefined未定义 (声明了变量但从未赋值 )
2. null空  (赋值为null) 
3. boolean布尔型 (true,false) 
4. 字符串string (单引号、双引号均可) 
5. 数值number 包括整数和小数，NaN（Not a Number），Infinity, -Infinity 
6. 对象object 

## **二，变量的声明**

JavaScript 是一种弱类型的脚本语言。 

变量的声明(变量使用之前必须加var声明，编程规范)

可以通过var关键字来声明一个变量 

典型声明方式：

var a=1;       var a, b=2, c;      var date = new Date(); 

var array = new Array();   //声明数组 

不能使用未经声明的变量。 

全局变量 

- 在方法外部声明的变量 
- 方法内部，没有加var关键字声明的变量 

局部变量 

- 方法内部，使用var声明的变量 

补充：

Javascript:void(0); 用于超链接 

Javascript伪协议 

```javascript
<script>	
    var a = 1;   //全局变量，页面被加载时就执行！	
	function test1(){		
        var b = 3;   //局部变量!		
        c = 4;    //执行完方法test1后就被解释成全局变量！	
    }	
    function test2(){		
        alert(a);		
        alert(c);   //先执行test1，再执行test2才能看到c的值！		
        alert(b);	}
</script>
```

```
<input type=button value=测试javascript伪协议  onclick="javascript:var a=3;alert(a);alert('a+3='+(a+3));" />
```

变量的命名规则

1.变量命名必须以英文字母或是下标符号”_”或者”$”为开头。

2.变量名长度不能超过15个字符。

3.变量名中不允许使用空格。

4.不能使用脚本语言中保留的关键字及保留符号作为变量名。例如：var、*等。

5.变量名区分大小写。(javascript是区分大小写的语言)

## **三，相关数据类型说明**

1.Undefined类型

Undefined类型只有一个值,即特殊的undefined.

在使用var声明变量但未对其加以初始化时,这个变量的值就是undefined。

undefined 表示一个未声明的变量，或已声明但没有赋值的变量，或一个并不存在的对象属性.

当试图访问一个不存在的变量时,就会得到一个特殊值:undefined。

使用一个未初始化的变量也会如此。因为js会自动将变量在初始化之前的值设定为undefined.



var userName； //这个变量声明之后默认取得了undefined值

alert(typeof userName); // undefined;

alert(typeof passWord);//undefined;



2.Null类型

只有一个值null,使用typeof检测时会返回object

如果定义的变量准备在将来用于保存对象,那么最好将该变量初始化为null而不是其他值。

实际上,undefined值是派生自null值 即 null==undefined;

尽管null和undefined有这样的关系,但它们的用途完全不同.无论在什么情况下,都没有必要把一个变量的值显式地设置为undefined,在可以设置成null,只要意在保存对象的变量还没有真正保存对象，就应该明确地让该变量保存null值。



3.Boolean类型

该类型只有两个值true和false

Boolean()函数 将任何数据类型的值都转换成Boolean值

String类型  任何非空字符串返回true，" "空字符串返回false

Number类型  任何非零数字值返回true,0和NaN返回false

Undefined 返回false



案例:

var str ="字符串自动在if中转Boolean";//当字符串不为空Boolean(str)返回true

  if(str){

​       alert("可以进入语句块");

 }  

字符串自动转成对应的Boolean值,由于存在这种自动执行的Boolean转换,因此要清楚的知道在流程控制语句中使用的是什么变量很重要



4.Number类型

用来表示整数和浮点数值(指的是双精度数值).

数据格式可以是:十进制,八进制,十六进制 整数



数值的范围

Number.MAX_VALUE  获取数值类型的最大值

Number.MIN_VALUE  获取数值类型的最小值

如果超出数值范围则显示Infinity 无穷大或者-Infinity 负无穷大

Infinity 是一个特殊值,它表示的是超出了js处理范围的数值,但Infinity依然是一个数字。

console.log(Infinity-Infinity); //NaN    这个是控制器的日志输出

console.log(-Infinity+Infinity);//NaN  

正负Infinity相加不是0而是一个NaN，Infinity与其他的任何操作数执行任何算术运算的结果都是Infinity或者-Infinity



isNaN()函数,可以接受一个参数,该参数可以是任何类型，而函数会帮我们确定这个参数是否“不是数值”。

isNaN()在接收到一个值之后，会尝试将这个值转换为数值.



浮点数值:该数值中必须包含一个小数点，并且小数点后面必须至少有一位数字。

由于保存浮点数值需要的内存空间是保存整数值的两倍,js会不留余地的将浮点数值转换为整数值。当小数点后面没有跟任何数字，那么这个数值就可以整数值.

案例:

var a = 10.;

var b = 10.00;

document.write(a+"<br/>");//10

document.write(b+"<br/>");  //10



var a = 0.1;

var b = 0.2;

document.write(a+b);//0.30000000000000004  

浮点数值的最高精度是17位小数，但在进行算术计算时其精确度远远不如整数.测试特定的浮点数值时会存在误差,即永远不要测试某个特定的浮点数值



数值转换

1.Number() 用于任何数据类型

如果是Boolean值,则转换成1和0

如果是数值,只是简单的传入和返回

如果是null值，返回0

如果是undefined，返回NaN

如果是字符串

(1)如果字符串中只包含数字和正负号,则将其转换为十进制数值(忽略前导的零)

(2)如果字符串中包含有效的浮点格式,则将其转换为对应的浮点数值(忽略前导的零)

(3)如果字符串是空,则将其转换为0

(4)如果字符串包含有效的16进制格式,则将其转换为相同大小的十进制数值

(5)如果字符串包含除以上格式的字符,则将其转换为NaN

(6)如果是对象则调用方法转换



5.String类型

字符串可以由双引号或者单引号表示

1.字符字面量

String数据类型包含一些特殊的字符字面量,也叫转义序列

可以在 JavaScript 中使用反斜杠来向文本字符串添加特殊字符

\' 单引号，\"双引号，\\反斜杠

\t制表符，\& 和号，\b退格符，\f换页符

\r 回车 作用:使光标到行首

\n换行 作用:使光标下移一行

\r\n 回车换行

2.字符串的特点

字符串一旦创建,它们的值就不能改变,要改变某个变量保存的字符串,首先要销毁原来的字符串，然后再将一个包含新值得字符串填充该变量.

3.字符串转换

(1)toString()方法,返回相应的字符串表现，数值,布尔值,对象和字符串都有toString()方法,但null和undefined没有

(2)String() 能够将任何类型的值转换为字符串,如果值有toString()方法,则调用该方法并返回相应的结果，如果值是null,则返回"null";如果值是undefined,则返回"undefined"

(3)当将一个数字字符串用于算术运算中的操作数时,该字符串会在运算中被当做数字类型来使用。

var str01 = "3";

var str02 = str01*3;

console.log(typeof str02);//number  

(4)其他类型转换为字符串,只需要将其与空字符串拼接即可

```html
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>JavaScript初级</title>
    <script>
        function testNullUndefined() {
            var a;
            var b = null;
            document.write("a的数据类型：" + a + "<br>"); document.write("b的数据类型：" + b + "<br>");
        }
        function testBoolean() {
            var a = true; var b = false;
            if (a) { alert("a的数据类型是boolean！"); }
        }
        function testString() {
            var a = "aaa";
            var b = 'bbbb';
            var c = new String("cccc");
            document.write(a + "<br/>" + b + "<br>" + c
            );
            //外面用单引号，里面双引号。或者外面双引号，里面单引号。                
            //假如子字符串包含引号的常见的处理技巧！				
            var e = '"eeeee"';
            var f = "U're right!";
            //var f = 'U're right!';  //这么写会出错！				
            alert(e + "\n" + f);
        }
        function testNumber() {
            var a = 123;
            var b = 12.345;
            var c = NaN;
            var d = 1 / 0;
            document.write(a + "<br>" + b + "<br>" + c + "<br>" + d);
            if (c == c) {
                alert("c==c");
            } else {
                alert("c是NaN值，他是js中唯一一个跟自己不相等的值！我们可以利用这个特点判断某个值是不是NaN！");
            } if (isNaN(parseInt("sss"))) {
                alert("刚刚运算的结果是：NaN！");
            }
        } function testObject() { var d = new Date(); alert(d);   //其他对象，以及js基于对象编程，以后会讲！今天先了解下！			}		</script>
</head>

<body> <input type=button value=测试null和undefinedonclick="testNullUndefined();" /> <input type=button
        value=测试booleanonclick="testBoolean();" /> <input type=button value=测试Stringonclick="testString();" /> <input
        type=button value=测试Numberonclick="testNumber();" /> <input type=button value=测试Objectonclick="testObject();" />
</body>

</html>
```

# 表达式与运算符

## **一，运算符的分类**

1，算术运算符(+ - *  /   %   ++    --)

2，赋值运算符(=  +=  *=   /=   %=)

3，条件运算符(===   ==   >   >=   <   <=  !=  )

4，字符串运算符(+   +=)

5，逻辑运算符(&&  ||  !)

6，三元运算符(   （条件表达式1）？表达式2：表达式3     )

7，运算符优先级

## **二，运算符的分类说明**

1，算术运算符(+ - *  /   %   ++    --)

2，赋值运算符(=  +=  *=   /=   %=)

基本的赋值运算符为“=”，用于将右侧的操作数或表达式的值赋给“=”左侧的变量。 

在程序中还经常使用到扩展赋值运算符，如：+=，-=，*=，/=，%=等。

3，条件运算符(===   ==   >   >=   <   <=  !=  )

===  等同符：不会发生类型的自动转化！ 

==   等值符：会发生类型自动转化、自动匹配！

4，字符串运算符(+   +=)

字符串运算符主要是字符串运算符“+”和它的变形形式：“+=” 

数字类型和字符串进行“＋”操作时，实际是进行了字符串的连接操作。

> var a=1; var b="3";  alert(a+b);//显示的是13,而不是4.
>
> var b=true; var c="ddd";  alert(b+c);  //显示的是trueddd；

“我爱”+“北京”+“天安门”产生的结果是一个新的字符串“我爱北京天安门”

5，逻辑运算符(&&  ||  !)

&&两边都为true时则返回true

||两边有一边为true就返回true

！取反

6，三元运算符(   （条件表达式1）？表达式2：表达式3     )

执行此表达式时，先判断条件即:逻辑表达式1的值，若为true，则整个三目运算的结果为表达式2的值，否则整个运算结果为表达式3的值 

## **三，操作符优先级**

等级1:()

等级2:！ ++  --

等级3:* /  %

等级4:+  -

等级5:>  >=  <    <=  !=    ==

等级6:&& 

等级7:||

等级8:=  += -= *= /=  %=

# 分支语句

## **一，if语句**

if…else语句完成了程序流程中的分支功能，如果其中的条件成立，则程序执行相应的语句。

if…else语句的语法如下：

> if(条件){
>
> ​	执行语句
>
> }else{
>
> ​	执行语句
>
> }

------

## **二，switch语句**

分支语句switch可以根据一个变量的不同取值而采取不同的处理方法，在程序设计中提供不同的分支，这样的语句叫做分支语句。

Switch语句的语法如下：

​	switch (expression){

​	case const1:

​		语句块1

​	case  const1:

​		语句块2

​	…… 

​	default:

​		语句块N

}

在同时可以使用switch和if时推荐使用switch以获得更好的效率

# 循环语句

for语句的基本语法如下：

for (初始化部分；条件部分；更新部分){

​    语句块… 

}

```javascript
for (var i=0;i<=10;i++) {				
	alert(i);			
}
```

while循环

while(条件) {

​	语句块；

 }

```javascript
var i=0; while(i<=10){ alert(i); i++; }
```

do-While

do{

​	语句块；

 }while(条件)

```javascript
var i=0; do{ alert(i); i++; }while(i<=20);
```

break语句是结束当前的循环，并把程序的控制权交给循环的下一条语句。

这里是结束循环，循环到此为止 

continue语句是结束当前的某一次循环，但是并没有跳出整个的循环。

这里是结束一次循环，整个循环还在进行

# 数组

“数组”即一组数据的集合。 

js数组更加类似java的容器。长度可变，元素类型也可以不同！ 

Js数组长度随时可变！随时可以修改！我们可以通过修改数组的长度清空数组。

通过array.length获得数组长度。

​			

```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>JavaScript初级</title>
    <script>			
        function test() {				
            //两种定义数组的方式				
            var a = new Array();				
            var a2 = [];  //更常用！								
            //初始化方式				
            a[0] = 123;				
            a[1] = new Date();  								
            var a3  =[123,"45",new Date(),true];								
            alert(a);				alert(a3.length);								
            a3.length = 2;  //改变数组长度，清掉后面的元素！				
            alert(a3);				
            a3.length = 0;  //直接清空数组				
            alert(a3);			
        }
                                    
            function test2(){				
                var a = [1,2,3,4,5];				
                a.push("ppp");   //数组末尾添加一个项				
                alert(a);				
                a.pop();    //删除数组最后一个项 				
                alert(a);				
                a.unshift("aa");//在数组第一个元素位置添加元素				
                alert(a);				
                a.shift();  //删除数组第一个元素							
            }		
        </script>
</head>

<body> <input type=button value=测试 onclick="test();" /> <input type=button value=测试 onclick="test2();" /> </body>

</html>
```

# 函数及深化

## **一，自定义函数**

一个典型的JavaScript函数定义如下：

function 函数名称（参数表）

{

​		函数执行部分：

}

注意：参数列表直接写形参名即可，不用写var! 

return语句：

return返回函数的返回值并结束函数运行 

return语句的语法如下：

return 表达式

当使用return语句的时候，要得到函数的返回值，只要利用函数名对一个变量赋值就可以了。

函数也是对象！ 

函数的另一个定义方式！ 

```html
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>尚学堂JavaScript初级</title>
    <script>			
        function test() { 
            var a = test2;  //把test2指向的函数对象引用赋值给了a				
            a();   //执行的仍然是test2函数				
        }			
        var test2 = function(){    
            //更能体现函数也是对象的含义！
            //根据此种定义方式，我们可以发现test2是一个全局变量，
            //他只想了匿名的函数对象！				
            alert("test2");			
        }
        function test3(){				
            test4(234,test2);			
        }						
        function test4(a,b){				
            alert(a);				
            alert(b);				
            b();   //执行b指向的函数对象！			
        }					
    </script>
</head>

<body> <input type=button value=测试 onclick="test();" /> <input type=button value=测试2 onclick="test3();" /> </body>

</html>
```

## 二，内置函数



| 函数                                                         | 描述                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| [decodeURI()](http://www.w3school.com.cn/jsref/jsref_decodeURI.asp) | 解码某个编码的 URI。                               |
| [encodeURI()](http://www.w3school.com.cn/jsref/jsref_encodeuri.asp) | 把字符串编码为 URI。                               |
| [escape()](http://www.w3school.com.cn/jsref/jsref_escape.asp) | 对字符串进行编码。                                 |
| [eval()](http://www.w3school.com.cn/jsref/jsref_eval.asp)    | 计算 JavaScript 字符串，并把它作为脚本代码来执行。 |
| [isFinite()](http://www.w3school.com.cn/jsref/jsref_isFinite.asp) | 检查某个值是否为有穷大的数。                       |
| [isNaN()](http://www.w3school.com.cn/jsref/jsref_isNaN.asp)  | 检查某个值是否不是数字。                           |
| [Number()](http://www.w3school.com.cn/jsref/jsref_number.asp) | 把对象的值转换为数字。                             |
| [parseFloat()](http://www.w3school.com.cn/jsref/jsref_parseFloat.asp) | 解析一个字符串并返回一个浮点数。                   |
| [parseInt()](http://www.w3school.com.cn/jsref/jsref_parseInt.asp) | 解析一个字符串并返回一个整数。                     |
| [String()](http://www.w3school.com.cn/jsref/jsref_string.asp) | 把对象的值转换为字符串。                           |
| [unescape()](http://www.w3school.com.cn/jsref/jsref_unescape.asp) | 对由 escape() 编码的字符串进行解码。               |

```html
<html>

<head>
    <title>Untitled Document</title>
    <script>			
        function testEval() 
        { 
            var a = "alert('你们好')"; 
            var b = "var c=0;"; 
            eval(b);  //var c=0;								
            alert(c);//				
            var a1 = 'alert("你们好！")';//				
            var b="var c=11;";////				
            alert(a);//				
            alert("你们好");//				
            eval("var c=11;");   //				
            var c=11;//				
            var c=11;//				
            alert(c);			
        }						
        function testParse() {				
            var d="3.555";				
            var e1="abd";								
            var d1= parseFloat(d);				
            var d2=parseInt(d);				
            var e2=parseInt(e1);				//				
            alert(1+d);//				
            alert(1+d1);				
            alert(d2);//				
            alert(1+d2);//				
            alert(e2);								
            if(isNaN(e2)) {					
                alert("I'm a NaN");				
            }								
            if(e2!=e2) {					
                alert("我不是我");				
            }				
            if(isFinite(e2)) {					
                alert("我是一个正常的number");				
            }			}						
            function testEscape() {				
                var  str="中国";				
                var str1 = escape(str);				
                var str2 = unescape(str1);				
                alert(str1);				
                alert(str2);			}						
                function testDecode(){				
                    var myurl='http://www.baidu.com/中国';				
                    var u1=encodeURI(myurl);				
                    var u2=decodeURI(u1);				
                    alert(u1);				
                    alert(u2);			
                }					
            </script>
</head>

<body> <a href="javascript:void(0);" onclick="testEval();">测试eval方法</a> <a href="javascript:void(0);"
        onclick="testParse();">测试parse方法</a> <a href="javascript:void(0);" onclick="testEscape();">测试escape方法</a> <a
        href="javascript:void(0);" onclick="testDecode();">测试Decode方法</a> </body>

</html>
```

在 JavaScript 核心语言中，全局对象的预定义属性都是不可枚举的，所有可以用 for/in 循环列出所有隐式或显式声明的全局变量，如下所示：

```html
<html>

<body>
    <script
        type="text/javascript">
        var variables = ""; 
        for (var name in this) { 
            variables += name + "<br />"; 
        } document.write(variables);</script>
</body>

</html
```

# 对话框

## **一，对话框的分类**

1. 警告框     alert, 常用。
2. 询问框     返回提示框中的值。
3. 确认框     返回true/false.

### 警告框

```javascript
alert('警告的内容');
```

### 询问狂

```js
var name = prompt("您没有登录，请输入用户名：");
alert("your name: " + name);
```

![](/24.png)

### 确认框

```js
var isLogin = confirm("您确认登录吗？");                
if (isLogin) {                    
    alert("您同意登录");                }                
else {                    
    alert("您不同意登录");                   
    // alert("您不同意登录2");                
}
```



![](/25.png)

# DOM树

![](/26.png)

通过可编程的对象模型，JavaScript 获得了足够的能力来创建动态的 HTML。简单的说，就是文档内部的一些”对话“JavaScript 能够改变页面中的所有 HTML 元素
JavaScript 能够改变页面中的所有 HTML 属性
JavaScript 能够改变页面中的所有 CSS 样式
JavaScript 能够对页面中的所有事件做出反应



## **一，DOM Event 对象**

Event 对象代表事件的状态，比如事件在其中发生的元素、键盘按键的状态、鼠标的位置、鼠标按钮的状态。

事件通常与函数结合使用，函数不会在事件发生前被执行！

1，事件句柄　(Event Handlers)  也就是事件触发源

​       HTML 4.0 的新特性之一是能够使 HTML 事件触发浏览器中的行为，比如当用户点击某个 HTML 元素时启动一段 JavaScript。下面是一个属性列表，可将之插入 HTML 标签以定义事件的行为。



| 属性                                                         | 此事件发生在何时...                  |
| ------------------------------------------------------------ | ------------------------------------ |
| [onblur](http://www.w3school.com.cn/jsref/event_onblur.asp)  | 元素失去焦点。                       |
| [onchange](http://www.w3school.com.cn/jsref/event_onchange.asp) | 域的内容被改变。                     |
| [onclick](http://www.w3school.com.cn/jsref/event_onclick.asp) | 当用户点击某个对象时调用的事件句柄。 |
| [ondblclick](http://www.w3school.com.cn/jsref/event_ondblclick.asp) | 当用户双击某个对象时调用的事件句柄。 |
| [onfocus](http://www.w3school.com.cn/jsref/event_onfocus.asp) | 元素获得焦点。                       |
| [onkeydown](http://www.w3school.com.cn/jsref/event_onkeydown.asp) | 某个键盘按键被按下。                 |
| [onkeypress](http://www.w3school.com.cn/jsref/event_onkeypress.asp) | 某个键盘按键被按下并松开。           |
| [onkeyup](http://www.w3school.com.cn/jsref/event_onkeyup.asp) | 某个键盘按键被松开。                 |
| [onload](http://www.w3school.com.cn/jsref/event_onload.asp)  | 一张页面或一幅图像完成加载。         |
| [onmousedown](http://www.w3school.com.cn/jsref/event_onmousedown.asp) | 鼠标按钮被按下。                     |
| [onmousemove](http://www.w3school.com.cn/jsref/event_onmousemove.asp) | 鼠标被移动。                         |
| [onmouseout](http://www.w3school.com.cn/jsref/event_onmouseout.asp) | 鼠标从某元素移开。                   |
| [onmouseover](http://www.w3school.com.cn/jsref/event_onmouseover.asp) | 鼠标移到某元素之上。                 |
| [onmouseup](http://www.w3school.com.cn/jsref/event_onmouseup.asp) | 鼠标按键被松开。                     |
| [onreset](http://www.w3school.com.cn/jsref/event_onreset.asp) | 重置按钮被点击。                     |
| [onselect](http://www.w3school.com.cn/jsref/event_onselect.asp) | 文本被选中。                         |
| [onsubmit](http://www.w3school.com.cn/jsref/event_onsubmit.asp) | 确认按钮被点击。                     |
| [onunload](http://www.w3school.com.cn/jsref/event_onunload.asp) | 用户退出页面。                       |

2，鼠标 / 键盘属性



| 属性                                                         | 描述                                         |
| ------------------------------------------------------------ | -------------------------------------------- |
| [altKey](http://www.w3school.com.cn/jsref/event_altkey.asp)  | 返回当事件被触发时，"ALT" 是否被按下。       |
| [button](http://www.w3school.com.cn/jsref/event_button.asp)  | 返回当事件被触发时，哪个鼠标按钮被点击。     |
| [clientX](http://www.w3school.com.cn/jsref/event_clientx.asp) | 返回当事件被触发时，鼠标指针的水平坐标。     |
| [clientY](http://www.w3school.com.cn/jsref/event_clienty.asp) | 返回当事件被触发时，鼠标指针的垂直坐标。     |
| [ctrlKey](http://www.w3school.com.cn/jsref/event_ctrlkey.asp) | 返回当事件被触发时，"CTRL" 键是否被按下。    |
| [screenX](http://www.w3school.com.cn/jsref/event_screenx.asp) | 返回当某个事件被触发时，鼠标指针的水平坐标。 |
| [screenY](http://www.w3school.com.cn/jsref/event_screeny.asp) | 返回当某个事件被触发时，鼠标指针的垂直坐标。 |
| [shiftKey](http://www.w3school.com.cn/jsref/event_shiftkey.asp) | 返回当事件被触发时，"SHIFT" 键是否被按下。   |

3，IE 属性

除了上面的鼠标/事件属性，IE 浏览器还支持下面的属性：【基本不怎么用，IE是个奇葩】



| 属性            | 描述                                                         |
| --------------- | ------------------------------------------------------------ |
| fromElement     | 对于 mouseover 和 mouseout 事件，fromElement 引用移出鼠标的元素。 |
| keyCode         | 对于 keypress 事件，该属性声明了被敲击的键生成的 Unicode 字符码。对于 keydown 和 keyup 事件，它指定了被敲击的键的虚拟键盘码。虚拟键盘码可能和使用的键盘的布局相关。 |
| offsetX,offsetY | 发生事件的地点在事件源元素的坐标系统中的 x 坐标和 y 坐标。   |
| srcElement      | 对于生成事件的 Window 对象、Document 对象或 Element 对象的引用。 |
| toElement       | 对于 mouseover 和 mouseout 事件，该属性引用移入鼠标的元素。  |
| x,y             | 事件发生的位置的 x 坐标和 y 坐标，它们相对于用CSS动态定位的最内层包容元素。 |

4，相关实例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function whichButton(event){
            var btnNum = event.button;
            if(btnNum == 2){
                alert('你点击了鼠标右键');
            } else if(btnNum == 1){
                alert('你点击了鼠标中键');
            } else if(btnNum == 0){
                alert('你点击了鼠标左键');
            } else {
                alert("您点击了" + btnNum+ "号键，我不能确定它的名称。");
            }
        }
    </script>
</head>
<body onmousedown="whichButton(event)" >
<p>请在文档中点击鼠标。一个消息框会提示出您点击了哪个鼠标按键。</p>
</body>
</html>
```

得到客户端的的坐标

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function show_coords(event){
            x = event.clientX;
            y = event.clientY;
            alert('x 坐标:'+x+'y 坐标:'+y);
        }
    </script>
</head>
<body onmousedown="show_coords(event)" >
    <p>请在文档中点击。一个消息框会提示出鼠标指针的 x 和 y 坐标。</p>
</body>
</html>
```

得到键盘的事件

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function whichButtion(event) {
            alert(event.keyCode);
        }
    </script>
</head>

<body onkeyup="whichButton(event)">


    <p><b>注释：</b>在测试这个例子时，要确保右侧的框架获得了焦点。</p>


    <p>在键盘上按一个键。消息框会提示出该按键的 unicode。</p>

</body>

</html>
```

得到屏幕的坐标

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function coordinates(event){
            x = event.screenX;
            y = event.screenY;
            alert('x='+x+' y='+y);
        }
    </script>
</head>

<body onmousedown="coordinates(event)">
    <p>在文档中点击某个位置，消息框会提示出指针相对于屏幕的x和y坐标</p>

</body>

</html>
```



二，DOM Document 对象【window.document.】

每个载入浏览器的 HTML 文档都会成为 Document 对象。

Document 对象使我们可以从脚本中对 HTML 页面中的所有元素进行访问。

提示：Document 对象是 Window 对象的一部分，可通过 window.document 属性对其进行访问。

Document 对象集合

| 集合                                                         | 描述                               |
| ------------------------------------------------------------ | ---------------------------------- |
| [all](http://www.w3school.com.cn/jsref/coll_doc_all.asp)     | 提供对文档中所有 HTML 元素的访问。 |
| [forms[\]](http://www.w3school.com.cn/jsref/coll_doc_forms.asp) | 返回对文档中所有 Form 对象引用。   |
| [images[\]](http://www.w3school.com.cn/jsref/coll_doc_images.asp) | 返回对文档中所有 Image 对象引用。  |

Document 对象属性

| 属性                                                         | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| body                                                         | 提供对 <body> 元素的直接访问。对于定义了框架集的文档，该属性引用最外层的 <frameset>。 |
| [cookie](http://www.w3school.com.cn/jsref/prop_doc_cookie.asp) | 设置或返回与当前文档有关的所有 cookie。                      |
| [domain](http://www.w3school.com.cn/jsref/prop_doc_domain.asp) | 返回当前文档的域名。                                         |
| [lastModified](http://www.w3school.com.cn/jsref/prop_doc_lastmodified.asp) | 返回文档被最后修改的日期和时间。                             |
| [referrer](http://www.w3school.com.cn/jsref/prop_doc_referrer.asp) | 返回载入当前文档的文档的 URL。                               |
| [title](http://www.w3school.com.cn/jsref/prop_doc_title.asp) | 返回当前文档的标题。                                         |
| [URL](http://www.w3school.com.cn/jsref/prop_doc_url.asp)     | 返回当前文档的 URL。                                         |

Document 对象方法

| 方法                                                         | 描述                                                        |
| ------------------------------------------------------------ | ----------------------------------------------------------- |
| [getElementById()](http://www.w3school.com.cn/jsref/met_doc_getelementbyid.asp) | 返回对拥有指定 id 的第一个对象的引用。                      |
| [getElementsByName()](http://www.w3school.com.cn/jsref/met_doc_getelementsbyname.asp) | 返回带有指定名称的对象集合。                                |
| [getElementsByTagName()](http://www.w3school.com.cn/jsref/met_doc_getelementsbytagname.asp) | 返回带有指定标签名的对象集合。                              |
| createElement()                                              | 创建一个标签createElement("img")                            |
| createAttribute()                                            | 创建一个属性                                                |
| [write()](http://www.w3school.com.cn/jsref/met_doc_write.asp) | 向文档写 HTML 表达式 或 JavaScript 代码。                   |
| [writeln()](http://www.w3school.com.cn/jsref/met_doc_writeln.asp) | 等同于 write() 方法，不同的是在每个表达式之后写一个换行符。 |

Document 对象描述

HTMLDocument 接口对 DOM Document 接口进行了扩展，定义 HTML 专用的属性和方法。

很多属性和方法都是 HTMLCollection 对象（实际上是可以用数组或名称索引的只读数组），其中保存了对锚、表单、链接以及其他可脚本元素的引用。

这些集合属性都源自于 0 级 DOM。它们已经被 Document.getElementsByTagName() 所取代，但是仍然常常使用，因为他们很方便。

write() 方法值得注意，在文档载入和解析的时候，它允许一个脚本向文档中插入动态生成的内容。

注意，在 1 级 DOM 中，HTMLDocument 定义了一个名为 getElementById() 的非常有用的方法。在 2 级 DOM 中，该方法已经被转移到了 Document 接口，它现在由 HTMLDocument 继承而不是由它定义了。

以上说明的使用方法是document.xxxx  或者   window.document.xxx

------

**三，DOM Element 对象【元素对象】**

在 HTML DOM 中，Element 对象表示 HTML 元素。

Element 对象可以拥有类型为元素节点、文本节点、注释节点的子节点。

NodeList 对象表示节点列表，比如 HTML 元素的子节点集合。

| 属性 / 方法                                                  | 描述                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| element.parentElement                                        | 得到元素的父元素                                   |
| [element.appendChild()](http://www.w3school.com.cn/jsref/met_node_appendchild.asp) | 向元素添加新的子节点，作为最后一个子节点。         |
| [element.attributes](http://www.w3school.com.cn/jsref/prop_node_attributes.asp) | 返回元素属性的 NamedNodeMap。                      |
| [element.childNodes](http://www.w3school.com.cn/jsref/prop_node_childnodes.asp) | 返回元素子节点的 NodeList。                        |
| [element.className](http://www.w3school.com.cn/jsref/prop_html_classname.asp) | 设置或返回元素的 class 属性。                      |
| element.clientHeight                                         | 返回元素的可见高度。                               |
| element.clientWidth                                          | 返回元素的可见宽度。                               |
| [element.firstChild](http://www.w3school.com.cn/jsref/prop_node_firstchild.asp) | 返回元素的首个子。                                 |
| [element.getAttribute()](http://www.w3school.com.cn/jsref/met_element_getattribute.asp) | 返回元素节点的指定属性值。                         |
| [element.hasAttribute()](http://www.w3school.com.cn/jsref/met_element_hasattribute.asp) | 如果元素拥有指定属性，则返回true，否则返回 false。 |
| [element.hasAttributes()](http://www.w3school.com.cn/jsref/met_node_hasattributes.asp) | 如果元素拥有属性，则返回 true，否则返回 false。    |
| [element.id](http://www.w3school.com.cn/jsref/prop_html_id.asp) | 设置或返回元素的 id。                              |
| [element.innerHTML](http://www.w3school.com.cn/jsref/prop_html_innerhtml.asp) | 设置或返回元素的内容。                             |
| [element.lastChild](http://www.w3school.com.cn/jsref/prop_node_lastchild.asp) | 返回元素的最后一个子元素。                         |
| [element.nodeName](http://www.w3school.com.cn/jsref/prop_node_nodename.asp) | 返回元素的名称。                                   |
| [element.nodeType](http://www.w3school.com.cn/jsref/prop_node_nodetype.asp) | 返回元素的节点类型。                               |
| [element.nodeValue](http://www.w3school.com.cn/jsref/prop_node_nodevalue.asp) | 设置或返回元素值。                                 |
| [element.parentNode](http://www.w3school.com.cn/jsref/prop_node_parentnode.asp) | 返回元素的父节点。                                 |
| [element.removeAttribute()](http://www.w3school.com.cn/jsref/met_element_removeattribute.asp) | 从元素中移除指定属性。                             |
| [element.removeAttributeNode()](http://www.w3school.com.cn/jsref/met_element_removeattributenode.asp) | 移除指定的属性节点，并返回被移除的节点。           |
| [element.removeChild()](http://www.w3school.com.cn/jsref/met_node_removechild.asp) | 从元素中移除子节点。                               |
| [element.replaceChild()](http://www.w3school.com.cn/jsref/met_node_replacechild.asp) | 替换元素中的子节点。                               |
| [element.setAttribute()](http://www.w3school.com.cn/jsref/met_element_setattribute.asp) | 把指定属性设置或更改为指定值。                     |
| [element.setAttributeNode()](http://www.w3school.com.cn/jsref/met_element_setattributenode.asp) | 设置或更改指定属性节点。                           |
| element.style                                                | 设置或返回元素的 style 属性。                      |
| [element.tabIndex](http://www.w3school.com.cn/jsref/prop_html_tabindex.asp) | 设置或返回元素的 tab 键控制次序。                  |
| [element.title](http://www.w3school.com.cn/jsref/prop_html_title.asp) | 设置或返回元素的 title 属性。                      |
| element.toString()                                           | 把元素转换为字符串。                               |

------

**四，DOM Attribute 对象【访问元素中的属性，先得到元素，再根据元素去访问属性】**

在 HTML DOM （文档对象模型）中，每个部分都是节点：

文档本身是文档节点

所有 HTML 元素是元素节点

所有 HTML 属性是属性节点

HTML 元素内的文本是文本节点

注释是注释节点cookie

注意，要访问属性必须是document文档加载完成才能访问，也就是script代码必须写到body之后

属性

| [attr.name](http://www.w3school.com.cn/jsref/prop_attr_name.asp) | 返回属性的名称。                              |
| ------------------------------------------------------------ | --------------------------------------------- |
| [attr.value](http://www.w3school.com.cn/jsref/prop_attr_value.asp) | 设置或返回属性的值。                          |
| [attr.specified](http://www.w3school.com.cn/jsref/prop_attr_specified.asp) | 如果已指定属性，则返回 true，否则返回 false。 |

```
document.getElementsByTagName("button")[0].attributes[0].name;
```