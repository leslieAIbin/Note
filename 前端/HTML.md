---
typora-root-url: images
---

# HTML简介

HTML（HyperText Mark-up Language）即超文本标记语言，是目前网络上应用最为广泛的语言，也是构成网页文档的主要语言。HTML文本是由HTML命令组成的描述性文本，HTML命令可以说明文字、图
形、动画、声音、表格、链接等。HTML的结构包括头部（Head）、主体（Body）两大部分，其中头部描述浏览器所需的信息，而主体则包含所要说明的 具体内容。

 HTML语言被称为互联网的三大基石之一(其余两大基石分别为：HTTP协议、URL)。它解决了如何以丰富的效果展示数据内容的问题。互联网中，数据是在服务器和浏览器之间互相传送和执行。三大基石分别解决了如下问题：

HTTP协议：解决了服务器和浏览器之间数据如何传送、传送格式的问题！实现了分布式的信息共享。

URL协议：解决了众多服务器中资源定位问题。从而让浏览器可以访问不同的服务器资源，实现了全球信息的精确定位。

HTML语言：解决了数据在浏览器中如何丰富多彩的展示，及如何合理标示信息的问题。

我们访问一个互联网资源：http://www.baidu.com，流程如下：



第一步：地址栏输入：

https://www.baidu.com

第二步：服务器收到请求，将HTML源代码传给客户端：

    <!doctype html><html><head><meta  http-equiv="Content-Type" content="text/html;charset=gb2312"><title>百度一下，你就知道   </title> </head><body><p id="u"><a  href="[/gaoji/preferences.html](view-source:http://www.baidu.com/gaoji/preferences.html)">搜索设置</a>&nbsp;|&nbsp;<a  href="http://passport.baidu.com/?login&tpl=mn">登录</a></p><div id="m"><p  id="lg"><img src="[http://www.baidu.com/img/baidu_logo.gif](view-source:http://www.baidu.com/img/baidu_logo.gif)" width="270"  height="129" usemap="#mp"></p><p id="nv"><a  href="[http://news.baidu.com](view-source:http://news.baidu.com/)">新&nbsp;闻</a>　<b>网&nbsp;页</b>　<a href="[http://tieba.baidu.com](view-source:http://tieba.baidu.com/)">贴&nbsp;吧</a>　<a href="[http://zhidao.baidu.com](view-source:http://zhidao.baidu.com/)">知&nbsp;道</a>　<a href="[http://mp3.baidu.com](view-source:http://mp3.baidu.com/)">MP3</a>　<a href="[http://image.baidu.com](view-source:http://image.baidu.com/)">图&nbsp;片</a>　<a href="[http://video.baidu.com](view-source:http://video.baidu.com/)">视&nbsp;频</a>　<a href="[http://map.baidu.com](view-source:http://map.baidu.com/)">地&nbsp;图</a></p><div id="fm"><form name="f"  action="s"><input type="text" name="wd"  id="kw" maxlength="100"><input type="submit"  value="百度一下" id="su"></form><div  id="mCon"><span>输入法</span></div><ul  id="mMenu"><li><a href="[#](view-source:http://www.baidu.com/)" name="ime_hw">手写</a></li><li><a  href="[#](view-source:http://www.baidu.com/)" name="ime_py">拼音</a></li><li class="ln"></li><li><a  href="[#](view-source:http://www.baidu.com/)" name="ime_cl">关闭</a></li></ul></div><p id="lk"><a  href="[http://hi.baidu.com](view-source:http://hi.baidu.com/)">空间</a>　<a href="[http://baike.baidu.com](view-source:http://baike.baidu.com/)">百科</a>　<a href="[http://www.hao123.com](view-source:http://www.hao123.com/)">hao123</a><span>  | <a href="[/more/](view-source:http://www.baidu.com/more/)">更多&gt;&gt;</a></span></p><p id="lm"></p><p><a  id="st" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.baidu.com')"  href="[http://utility.baidu.com/traf/click.php?id=215&url=http://www.baidu.com](view-source:http://utility.baidu.com/traf/click.php?id=215&url=http://www.baidu.com)">把百度设为主页</a></p><p id="lh"><a  href="[http://e.baidu.com/?refer=888](view-source:http://e.baidu.com/?refer=888)">加入百度推广</a> | <a href="[http://top.baidu.com](view-source:http://top.baidu.com/)">搜索风云榜</a> | <a href="[http://home.baidu.com](view-source:http://home.baidu.com/)">关于百度</a> | <a href="[http://ir.baidu.com](view-source:http://ir.baidu.com/)">About Baidu</a></p><p id="cp">&copy;2011  Baidu <a href="[/duty/](view-source:http://www.baidu.com/duty/)">使用百度前必读</a> <a href="[http://www.miibeian.gov.cn](view-source:http://www.miibeian.gov.cn/)" target="_blank">京ICP证030173号</a> <img src="[http://gimg.baidu.com/img/gs.gif](view-source:http://gimg.baidu.com/img/gs.gif)"></p></div><map  name="mp"><area shape="rect" coords="43,22,227,91"  href="[http://hi.baidu.com/baidu/](view-source:http://hi.baidu.com/baidu/)" target="_blank" title="点此进入 百度的空间"></map></body>

第三步：浏览器解释执行上面的代码，出现如下丰富多彩的效果

![](/1.png)

# HTML起源和历史

HTML作为定义万维网的基本规则之一，最初由蒂姆·本尼斯李（Tim Berners-Lee）于1989年在CERN（Conseil Europeen pour la Recherche
Nucleaire）研制出来。HTML的设计者是这样考虑的：HTML格式将允许科学家们透明地共享网络上的信息，即使这些科学家使用的计算机差别很大。因此，这种格式必须具备如下几个特点：

? 独立于平台，即独立于计算机硬件和操作系统。这个特性对各种受从是至关重要的，因为在这个特性中，文档可以在具有不同性能（即字体、图形和颜色差异）的计算机上以相似的形式显示文档内容。

? 超文本。允许文档中的任何文字或词组参照另一文档，这个特性将允许用户在不同计算机中的文档之间及文档内部漫游。

? ·精确的结构化文档。该特性将允许某些高级应用，如HTML文档和其他格式文档间互相转换以及搜索文本数据库。

经过二十多年的发展，HTML已经成为IT时代最重要的技术！HTML标准经历了如下版本更换：

1.超文本置标语言(第一版)——在1993年6月发为[互联网](http://baike.baidu.com/view/6825.htm)工程工作小组 (IETF)工作草案发布（并非标准）.

2.HTML 2.0——1995年11月作为RFC 1866发布，在RFC 2854于2000年6月发布之后被宣布已经过时

3.HTML 3.2——1996年1月14日，W3C推荐标准

4.HTML 4.0——1997年12月18日，W3C推荐标准

5.HTML 4.01（微小改进）——1999年12月24日，W3C推荐标准

6.HTML5草案的前身名为Web Applications
1.0。於2004年被WHATWG提出，於2007年被W3C接纳，并成立了新的HTML工作团队。在2008年1月22日，第一份正式草案已公布,预计将在2010年9月正式向公众推荐。WHATWG表示该规范是目前正在进行的工作，仍须多年的努力。

# 为什么要学习HTML

目前软件的形式分两种一种是C/S架构 另一种是B/S架构

C/S架构,此处的C为Client

B/S架构，此处的B即为Browser浏览器。

那么，要想在浏览器中展示数据，必然涉及到HTML。因此，HTML也成为目前软件工程师必须要掌握的基本技能！

对于我们JAVA工程师来讲，我们将更加关注HTML中的一些常用标签的使用，尤其是表单标签是我们需要掌握的重点。

我们并不需要特别关注，HTML标签显示效果，页面的美观度。术业有专攻，这些将会由公司美工来负责。

移动端也有BS和CS之分

# 第一个HTML程序

## **说明**

HTML文件是普通的文本文件，只是文件扩展名为：.html或者.html。下面我们开始创建我们的第一个HTML程序。

------

## **创建HTML程序**

 1，新建文本文件 1.html

```html
<html>

<head>
    <title>my first page</title>
</head>

<body bgcolor=blue>
    This is my first homepage!
</body>

</html>
```

![](/2.png)

# HTML基本标签

## 标签集合

![](/3.png)

## <head\>中常见子元素的含义

    1. 说明HTML文档一些要素,告诉浏览器如何解析。
    
    2. 告诉搜索引擎本文档相关的内容。**(seo)**
    
    ```html
    
    <head>
        <title>典型的head</title>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
        <meta name="author" content="zhangsan">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta name="keywords" content=“JAVA,学习,培训 "><meta name=" description " content=“关于北京地区java培训的介绍">
        <meta http-equiv="refresh" content="5;URL=http://www.163.com">
        <link rel="stylesheet" type="text/css" href="css/pagination.css" />
        <script type="text/javascript" src="js/search.js"></script>
    </head>
    ```
## 标题标记<hr\>

<h1\>、<h2\>、<h3\>、<h4\>、<h5\>、<h6\>,作为标题使用，并且依据重要性递减。<h1\>是最高的等级。例如: 

　　<h1\>文档标题</h1\> 
　　<h2\>次级标题</h2\>

搜索引擎比较重视<hx\>标记中的内容。

## 文本标记<b\><i\><u\><del\>

<b>粗体显示

<i>斜体显示

<u>下划线显示

<del>中划线显示(删除效果)

## 预格式文本<pre\>

<pre\> 标签的一个常见应用就是用来表示计算机的源代码。

## 字体标签<font\>

<font\> 规定文本的字体、字体尺寸、字体颜色。比如：

<font size="3" color="red"\>This is some text!</font\>

<font size="2" color="blue"\>This is some text!</font\>

<font face="verdana" color="green"\>This is some text!</font\>

## 换行<br /\> 或者<br\>

<br\> 标签是空标签（意味着它没有结束标签，因此这是错误的：<br\></br\>）。在 XHTML 中，把结束标签放在开始标签中，也就是 <br /\>。

## 水平线<hr \>

\<hr \>标签在 HTML 页面中创建一条水平线。

水平分隔线（horizontal rule）可以在视觉上将文档分隔成各个部分。

注意：width 属性可以使用pixels像素值，也可以使用百分比。请注意它们的区别。如果是百分比，会随着窗口的变化，宽度也发生变化。像素值的话，窗口大小发生变化，水平线宽度也不发生变化。

## 超链接<a \>

```
<a href=“5.htm”>5.htm</a> 超链接
图片作为链接。
<a href="lastpage.htm">
<img border="0" src=".\images\next.gif">
</a> 
target属性(定义从什么地方打开链接地址)

<a href="http://www.163.com/" target="_blank">163!</a>      
锚标签和name属性
命名一个锚点：
<a name="label">Text to be displayed</a>
链接到锚点：
<a name="http://www.w3schools.com
/html_links.asp#label">Jump to the label</a>
创建邮件链接
<a href="mailto:test@163.com?subject=AboutHTML">
发邮件给我</a>
```

## 列表<ul \><ol\><li\>

![](/4.png)

<ol\>元素也有自己的type属性，type属性的属性值有1、A、a、I、i等。例如，我们以A、B、C……作为列表的编号

<ol\>元素还可以定义列表的起始编号，如我们希望列表的第一个编号为5，而不是1，则需要定义<ol\>元素的start属性

## 图像标签<img\>

src:源文件地址    width:宽度   height:高度  alt:说明文字

注：

1，一般建议都增加alt属性，这样有利于搜索引擎的搜索。

2，虽然可以使用width、height调整图像的大小，但是实际编程时，最好还是通过后台程序将图片进行缩放处理。

## 内嵌<embed \>

<embed\>标记用于在页面中嵌入多媒体文件，但是用户计算机上需要事先安装相应的处理程序。

常用嵌入式文档的格式：mp3, mid, wma, asf, swf, flv, rm, ra, ram, avi

典型用法：

\<embed src="ee.wmv" autostart="true" loop='true' hidden='false' width="100px" height="100px"/ \>

​              autostart:是否自动播放嵌入的文件。

​             loop:是否循环播放。也可以取数字，表明循环多少次。

   hidden:是否显示播放器。

## 表格标签<table\><tr\><td\><th\>

<table> 标签定义 HTML 表格。

简单的 HTML 表格由 table 元素以及一个或多个 tr、th 或 td 元素组成。

tr 元素定义表格行，th 元素定义表头，td 元素定义表格单元。

![](/5.png)

![](/6.png)

![](/7.png)

![](/8.png)

**注：表格标签以前经常用于网页的布局排版，不过现在已经基本上被CSS布局替代！**

## 块元素<div\>   CSS中会讲

<div\> 可定义文档中的分区或节（division/section）。

<div\>标签可以把文档分割为独立的、不同的部分。它可以用作严格的组织工具，并且不使用任何格式与其关联。

<div\> 是一个块级元素。这意味着它的内容自动地开始一个新行。

在CSS的学习中，我们会详细讲述<div\>的用法。

## 行内元素<span\> <label\> CSS中会讲

<span\> 标签被用来组合文档中的行内元素。在CSS的学习中，我们会详细讲述它的用法。

## 框架标签<frameset\><frame\><iframe\>

frameset 元素可定义一个框架集。它被用来组织多个窗口（框架）。每个框架存有独立的文档。在其最简单的应用中，frameset 

元素仅仅会规定在框架集中存在多少列或多少行。您必须使用 cols 或 rows 属性。

<frame\> 标签定义 frameset 中的一个特定的窗口（框架）。

frameset 中的每个框架都可以设置不同的属性，比如 border、scrolling、noresize 等等。

内嵌框架：

\<iframe src="http://www.baidu.com" width="300px" height="300px"\>
\</iframe\>

<noframes\>的作用：可为那些不支持框架的浏览器显示文本。

<frameset rows="100,*" border="5"frameborder="yes">



```
<frameset rows="100,*" border="5"frameborder="yes">
	<frame src="frame/top.jsp" name="top">
	<frameset cols="200,*" border="5"frameborder="yes">
        <frame src="frame/left.jsp" name="left">
        <frame src="frame/main.jsp" name="main">
	</frameset>
</frameset>
```

## 多媒体标签

```html
<embed src="http://player.youku.com/player.php/Type/Folder/Fid/23705555/Ob/1/sid/XOTM3OTQ5NTg4/v.swf" quality="high"width="480" height="400" align="middle" allowScriptAccess="always" allowFullScreen="true" mode="transparent"type="application/x-shockwave-flash"></embed>
```

效果是播放器

# 表单标签

![](/9.png)

**作用：收集用户填写的数据，然后提交到服务器上。**

**要提交数据的表单域必须加name属性。不然，该表单域的数据不会提交到服务器上。**

1. 文本框
   <input type="text"  name="uname"  value="333"  size="30"  maxlength="10" />

2. 密码框
   跟文本框的用法基本一致，除了页面上以星号显示<input type="password" name="pwd" /> 

3. 单选按钮
   用于多选一的情况  
   性别：<input type="radio" name="gender"  value="1" />男
              <input type="radio" name="gender"  value="0" />女

4. 复选框
   于多选多的情况：喜欢编程语言：
   			<input type="checkbox" name="favorite"/>  JAVA<br />
   			<input type="checkbox" name="favorite" value="2"/>  C++<br />
   			<input type="checkbox" name="favorite" value="3"/>  RUBY<br />
   			<input type="checkbox" name="favorite" value="4"/>  C<br />
   注意：
   复选框是分组的， name相同即为一组。 可同时多个复选框
   value：如果不增加value属性，选中该按钮提交时默认为：on，而不是空字符串。

5. 隐藏域
   <input type="hidden" name="hid" value="55"/> <br />

6. 下拉列表
   实现多选一 或多选多的效果。国籍：<br />		

       <select name="country" multiple>			
           <option>China</option>			
           <option value="2">America</option>			
           <option value="3">France</option>					
      </select>

   当<option>没有指定value属性。如果被选中，则提交<option>中的提示文本，而不是On或空字符串。注：单选按钮、复选框默认选中用：checked属性。  下拉列表使用：selected属性。

7. 文本域

   <textarea name="introduce" rows="4" cols="40">  </textarea>

8. 文件上传
   <input type="file" name="myfile" />

9. 提交按钮
   <input type="submit" value="提交" />

10. 普通按钮
    <input type="button"  value="我是普通按钮"/>

11. 重置按钮
    <input type="reset" value="重置"/>

# HTML字符实体

有些字符，比如说“<”字符，在HTML中有特殊的含义，因此不能在文本中使用。想要在HTML中显示一个小于号“<”，需要用到字符实体：\&lt;或者\&#60; 

实体名是大小写敏感的。

字符实体拥有三个部分：一个and符号（**&**），一个**实体名**或者一个**实体号**，最后是一个分号（**;**）

![](/10.png)

# 作业1

## 表格练习



主要练习表格

先完成大致样子，以后慢慢调试css

![](/11.png)

阅读老师发的模板页面中的页面，进一步熟悉HTML标签的用法

## 注册页面

![](/12.png)

# 默写

1. 写出HTML的结构代码

2. 写出head标签及其子标签

3. 写出body标签及常用的属性

4. 写出有序列表和无序列表的代码及type的值

5. 写出超链接和tagret  _black和_self的区别

6. 写出图片标签里面alt  和title的区别

7. 写出frameset和frame的使用方法

8. 写出以下标签   每一类至少3个

9. 1. 占一行可以设置宽高
   2. 不占一行可以设置宽高
   3. 不占一行不可设置宽高

10. 写出至少6个常用的表单控件[写出代码]

11. 写出一个二行一列边框为1的表格

12. 写出form里面action 和  method 的作用

13. 写出HTML字符实体的“空格”和"&"的表式方法

# 练习2

练习一

\1. 叙述URL、HTML、HTTP的作用

\2. HTML元素之间的关系有哪两种关系?并举例说明。

\3. 属性值用双引号、单引号、不加引号都可以。这种说法对吗?

\4. 使用文本编辑器编辑完HTML后，扩展名需要使用哪个?

\5. 完成我们的第一个HTML程序



练习二

\1. SEO是什么?

\2. title/description/keywords都跟SEO相关吗?

\3. 想做一个地址栏图标显示效果，怎么做?

\4. head中的内容会在页面上显示吗?



练习三

\1. <img>标记中alt属性和title属性的区别?

\2. 将youku上的某个视频通过<embed>属性增加到自己的网页中。

\3. 将课堂上老师写的常见标记自己练习体会一下



练习四

\1. 表单的提交方式有get和post，它们有什么区别?

\2. 一个表单域如果没有设定name属性，它的值会不会被提交?

\3. 单选按钮是分组的，名字相同的分为一组。对吗?

\4. 如果我想做“多选一”，可以使用哪些表单域? "多选多"可以使用哪些表单域?

\5. 如果想打开页面后就默认选中某个复选框，使用checked还是selected属性?

\6. 完成一个注册表单（可以不美观，不对齐。实现功能即可）

