---
typora-root-url: images
---

# 什么是CSS

 CSS是层叠样式表（Cascading Style Sheets）的缩写，它用于定义HTML元素的显示形式，是一种格式化网页内容的技术。CSS现在已经被大多数浏览器所支持，成为网页设计者必须掌握的技术之一。

------

​       W3C自1996年12月发布第一个CSS正式推荐版CSS 1.0以来，一直在对CSS标准进行修订、升级。1999年1月，CSS 2.0 正式推荐版发布，增加了对其它媒体（打印机、视觉设备）、可下载字体、元素定位和表格的支持。最新版本的CSS标准CSS 3.0已经发部，就是HTML5里面的主要东西。

# CSS的主要优势和学习要点

## **一，优势**

1.专注于显示。**使显示和数据本身分离。**

2.优势：

1. CSS将从基础开始建设直到全面替代传统Web设计方法。W3C组织创建的CSS技术将替代HTML中用于表现的HTML元素。
2. 提高页面浏览速度。使用CSS，比传统的Web设计方法至少节约50%以上的文件尺寸。
3. 缩短改版时间，降低维护费用。只要简单修改几个CSS文件就可以重新设计一个有成百上千页面的站点。
4. 强大的字体控制和排版能力。有了CSS，我们不再需要用font标记或者透明的1 px GIF图片来控制标题，改变字体颜色、字体样式等等。
5. CSS非常容易编写。我们可以象写HTML代码一样轻松地编写CSS。
6. 可以一次设计，随处发布。你的设计不仅仅用于Web浏览器，也可以发布在其他设备上。
7. 更好的控制页面布局。结合CSS和div元素，可以比传统的使用table元素更好地控制页面布局。
8. 实现表现和结构、内容相分离。将网页的表现形式部分剥离出来放在一个独立样式文件中，可以减少未来网页无效的可能。

更方便搜索引擎的搜索。用只包含结构化内容的HTML代替嵌套的标签，搜索引擎将更有效地搜索到网页的内容，并可能给网页一个较高的评价。

------

## **二，学习要点**

1，Css是什么？有什么优势？（css：cascade style sheet）

2，怎么样引用css文件、css样式？

3， Css选择器（如果对ajax感兴趣的话，可以了解）

4，和美工有沟通



# 样式规则及引入方式

## 一，样式规则

CSS与字处理程序中的样式的工作方式相似，我们可以先定义一个包含格式选项的“样式”，然后将其应用于文档元素。CSS样式由样式规则组成，所有的样式规则的语法遵循如下

相同的基本格式：

选择器 { 属性1: 值1; 属性2: 值2; ... 属性N: 值N; }

一条样式规则由一个选择器和一个或者多个声明组成；

选择器指定规则可作用于HTML文档中哪个或者哪些元素；

声明要用大括号（{}）括起来。每个声明要用分号（;）结束。

一个属性/值对组成一个声明，属性和值之间用冒号（:）分隔；

如果属性值中包含了空格，那么该值就必须用双引号（""）括起来。例如：font-family: "Times New Roman"; 

我们还可以指定多个选择器使用相同的样式定义，选择器之间用逗号分隔开。例如，如果我们想要把所有标题列标记（从1到6）的文本字体颜色都定义为红色，可以使用如下定义：

h1, h2, h3, h4, h5, h6 { color: red; }

```
h1 {color:red; font-size:14px;}
```

![](/13.png)

## **二，引入方式**

1. 外部样式表 
   不需要style标签 
   <link rel="stylesheet" href="" />

2. 嵌入式样式表

   <style  type="text/css">p{}</style>

内联样式
属性名为style

## **三，样式就近原则**

误解：外部文件<内部样式块对象<style属性

一句话：**谁离得近，谁优先级高！**

# 选择器

## **一，元素选择器**  

HTML元素是最典型的选择器类型，任何一个HTML元素都可以做为选择器。元素选择器的有效范围为页面中所有的、名称相同的HTML元素。

**格式：**  **元素 {** **属性:** **值; }** 

**例如：h1 { color: red; }  h2 { color: #FF0000; }**    **或者：h1, h2 { color: #ff0000; }**

## **二，类选择器【重点】**

如果想要把某一个样式应用到不同的HTML元素上，可以采用类选择器来定义，然后在不同标签中应用它们。

格式1： **.**类名 { **属性:** **值; }**  

**格式2：元素.类名 {** **属性:** **值; }**

```css
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>类选择器示例1</title>
<style type="text/css">
.tt{ 
    font-size:10pt; 
    font-family:黑体; 
    color:#800080; 
    font-weight:bold; 
}
</style>
</head>
<body>
<p class="tt">示例一</p> /*p标签应用名字为tt的类层叠样式表*/
<h1 class="tt">示例二</h1> /*h1标签也应用名字为tt的类层叠样式表*/
</body>
</html>
```

## **三，ID选择器**

除了使用类选择器的方式定义一个样式以外，还可以使用ID定义样式。ID与类选择器的概念相似，只是ID选择器只能被引用一次，而类选择器可以被多次引用。

​           格式：**#id**名 {属性:**值;  }**

​           示例：**#red { color: red; }**

<p id="red">欢迎使用id选择器</p> 
## **四，后代选择器**

如果需要为位于某个标记符内的元素设置特定的样式规则，则应将选择器指定为具有上下文关系的HTML标记

**h1 b{ color:blue; } /\***注意h1****和b****之间以空格分隔\*/

## **五，属性和值选择器**

下面的例子为带有 title 属性的所有元素设置样式：

```
[title]
{
color:red;
}
```

下面的例子为 title="bjsxt" 的所有元素设置样式：

```
[title=bjsxt]
{
border:5px solid blue;
}
```

设置表单的样式

```
input[type="text"]
{
  width:150px;
  display:block;
  margin-bottom:10px;
  background-color:yellow;
  font-family: Verdana, Arial;
}

input[type="button"]
{
  width:120px;
  margin-left:35px;
  display:block;
  font-family: Verdana, Arial;
}
```

## **六，通配符选择器**

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>通配置符选择器</title>
    <style type="text/css">
        /*  通配符选择器        
        语法格式：            
        *{                
        	属性:值;            
        }        语
        法说明:            
        *表示任意标签        
        注意:            
        1.在实际开发中，*因为通配任意标，而且不同浏览器，body存在间距，所以一般使用*处理间隙        
        */
        * {
            margin: 0px;
            padding: 0px;
            background-color: brown;
        }
    </style>
</head>

<body></body>

</html>
```

## **七，交集选择器**

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>交集选择器</title>
    <style type="text/css">
        /*        
        交集选择器        
        语法格式：            
        元素名.类名{                
            属性:值;            
        }            
        或者            
        元素名
        #ID值{                
            属性:值;            
        }         
        语法解释:            
        1.交集符合选择器是由两个选择器直接构成的，其结果是二者元素范围的交集。            
        2.其中第一个选择器必须是元素选择器，第二个选择器是ID选择器或者类选择器            
        3.两个选择器中间不能有空格        
        */
        p.classvalue {
            color: red;
            text-align: center;
        }
    </style>
</head>

<body>
    <div>
        <p class="classvalue">我是DIV中的P标签,class值为p1</p>
        <p>我是DIV中的P标签,没有class</p>
    </div>
</body>

</html>
```

## **八，并级选择器**

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>并集选择器</title>
    <style type="text/css">
        /*        
        并集选择器        
        语法格式:            
        选择器1,选择器2,...,选择器n{                
            属性:值;            
        }        
        语法说明:           
        1.并集选择器是由多个选择器组成,各个选择器之间使用英文的逗号(,)分隔。            
        2.这多个选择器都会有这些CSS样式        
        注意：            
        1.在实际开发中并集选择器使用频率比较高。            
        2.公共样式可以使用并集选择器抽离出来,这样精简CSS样式代码        */
        div,
        p {
            width: 200px;
            height: 100px;
            border: 2px solid rebeccapurple;
        }
    </style>
</head>

<body>
    <div> 我是div </div>
    <p>我是P标签</p>
</body>

</html>
```

## **九，子选择器**

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>子类选择器</title>
    <style type="text/css">
        /*        
        子类选择器       
         语法格式:            
         选择器1>选择器2{                
             属性:值;            
            }        
            语法说明:            
            1.子类选择器也是由多个选择器组成,各个选择器之间使用">"连接，其效果类似于后代选择器        
            注意:            
            子类选择器其作用类似于后代选择器,但是子类选择器其效率高于后代选择器,推荐使用        */
        body>div {
            border: #ff858f 2px solid;
            height: 300px;
            width: 400px;
            background-color: #c7ffaf;
        }
    </style>
</head>

<body>
    <div>我是body中的div</div>
</body>

</html>
```

## **十，伪类选择器**

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>伪类选择器</title>
    <style type="text/css">
        /*        
        伪类选择器        
        语法格式:            
        初始化的样式            
        a:link{                
        属性:值;            
        }            
        鼠标点击过后的样式            
        a:visited{                
        属性:值;            
        }            
        鼠标放在上面的样式            
        a:hover{                
        属性:值;            
        }            
        鼠标按下时的样式            
        a:active{                
        属性:值;            
        }            
        注意：                
        1.在CSS样式的定义中,a:hover 必须被置于 a:link 和 a:visited 之后顺序不对，有时样式会失效           2.:hover属性适用于任何元素                
        3.应当将相同的属性抽离出来,放在a标签选择器中        */
        div {
            margin: 30% auto;
            height: 200px;
            width: 700px;
        }

        a:link {
            color: #ff858f;
            font-size: 20px;
            font-family: "Microsoft YaHei UI";
            text-decoration: none;
            margin: 20px;
        }

        a:hover {
            text-decoration: underline;
            color: #1bff4c;
            font-size: 25px;
            font-weight: bold;
        }

        a:active {
            color: red;
            text-decoration: none;
        }

        a:visited {
            color: aqua;
        }

        div.div2:link {
            background-color: #1bff4c;
            height: 200px;
            width: 200px;
        }

        div.div2:hover {
            background-color: #ff858f;
        }
    </style>
</head>

<body>
    <div> <a href="http://www.baidu.com">我是A标签1</a> <a href="#">我是A标签2</a> <a href="#">我是A标签3</a> <a href="#">我是A标签4</a>
    </div>
    <div class="div2"> 我是个DIV </div>
</body>

</html>
```

# CSS属性单位

1， 长度单位

- 1，绝对长度值包括cm、mm、in、pt、pc等，绝对长度值最好用于打印输出设备，而在仅仅作为屏幕显示用时，绝对长度值并无多大意义。
- 2，**相对长度值包括px、em、ex等。相对长度是指元素尺寸相对于浏览器的系统默认值来相应的缩放**。

2，颜色单位

> - 1，用百分比值来表示，如color:rgb(50%,0,50%) ；
> - 2，使用0-255之间的整数值来设置，如color:rgb(128,0,128) ；
> - 3，使用十六进制数组定义颜色，如#fc0eab；
> - 4，使用简化的十六进制数定义颜色，如#080；
> - 5，为颜色取名：aqua,black,blue,fuchsia,gray,green等。

3，URL单位

​     URL单位的具体格式是：在“url”后面紧跟一个括号，括号中是url的地址。如果在地址中使用了括号、逗号、空格、单引号和双引号，那么就必须在整个地址的外面加上一对单引号或者双引号。地址可以是相对地址或绝对地址。  

​    例如：

p{ background-image : url(img/logo.gif) ; }

# 文本属性

![](/14.png)

---

Blink属性：ie不支持，火狐支持。（浏览器差异的问题）

实现溢出文本eclipsis的解决：

overflow:hidden;text-overflow:ellipsis; white-space:nowrap;

这三个属性必须一起使用。并且，这种方式只有ie支持。

# 背景属性

![](/15.png)



background-attachment:fixed:属性：火狐支持，ie6不支持；ie7支持。

设置背景图片是否随着滚动而动

# 列表属性

主要是对ul和ol用

![](/16.png)

# 定位属性

## **一，position: relative | absolute | static | fixed**

1. static 没有特别的设定，遵循基本的定位规定，不能通过z-index进行层次分级。
2. relative 不脱离文档流，参考自身静态位置,通过top,bottom,left,right 定位，并且可以通过z-index进行层次分级。
3. absolute 脱离文档流，通过top,bottom,left,right 定位。选取其最近的父级定位元素，当父级 position 为 static 时，absolute元素将以body坐标原点进行定位，可以通过z-index进行层次分级。
4. fixed 固定定位，这里他所固定的对象是可视窗口而并非是body或是父级元素。可通过z-index进行层次分级。

## **二，CSS中定位的层叠分级：z-index: auto | number ;**

auto 遵从其父对象的定位

number  无单位的整数值。可为负数。z-index使用整数表示元素的前后位置，数值越大，就会显示在相对靠前的位置，并且CSS同意在z-index中使用负数

# 布局属性-浮动属性

![](/17.png)

Display:为None时，其他元素可以占据该元素的位置。

Visibility: 为hidden时，其他元素不能占据该元素的位置。

浮动之后脱离文件流，不占位

# 元素的分类



## **一，元素的分类**

1，块级元素

2，内联元素

3，内联块级元素

------

## **二，块级元素**

1，常见的块级元素有 div,p,h1-h6,ol,ul,li,table,tr,td,form

2，块级元素的特点



-  每个元素都从新的一行开始，并且其后的元素也另起一行
- 元素的高度，宽度，行高以及顶和底边距都可以设置
- 元素宽度在不设置的情况下，是它本身父容器的100%（和父元素的宽度一样），除非设定一个宽度



3，设置display:block可以将元素显示为块级元素，如下的代码就是将内联元素a转成块级元素，从而使a元素具有块元素的特点   a{display:block}

------

## **三，内联元素**

1，常用的内联元素有  a,b,span,br,i,em,strong,lable,q,cite,code

2，内联元素的特点



- 和其它元素都在一行上
- 元素的高度，宽度及顶部和底部边距不可设置
- 元素的宽度就是它 的文字或图片的宽度，不可改变
- 内联元素也可以通过代码display:inline将元素设置为内联元素.如下的代码就是把块级元素设置成内联元素



> div{
>
> ​     display:inline;
>
> }

------

## **四，内联块级元素**

1，常用的内联块级元素有：img,input

2，内联块级元素的特点

和其它元素都在一行上

元素的高度，宽度，行高以及顶和底边距都可以设置

3，代码display:inline-block就是将元素设置为内联块级元素

# 盒子模型

## 盒子模型的内容



![](/18.png)

margin属性: margin-top, margin-bottom, margin-left, margin-right 

border属性:  border-color, border-style, border-width, border-top… 

padding属性: padding-top, padding-bottom, padding-left, padding-right

content属性: 

## 属性说明

###  1，margin:

围绕在内容边框的区域就是外边距，外边距默认为透明区域

外边距接任何长度单位，百分数

- margin:设置所有的外边距
- margin-top 设置上边的外边距
- margin-bottom, 设置下边的外边距
- margin-left, 设置左边的外边距
- margin-right 设置右边的外边距
- 注意外边距合并的问题

### 2，border  复合属性  

- border-width 边框宽度
- border-style 边框样式
- border-color 边框颜色
- border-radius 设置圆角边框
- border-shadow 设置对象阴影
- border-image 边框的背景图片

### 3，padding

内边距在content外，边框内

- padding 设置所有的内边距
- padding-top 设置上边的内边距
- padding-bottom, 设置下边的内边距
- padding-left, 设置左边的内边距
- padding-right 设置右边的内边距

## 盒子模型的分类

1，标准盒子：正常盒子模型、怪异盒子模型

2，伸缩盒：新、旧

## 正常盒子模型

```html
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        .outerbox {
            width: 200px;
            height: 200px;
            background-color: rosybrown;
        }

        .innerbox {
            width: 200px;
            height: 200px;
            background-color: royalblue;
        }
    </style>
</head>

<body>
    <div class="outerbox">
        <div class="innerbox"> haha </div>
    </div>
</body>

</html>
```

注意点：

1，padding内边距会在以前的基础上扩大，也就是会自动撑开，不用改原来的宽度

2，margin-top  margin-bottom  会取它大的那一个值 

## 怪异盒子模型

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        .outerbox {
            width: 200px;
            height: 200px;
            background-color: rosybrown;
            padding: 20px;
            box-sizing: border-box;
        }

        .innerbox {
            width: 200px;
            height: 200px;
            background-color: royalblue;
        }
    </style>
</head>

<body>
    <div class="outerbox">
        <div class="innerbox"> haha </div>
    </div>
</body>

</html>
```

注意点：

使用怪异的特点是固定了盒子的大小，无论怎么加边距，盒子的大小是不会改变的

## **旧伸缩盒ccs3**

1，css3引入一个种新的布局模式---flexbox布局，就是伸缩盒模型(flexible box)  用来提供一个更加有效的方式制定，调整和分布一个容器项目布局，即使它们的大小是未知或者动态的

2，FlexBox可以轻松的实现屏幕和浏览器窗口大小发生变化时，保持元素的相对位置和大小不变

属性说明

- 1，box-orient  伸缩盒对象的子元素的排列方式
- 2，box-pack  设置盒子里的内容垂直居中
- 2，box-align  设置盒子里的内容水平居中
- 4，box-flex   设置盒子内的对象按比例分配空间
- 5，box-direction  盒子里面的对象排列顺序是否反转

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        .container {
            width: 500px;
            height: 500px;
            background-color: darkgray;
            display: -webkit-box;
            /*变成盒子*/
            /*-webkit-box-pack: center;*/
            /*-webkit-box-orient: vertical;*/
            /*-webkit-box-align: center;*/
            /*-webkit-box-direction: reverse;*/
        }

        /*div{				display: inline-block;			}*/
        .one {
            width: 100px;
            height: 100px;
            background-color: antiquewhite;
            -webkit-box-flex: 1;
        }

        .two {
            width: 100px;
            height: 100px;
            background-color: pink;
            -webkit-box-flex: 1;
        }

        .three {
            width: 100px;
            height: 100px;
            background-color: palegreen;
            -webkit-box-flex: 1;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="one"> d1 </div>
        <div class="two"> d2 </div>
        <div class="three"> d3 </div>
    </div>
</body>

</html>
```

## **新伸缩盒css3**

相关属性

1，flex  复合属性，设置伸缩盒子对象的子元素如何分配空间

2，flex-grow   弹性盒子扩展比率，按比例平均分配 

3，flex-flow   复合属性  设置伸缩盒子对象子元素排列方式

4，flex-direction   伸缩盒子对象的子元素在父容器中的位置

5，flex-wrap   设置伸缩盒对象的子元素超出父容器时是否换行

6，order    设置伸缩盒对象的子元素出现的顺序

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        .container {
            width: 500px;
            height: 500px;
            background-color: darkgray;
            /*变成盒子*/
            display: -webkit-flex;
            /*-webkit-flex-direction: column-reverse;*/
            /*-webkit-flex-wrap: wrap;*/
        }

        .one {
            width: 300px;
            height: 100px;
            background-color: antiquewhite;
        }

        .two {
            width: 200px;
            height: 100px;
            background-color: pink;
            /*-webkit-order: 3;*/
        }

        .three {
            width: 100px;
            height: 100px;
            background-color: palegreen;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="one"> d1 </div>
        <div class="two"> d2 </div>
        <div class="three"> d3 </div>
    </div>
</body>

</html>
```

# 作业

## 使用CSS完成如下登录页面

![](/19.png)

## 用CSS完成注册页面

![](/20.png)

## 用CSS完成导航栏

![](/21.png)

## 用CSS完成百度页面

## 用CSS完成表格

![](/22.png)

## 用CSS完成列表

![](/23.png)