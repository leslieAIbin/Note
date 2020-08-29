---
typora-root-url: images
---

## Webpack 之 Vue

### 准备工作

> 将原来的src文件进行一个拷贝

<img src="/image-20200331134607390.png" style="float:left"/>



### 开发步骤

**第一步 : 安装基本包**

![image-20200331134934809](/image-20200331134934809.png)



**第二步 : 安装vue**

> npm i vue

![image-20200331135213169](/image-20200331135213169.png)



**第三步 : 修改`index.html` 和 `main.js` , 并创建`login.vue`**

`index.html`

```html
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>

    <body>
        <div id="app">
            {{msg}}
            <login></login>
        </div>
    </body>

</html>
```

`login.vue`

> export default <==> new Vue(); 相当于创建一个Vue的实例
>
> scoped : 这个标签只适用于<style/> , 这个样式只有在本组件有用 , 否则会产生样式污染

```vue
<template>
	<div>
   		<h1>我是登陆组件 , 在.vue文件中 - -> {{msg}}</h1>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                msg: "123"
            };
        },
        methods: {},
        filters: {}
    };
</script>

<style scoped>
</style>
```

`main.js`

> render: c => c(login) 相当于
>
> render : function (createElements){
>
> ​	return createElements(login);
>
> }

```js
/**
 * 导入资源包
 */

// 在webpack中使用vue
import Vue from 'vue'

import login from './login.vue'

var vm = new Vue({
  el: "#app",
  render: c => c(login)
})
```



**第四步 : 安装`vue-loader`和`vue-template-compiler`**

> 命令 : 
>
> vue-loader : npm i vue-loader --save-dev
>
> vue-template-compiler : npm i vue-template-compiler --save-dev

![image-20200331151712010](/image-20200331151712010.png)



**第五步 : 在`webpack.config.js`中配置**

* 导入`vue-loader`

```js
// 导入VueLoaderPlugin
var VueLoaderPlugin = require('vue-loader/lib/plugin');
```

* 配置插件

```js
plugins: [ //配置插件
    new htmlWebpackPlugin({
        // index.html模板路径
        template: path.resolve(__dirname, 'src/index.html'),
        // 自动生成html文件名称
        filename: 'index.html'
    }),
    new VueLoaderPlugin()
]
```

* 配置第三方加载器

```js
module: { // 配置第三方模块加载器
    // 第三方模块的匹配规则
    rules: [
        { test: /\.css$/, use: ['style-loader', 'css-loader'] },
        { test: /\.vue$/, use: ['vue-loader'] }
    ]
}
```



**第六步 : 启动项目**

> 命令 : npm run dev

<img src="/image-20200331152608608.png" style="float:left;width:350px"/>

### export default

> ① : 向外暴露的成员，可以用任意的变量接收
>
> ② : 在一个模块中，export default只允许向外暴露一次
>
> ③ : 在一个模块中, 可以同时使用export default和export
>
> export 
>
> ES6中，使用 `import 模块名称 from '模块标识符'`和  `import '模块路径'` 两种方式导入模块.



### webpack对路由的使用

> 需求 : 使用webpack中的路由 , 实现登录组件开发

![](20203311616.gif)

**第一步 : 创建view文件夹 , 并在下面创建`PasswordLogin.vue` 和 `WechatLogin.vue`**

<img src="/image-20200331155403539.png" style="float:left;width:350px"/>

`PasswordLogin.vue`

```vue
<template>
  <div>
    <h4>账号/密码登录</h4>
  </div>
</template>

<script>
</script>

<style scoped>
</style>
```

`WechatLogin.vue`

```vue
<template>
  <div>
    <h4>Wechat登录</h4>
  </div>
</template>

<script>
</script>

<style scoped>
</style>
```



**第二步 : 创建`App.vue`**

<img src="/image-20200331155628670.png" style="float:left;width:300px"/>

```vue
<template>
	<div>
    	<h3>这是App组件</h3>
    </div>
</template>

<script>
</script>

<style scoped>
</style>
```



**第三步 : 安装`vue-router`**

> 指令 : npm i vue-router

![image-20200331155911248](/image-20200331155911248.png)



**第四步 : 修改`App.vue`**

```vue
<template>
	<div>
        <h3>这是App组件</h3>
        <router-link to="loginByPassword">账号/密码登录</router-link>
        <router-link to="loginByWechat">微信登录</router-link>
        <router-view></router-view>
    </div>
</template>

<script>
</script>

<style scoped>
</style>
```



**第五步 : 修改`main.js`**

> ① : 导入`vue-router`
>
> ② : 引入`PasswordLogin.vue`和`WechatLogin.vue`组件
>
> ③ : 实例化VueRouter()

```js
/**
 * 导入资源包
 */

// 在webpack中使用vue
import Vue from 'vue'

// 导入App.vue组件
import app from './App.vue'

// 使用vue-router
import VueRouter from 'vue-router'

Vue.use(VueRouter)
// 导入PasswordLogin 和 Wechat组件
import PasswordLogin from './view/PasswordLogin.vue'
import WechatLogin from './view/WechatLogin.vue'

// 实例化VueRouter
var router = new VueRouter({
    routes: [
        { path: '/loginByPassword', component: PasswordLogin },
        { path: '/loginByWechat', component: WechatLogin }
    ]
})

var vm = new Vue({
    el: "#app",
    render: c => c(app),
    router
})
```



**第六步: 将组件进行抽象**

> ① : 新建router文件夹. 并在下面创建index.js
>
> ② : 将文件抽象到index.js中

<img src="/image-20200331163021106.png" style="float:left; width:300px"/>



`index.js`

```js
import Vue from 'vue'

// 使用vue-router
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 导入PasswordLogin 和 Wechat组件
import PasswordLogin from '../view/PasswordLogin.vue'
import WechatLogin from '../view/WechatLogin.vue'

// 实例化VueRouter
var router = new VueRouter({
  routes: [
    { path: '/loginByPassword', component: PasswordLogin },
    { path: '/loginByWechat', component: WechatLogin }
  ]
})

export default router
```

`main.js`

```js
/**
 * 导入资源包
 */

// 在webpack中使用vue
import Vue from 'vue'

// 导入App.vue组件
import app from './App.vue'

// 导入index.js
import router from './router/index.js'

var vm = new Vue({
  el: "#app",
  render: c => c(app),
  router
})
```



### webpack对静态资源的处理

> 图片,文字处理 : npm i --save-dev url-loader 

![image-20200331164307010](/image-20200331164307010.png)



在`webpack.config.js`中的`module`进行配置

```js
module: { // 配置第三方模块加载器
    // 第三方模块的匹配规则
    rules: [
        { test: /\.css$/, use: ['style-loader', 'css-loader'] },
        { test: /\.vue$/, use: ['vue-loader'] },
        // 处理图片路径url。limit给定图片的大小，如果我们的图片大于等于给定的值，则不会被转为base64，否则会转
        { test: /\.(jpg|png|gif|bmp|jpeg)$/, use: 'url-loader?limit=7631&name=[hash:8]-[name].[ext]' }, 
        { test: /\.(ttf|eof|svg|woff|woff2)$/, use: 'url-loader' },
    ]
}
```

