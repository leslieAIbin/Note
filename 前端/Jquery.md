---
typora-root-url: images
---



# Jquery简介与安装

**一，jQuery 简介**

jQuery 库可以通过一行简单的标记被添加到网页中。

1，您需要具备的基础知识

在您开始学习 jQuery 之前，您应该对以下知识有基本的了解：

1. HTML
2. CSS
3. JavaScript

2，什么是 jQuery ？

- jQuery是一个JavaScript函数库。
- jQuery是一个轻量级的"写的少，做的多"的JavaScript库。
- jQuery库包含以下功能：

> 1. HTML 元素选取
> 2. HTML 元素操作
> 3. CSS 操作
> 4. HTML 事件函数
> 5. JavaScript 特效和动画
> 6. HTML DOM 遍历和修改
> 7. AJAX

提示： 除此之外，Jquery还提供了大量的插件。

3，为什么使用 jQuery ？

目前网络上有大量开源的 JS 框架, 但是 jQuery 是目前最流行的 JS 框架，而且提供了大量的扩展。

很多大公司都在使用 jQuery， 例如:

1. Google
2. Microsoft
3. IBM
4. Netflix

------

**二，jQuery 安装**

1，下载 jQuery

> 有两个版本的 jQuery 可供下载：
>
> Production version - 用于实际的网站中，已被精简和压缩。
>
> Development version - 用于测试和开发（未压缩，是可读的代码）
>
> 以上两个版本都可以从[www.jquery.com](http://www.jquery.com/)中下载。

2，下载后的使用

​     jQuery 库是一个 JavaScript 文件，您可以使用 HTML 的 <script> 标签引用它：

```
<head><script src="jquery-1.10.2.min.js"></script></head>
```

3，其它方案使用

如果您不希望下载并存放 jQuery，那么也可以通过 CDN（内容分发网络） 引用它。

百度、又拍云、新浪、谷歌和微软的服务器都存有 jQuery 。

如果你的站点用户是国内的，建议使用百度、又拍云、新浪等国内CDN地址，如果你站点用户是国外的可以使用谷歌和微软。

菜鸟教程 CDN:

<head>

<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">

</script>

</head>

百度 CDN:

<head>

<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">

</script>

</head>

又拍云 CDN:

<head>

<script src="http://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js">

</script>

</head>

新浪 CDN:

<head>

<script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js">

</script>

</head>

# Juqery简单语法

**JQuery作用：**

通过 jQuery，您可以选取（查询，query） HTML 元素，并对它们执行"操作"（actions）。

------

**一，jQuery 语法
**

jQuery 语法是通过选取 HTML 元素，并对选取的元素执行某些操作。

基础语法： $(selector).action()

美元符号定义 jQuery

选择符（selector）"查询"和"查找" HTML 元素

jQuery 的 action() 执行对元素的操作

实例:

- $(this).hide() - 隐藏当前元素
- $("p").hide() - 隐藏所有 <p> 元素
- $("p.test").hide() - 隐藏所有 class="test" 的 <p> 元素
- $("#test").hide() - 隐藏所有 id="test" 的元素  

------

**二，文档就绪事件**

这是为了防止文档在完全加载（就绪）之前运行 jQuery 代码。

如果在文档没有完全加载之前就运行函数，操作可能失败。方法一

```
$(document).ready(function(){    // 开始写 jQuery 代码... });
```

方法二

```
$(function(){    // 开始写 jQuery 代码... });
```

# Jquery选择器

**jQuery 选择器**

jQuery 选择器允许您对 HTML 元素组或单个元素进行操作。

jQuery 选择器基于元素的 id、类、类型、属性、属性值等"查找"（或选择）HTML 元素。 它基于已经存在的 CSS 选择器，除此之外，它还有一些自定义的选择器。

jQuery 中所有选择器都以美元符号开头：$()。

------

**一，元素选择器**

jQuery 元素选择器基于元素名选取元素。

在页面中选取所有 <p> 元素:

$("p")

实例

用户点击按钮后，所有 <p> 元素都隐藏：

实例

```
$(document).ready(function(){  $("button").click(function(){    $("p").hide();  });});
```

**二，#id 选择器**

jQuery #id 选择器通过 HTML 元素的 id 属性选取指定的元素。

页面中元素的 id 应该是唯一的，所以您要在页面中选取唯一的元素需要通过 #id 选择器。

通过 id 选取元素语法如下：

$("#test")

实例

当用户点击按钮后，有 id="test" 属性的元素将被隐藏：

实例

```
$(document).ready(function(){  $("button").click(function(){    $("#test").hide();  });});
```

------

**三，.class 选择器**

jQuery 类选择器可以通过指定的 class 查找元素。

语法如下：

$(".test")

实例

用户点击按钮后所有带有 class="test" 属性的元素都隐藏：

实例

```
$(document).ready(function(){  $("button").click(function(){    $(".test").hide();  });});
```

------

**四，更多选择器说明**

![](/27.png)

# Jquery事件

**什么是事件？**

页面对不同访问者的响应叫做事件。

事件处理程序指的是当 HTML 中发生某些事件时所调用的方法。

实例：

1. 在元素上移动鼠标。
2. 选取单选按钮
3. 点击元素

在事件中经常使用术语"触发"（或"激发"）例如： "当您按下按键时触发 keypress 事件"。

常见 DOM 事件

![](/28.png)

**一，简单用法**

在 jQuery 中，大多数 DOM 事件都有一个等效的 jQuery 方法。

页面中指定一个点击事件：

```js
$("p").click()
```

下一步是定义什么时间触发事件，你可以通过一个事件函数实现：

```
$("p").click(function(){
	// 动作触发后执行的代码!
});
```

**二，常用的 jQuery 事件方法**

 要想使用事件是必须使用文档就绪的方法的

$(document).ready()

$(document).ready() 方法允许我们在文档完全加载完后执行函数。该事件方法在 jQuery 语法 章节中已经提到过。

1，单击事件 click()

click() 方法是当按钮点击事件被触发时会调用一个函数。

该函数在用户点击 HTML 元素时执行。

在下面的实例中，当点击事件在某个 <p> 元素上触发时，隐藏当前的 <p> 元素：

实例

```js
$("p").click(function(){
	$(this).hide();
)};
```

2，双击事件 dblclick()

当双击元素时，会发生 dblclick 事件。

dblclick() 方法触发 dblclick 事件，或规定当发生 dblclick 事件时运行的函数：

实例

```js
$("#p1").mouseenter(function(){
 alert('您的鼠标移到了 id="p1" 的元素上!');
});

```

4，鼠标移出事件 mouseleave()

当鼠标指针离开元素时，会发生 mouseleave 事件。

mouseleave() 方法触发 mouseleave 事件，或规定当发生 mouseleave 事件时运行的函数：

实例

```js
$("#p1").mouseleave(function(){
	alert("再见，您的鼠标离开了该段落");
})
```

5，鼠标按下事件 mousedown() 

当鼠标指针移动到元素上方，并按下鼠标按键时，会发生 mousedown 事件。

mousedown() 方法触发 mousedown 事件，或规定当发生 mousedown 事件时运行的函数：

实例

```js
$("#p1").mousedown(function(){

    alert("鼠标在该段落上按下！");
});

```

6，鼠标松开事件 mouseup()

当在元素上松开鼠标按钮时，会发生 mouseup 事件。

mouseup() 方法触发 mouseup 事件，或规定当发生 mouseup 事件时运行的函数：

实例

```js
$("#p1").mouseup(function(){
	alert("鼠标在段落上松开");
})
```

7，鼠标悬停事件hover()

hover()方法用于模拟光标悬停事件。

当鼠标移动到元素上时，会触发指定的第一个函数(mouseenter);当鼠标移出这个元素时，会触发指定的第二个函数(mouseleave)。

实例

```js
$("#p1").hover(
	function(){
        alert("你进入了p1");
    }
    
    function(){
    	alert("你离开了p1");
	}	
);
```

8，元素得到焦点事件 focus()

当元素获得焦点时，发生 focus 事件。

当通过鼠标点击选中元素或通过 tab 键定位到元素时，该元素就会获得焦点。

focus() 方法触发 focus 事件，或规定当发生 focus 事件时运行的函数：

实例

```js
$("input").focus(function(){
  $(this).css("background-color","#cccccc");
});
```

9，元素失去焦点事件blur()

当元素失去焦点时，发生 blur 事件。

blur() 方法触发 blur 事件，或规定当发生 blur 事件时运行的函数：

实例

```js
$("input").blur(function(){

  $(this).css("background-color","#ffffff");

});
```

**三，事件的绑定与解绑**

在开发中，有时候需要动态绑定一些事件，不用之后要解绑事件，如何做呢？

1，绑定

```js
function test() {
   var btn = $("#btn");
	btn.bind("click", function() {

    alert("点我干什么" + Math.random());

})

//  btn.one("click", function() {
//  alert("我只被触发一次" + Math.random());;
//          
   });
}
```
2 解绑

```js
function testUn(){
	var btn = $("#btn");
    btn.unbild("click");
}
```

3 触发

```js
function testCf(){
	var btn = $("#btn");
	btn.click();
}
```

4 jq绑定

```js
function testBd() {
    $("#btn").click(function(){
        alert("哈哈哈哈");
    })
}
```

实例

```php+HTML
<!DOCTYPE html>

<html>

<head>

    <meta charset="utf-8">

    <title></title>

    <script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript">

        function test() {

            var btn = $("#btn");

            btn.bind("click", function () {

                alert("点我干什么" + Math.random());

            });

            //              btn.one("click", function() {

            //                  alert("我只被触发一次" + Math.random());;

            //              });

        }
        function testUn() {
            var btn = $("#btn");
            btn.unbind("click");
        }

        function testCf() {

            var btn = $("#btn");

            btn.click();

        }
        function testBd() {
            $("#btn").click(function () {

                alert(":哈哈哈哈哈");
            });

        }

    </script>

</head>

<body>

    <h1>操作事件</h1>

    <input type="button" value="测试事件(添加)" onclick="test();" />

    <input type="button" value="测试事件(解绑)" onclick="testUn();" />

    <input type="button" value="测试事件(触发)" onclick="testCf();" />

    <input type="button" value="测试事件(绑定)" onclick="testBd();" />

    <hr />

    <input type="button" value="点我啊" id="btn" />

</body>

</html>
```

