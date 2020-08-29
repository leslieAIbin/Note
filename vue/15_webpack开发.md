---
typora-root-url: images
---

## WebPack开发

> 详细文档 : https://www.jianshu.com/p/42e11515c10f
>
> ​		WebPack可以看做是**模块打包机**：它做的事情是，分析你的项目结构，找到JavaScript模块以及其它的一些浏览器不能直接运行的拓展语言（Scss，TypeScript等），并将其转换和打包为合适的格式供浏览器使用。



### 初始Webpack

**第一步 : 新建src**

<img src="/image-20200330155438073.png" style="float:left" />



**第二步 : 初始化项目**

> npm init
>
> 完成之后会自动创建一个`package.json`文件

<img src="/image-20200330160321248.png" style="float:left; width:600px;"/>



**第三步 : 安装webpack 和 webpack-cli**

> 安装webpack的几种方式. 
>
> 安装 : i <==> install
>
> 卸载 : uninstall
>
> 全局安装(任何项目都可以用)：npm i webpack -g 
>
> 局部安装(开发环境安装) : npm i webpack -save dev

![image-20200330161418307](/image-20200330161418307.png)

> 这时根目录下多了几个文件

![image-20200330161528730](/image-20200330161528730.png)

> 再次安装webpack-cli
>
> 命令 : npm i --save -dev webpack-cli

![image-20200330165539222](/image-20200330165539222.png)



**第四步 : 安装jquery**

> npm i jquery

![image-20200330162144685](/image-20200330162144685.png)

![image-20200330162225705](/image-20200330162225705.png)



**第五步 : 导入jquery**

> ① : 新建index.js文件
>
> ② : 导入jquery

```js
/**
 * 前端项目的入口
 */ 
//导入jquery. 语法 : import 导入 form '模块'
import $ from "jquery"
```

![image-20200330162716803](/image-20200330162716803.png)



**第六步 : 实现各行换色**

> 第一步 : 创建index.html
>
> 第二步 : 进行打包

`index.html`

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>各行换色</title>
        <!-- 
            切记切记切记
            不要再任何地方引入js和scc代码. 因为mian中的代码 , 涉及到es6的新语法 , 浏览器不识别
        -->
    </head>
    <body>
        <li>这是第一个li</li>
        <li>这是第二个li</li>
        <li>这是第三个li</li>
        <li>这是第四个li</li>
        <li>这是第五个li</li>
    </body>
</html>
```

`main.js`

```js
$(function () {
  $("li:odd").css("backgroundColor", "yellow")
  $("li:even").css("backgroundColor", "blue")
})
```

>  进行打包
>
> 命令 :  webpack 目标文件 -o 打包路径.
>
> 安装完成之后依旧打包失败.
>
> 原因 : 版本过高

![image-20200330170651825](/image-20200330170651825.png)

> 解决方案
>
> 使用 : npx webpack 目标文件 -o 打包路径

![image-20200330173010374](/image-20200330173010374.png)



**第七步 : 引入bundle.js. 并访问**

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>各行换色</title>
  <!-- 
    切记切记切记
    不要再任何地方引入js和scc代码. 因为mian中的代码 , 涉及到es6的新语法 , 浏览器不识别
  -->
  <script src="../dist/bundle.js"></script>
</head>
<body>
  <li>这是第一个li</li>
  <li>这是第二个li</li>
  <li>这是第三个li</li>
  <li>这是第四个li</li>
  <li>这是第五个li</li>
</body>
</html>
```

![image-20200330173306331](/image-20200330173306331.png)

> 上诉代码过于复杂 , 每次修改代码的时候都需要进行打包，不太友好.



### webpack.config.js

> 对打包方式进行一个配置

**第一步 : 创建一个webpack.config.js**

```js
// 导入路径处理的模块
var path = require('path');

// 导出一个配置对象 , 将来用于在webpack启动时. 从该文件中读取这个配置对象. 并进行打包
module.exports = {
  // 指定项目的入口文件
  entry: path.resolve(__dirname, "src/main.js"),
  output: {
    // 配置输出路径
    path: path.resolve(__dirname, 'dist'),
    // 匹配输出选项
    filename: 'bundle.js'
  }
}
```



**第二步 : 实时打包文件**

> 安装webpack -dev-server来实现实时打包

![image-20200330181335505](/image-20200330181335505.png)



**第三步 : 开启`webpack-dev-server`**

> 使用命令 : npx webpack-dev-server

![image-20200330181917466](/image-20200330181917466.png)



**第四步 : 进行访问**

> 命令 : npm run dev
>
> 这时 , 并不是我们想要的效果

![image-20200330182405108](/image-20200330182405108.png)

>  解决方案 : 配置package.json , 修改script中的dev

```json
{
    "name": "web",
    "version": "1.0.0",
    "description": "",
    "main": "index.js",
    "scripts": {
        "test": "echo \"Error: no test specified\" && exit 1",
        "dev": "webpack-dev-server --contentBase src"
    },
 ...
}
```



**第五步 : 再次进行访问**

> 上诉问题已解决 , 但是样式失效了

![image-20200330182833343](/image-20200330182833343.png)

> 解决方案 : 只需要修改index.html中的`script`的路径即可

```html
<script src="bundle.js"></script>
```

![image-20200330183125530](/image-20200330183125530.png)

> 这时已经完成了对js的实时更新了



**第六步 : 实现对html的实时更新**

> ①  安装 npm i html-webpack-plugin --save-dev
>
> ②  修改webpack.config.js代码
>
> ③  修改package.json中的dev

* 安装 npm i html-webpack-plugin --save-dev

![image-20200330183911264](/image-20200330183911264.png)



* 修改webpack.config.js代码
  * 导入自动生成HTML文件插件
  * 配置插件
  * 删除`bundle.js` , 这时已经自动引入了

```js
// 导入路径处理的模块
var path = require('path');

// 导入自动生成HTML文件插件
var htmlWebpackPlugin = require('html-webpack-plugin')

// 导出一个配置对象 , 将来用于在webpack启动时. 从该文件中读取这个配置对象. 并进行打包
module.exports = {
  // 指定项目的入口文件
  entry: path.resolve(__dirname, "src/main.js"),
  output: {
    // 配置输出路径
    path: path.resolve(__dirname, 'dist'),
    // 匹配输出选项
    filename: 'bundle.js'
  },
  plugins: [ //配置插件
    new htmlWebpackPlugin({
      // index.html模板路径
      template: path.resolve(__dirname, 'src/index.html'),
      // 自动生成html文件名称
      filename: 'index.html'
    })
  ]
}
```



* 修改package.json中的dev
  * 去掉dev中的 --contentBase src

```json
{
  "name": "web",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev": "webpack-dev-server"
  },
  "author": "wickson",
  "license": "ISC",
  "devDependencies": {
    "html-webpack-plugin": "^4.0.3",
    "webpack": "^4.42.1",
    "webpack-cli": "^3.3.11",
    "webpack-dev-server": "^3.10.3"
  },
  "dependencies": {
    "jquery": "^3.4.1"
  }
}
```



**第七步 : 启动项目 , 并测试**

> 开启命令 : npm run dev

![](20203301850.gif)



**第八步 : 修改package.json. 实现热部署 , 并指定端口**

> 修改package.json中script的dev.
>
> 实现热部署之后页面不会自动修改了 , 需要自己手动刷新

```
"dev": "webpack-dev-server --open --hot --port 8080"
```



### webpack打包css文件

> 步骤 : 
>
> ① : 创建index.css文件
>
> ② : 在main.js中导入文件
>
> ③ : 安装第三方加载器
>
> ④ : 在webpack.config.js中配置第三方模块加载器
>
> 下面代码主要以css文件为主 , 并没有less和scss

* 创建`index.css`文件

```css
ul .first-li {
  font-size: 18px;
}
```

![image-20200330192733071](/image-20200330192733071.png)



* 在main.js中导入文件

  > 注意 : 在webpack中默认只能打包js文件 , 无法处理其他的非js文件. 
  >
  > 如果需要使用 , 这需要导入第三方的loader加载器

`main.js`

```js
/**
 * 前端项目的入口
 */
//导入jquery
import $ from "jquery"

// 导入css
import 'css/index.css'

$(function () {
  $("li:odd").css("backgroundColor", "yellow")
  $("li:even").css("backgroundColor", "pink")
})
```



* 安装第三方插件

  > 命令 : npm i --save-dev style-loader css-loader

![image-20200330194439677](/image-20200330194439677.png)



* 在webpack.config.js中配置第三方模块加载器

```js
// 导出一个配置对象 , 将来用于在webpack启动时. 从该文件中读取这个配置对象. 并进行打包
module.exports = {
  // 指定项目的入口文件
  entry: path.resolve(__dirname, "src/main.js"),
  output: {
    // 配置输出路径
    path: path.resolve(__dirname, 'dist'),
    // 匹配输出选项
    filename: 'bundle.js'
  },
  plugins: [ //配置插件
    new htmlWebpackPlugin({
      // index.html模板路径
      template: path.resolve(__dirname, 'src/index.html'),
      // 自动生成html文件名称
      filename: 'index.html'
    })
  ],
  module: { // 配置第三方模块加载器
    // 第三方模块的匹配规则
    rules: [
      { test: /\.css$/, use: ['style-loader', 'css-loader'] }
    ]
  }
}
```

![image-20200330195458148](/image-20200330195458148.png)

