---
typora-root-url: images
---

## Vue路由

> 参考文档 : https://www.cnblogs.com/avon/p/5943008.html
>
> vue的单页面应用是基于**路由**和**组件**的 , **路由用于设定访问路径 , 并将路径和组件映射起来**.



### 路由的基本使用

<img src="/341820-20160721065510091-544517297.png" style="float:left; width:450px;"/>

**第一步 : 创建组件**

```vue
<script>
    var login = {
        template: '<p>我是登录组件</p>'
    }
    var register = {
        template: '<p>我是注册组件</p>'
    }

    var vue = new Vue({
        el: "#app",
        data: {

        }
    })
</script>
```



**第二步 : 创建Router**

> 导入 `vue-router-3.0.1.js`包
>
> `VueRouter` :  创建一个`VueRouter`实例对象
>
> `routes` : routes中定义了路由的规则
>
> `path` : 表示路由的url.
>
> `redirect` : 就是重定向，访问path时，会被重定向到redirect指定的路由。
>
> `component` : 表示路由要跳转的组件
>
> `router-link` : 控制组件的切换. 内容会默认的被渲染成<a/>标签
>
> `tag` : 指定`router-link`被渲染成那种标签
>
> `router-view` : 相当于一个占位符 , 当组件进行切换时 , 该路由会匹配到相应的组件

```vue
<div id="app">
    <!-- 
		router-lin : 控制组件的切换 
		tag : 指定被渲染成那种标签
	-->
    <router-link to="/login" tag="button">登录</router-link>
    <router-link to="/register">注册</router-link>

    <transition name="component">
        <!-- 占位符 -->
      <router-view></router-view>
    </transition>
  </div>

  <script>
    var login = {
      template: '<p>我是登录组件</p>'
    }
    var register = {
      template: '<p>我是注册组件</p>'
    }

    let routerObj = new VueRouter({ // 创建一个VueRouter实例对象
      routes: [ // 定义规则
        { path: '/', redirect: '/login' }, // path : 路由的url , redirect : 重定向的指定路由
        { path: '/login', component: login }, // component : 跳转的组件
        { path: '/register', component: register }
      ]
    })

    var vue = new Vue({
      el: "#app",
      data: {

      },
      router: routerObj
    })
  </script>
</body>
```



**第三步 : 添加动画**

```css
<style>
    /* v-enter 这是个时间点，是进入之前，元素的起始状态，此时还没有进入 */
    /* v-leave-to 这是个时间点，是动画离开之后，元素的终止状态，此时，元素 动画已经结束了 */
    .component-enter,
    .component-leave-to {
        opacity: 0;
        transform: translateX(50px);
    }

    /* v-enter-active 入场动画的时间段 */
    /* v-leave-active 离场动画的时间段 */
    .component-enter-active,
    .component-leave-active {
        transition: all 0.5s ease;
    }
</style>
```

![](20203292305.gif)



### 路由的传参

> 方式一 : 直接跟在url路径后面. /login?id=XX&name=XX
>
> 方式二 : 使用restful风格. /register/id/name
>
> `this.$route` : 获取路由对象.
>
> * `query` : 适用于?后面拼接的参数
> * `params` : 适用于/

```vue
<body>
  <div id="app">

    <router-link to="/login?id=123&name=张三" tag="button">登录</router-link>
    <router-link to="/register/456/李四">注册</router-link>

    <transition name="component" mode="out-in">
      <router-view></router-view>
    </transition>
  </div>

  <script>
    var login = {
      template: '<p>我是登录组件 - ->  {{$route.query.id}} , {{$route.query.name}}</p>',
      created() {
          // 使用this.$route获取路由对象
          // query只适用于?后面的参数
        console.log("登录 : id :" + this.$route.query.id)
        console.log("登录 : name :" + this.$route.query.name)
      }
    }
    var register = {
      template: '<p>我是注册组件 - -> {{$route.params.id}} , {{$route.params.name}}</p>',
      created() {
          // param只适用于/后面的参数
        console.log("注册 : id :" + this.$route.params.id)
        console.log("注册 : name :" + this.$route.params.name)
      }
    }

    let routerObj = new VueRouter({
      routes: [
        { path: '/', redirect: '/login' },
        { path: '/login', component: login },
        { path: '/register/:id/:name', component: register }
      ]
    })

    var vue = new Vue({
      el: "#app",
      data: {

      },
      router: routerObj
    })
  </script>
</body>
```

![](20203292345.gif)



### 路由的嵌套

```vue
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="lib/vue-2.4.0.js"></script>
        <script src="lib/vue-router-3.0.1.js"></script>
        <style>
            /* v-enter 这是个时间点，是进入之前，元素的起始状态，此时还没有进入 */
            /* v-leave-to 这是个时间点，是动画离开之后，元素的终止状态，此时，元素 动画已经结束了 */
            .component-enter,
            .component-leave-to {
                opacity: 0;
                transform: translateX(50px);
            }

            /* v-enter-active 入场动画的时间段 */
            /* v-leave-active 离场动画的时间段 */
            .component-enter-active,
            .component-leave-active {
                transition: all 0.5s ease;
            }
        </style>
    </head>

    <body>
        <div id="app">
            <router-link to="/login" tag="button">登录</router-link>

            <transition name="component" mode="out-in">
                <router-view></router-view>
            </transition>
        </div>

        <template id="login">
			<div>
                <p>我是登录组件</p>
                <router-link to="/login/loginByPassword" tag="button">账号密码登录</router-link>
                <router-link to="/login/loginByWechat">微信登陆</router-link>
   				<router-view></router-view>
            </div>
        </template>


        <script>
            // 第一步创建组件
            var login = {
                template: "#login"
            }

            var loginByPassword = {
                template: "<p>账号密码登录</p>"
            }

            var loginByWechat = {
                template: "<p>微信登陆</p>"
            }

            // 第二步 : 创建路由
            let routerObj = new VueRouter({
                routes: [
                    { path: "/", redirect: "/login" },
                    {
                        path: "/login",
                        component: login,
                        // children属性用于指定子路由，通过子路由可以实现路由的嵌套. 
                        // 里面定义的内容和外面没有区别
                        children: [ 
                            { path: 'loginByPassword', component: loginByPassword },
                            { path: 'loginByWechat', component: loginByWechat }
                        ]
                    }
                ]
            })

            var vue = new Vue({
                el: "#app",
                data: {

                },
                router: routerObj
            })
        </script>
    </body>

</html>
```

![](/20203291229.gif)