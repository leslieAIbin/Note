---
typora-root-url: images
---

## Vue入门之HelloWorld

> 需求 : 
>
> 使用Vue格式在html中打印出HelloWorld

### 导入js包

> 版本 : vue-2.4.0.js

![1584941642091](/1584941642091.png)

### 创建HTML文件

> vscode快速创建html : ! + tab

```html
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>HelloWorld</title>
  <!-- 导入vue包 -->
  <script src="lib/vue-2.4.0.js"></script>
</head>

<body>
  <div id="app">
    {{msg}} <br />
    {{name}}
  </div>

  <script>
    // 2.我们导入了vue的包之后，在浏览器的内存中，我们就多了一个Vue的构造函数。注意大小写
    var vue = new Vue({
      el: '#app', // 表示我们new的这个vue实例，控制页面上的哪个区域
      data: { // data是MVVM中的m，专门存放每个页面的数据。
        msg: 'hello vue',
        name: 'wickson'
      }
    })
  </script>
</body>

</html>
```



### 进行访问

<img src="/1584942772077.png" style="float:left; width:200px;"/>