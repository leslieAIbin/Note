---
typora-root-url: images
---

## Vue组件

> 详细文档 : https://cn.vuejs.org/v2/guide/components-registration.html



### 简介

> 组件 : 可以将模块进行一个拆分 , 不同的组件负责不同的功能模块.
>
> **模块化** : 模块化是从代码的角度去分析 , 方便分层开发 , 保证每个模块职责单一.
>
> **组件化** : 组件化是从界面的角度区划分 , 如分页组件 , 轮播组件.
>
> ​		组件中也可以拥有自己的**data**和**methods**。组件的存在是为了复用性，定义了一个组件后，可能会有多个地方使用到该组件。
>
> ​		如果按照data: {}的写法，多个组件会复用同一个data，降低组件的复用性，而定义为function则不会。



### 使用组件

#### 方式一

> 使用**Vue.extend**来组件组件

<img src="/image-20200325230021996.png" style="float:left; width:500px;"/>

```html
<body>
    <div id="app">
        <my-component></my-component>
    </div>

    <template>

    </template>

    <script>
        // 1 使用Vue.extend来组件组件
        // 按照java的开发思想，变量名往往是驼峰规则。
        // vue定义组件时可以使用驼峰规则，但是，使用组件时如果存在驼峰，
        // 应当全部改为小写，并将每个单词用 - 连接
        Vue.component('myComponent', Vue.extend({
            // template就是组件要展示的内容，可以是html标签
            template: "<h3>这是用extend组件的组件</h3>"
        }))

        var vue = new Vue({
            el: '#app',
            data: {
            }
        })
    </script>
</body>
```



#### 方式二

> 使用全局注册

<img src="/image-20200325231938172.png" style="float:left; width:600px;"/>

```html
<body>
    <div id="app">
        <my-component></my-component>
    </div>

    <template>

    </template>

    <script>
        Vue.component('myComponent', {
            // template就是组件要展示的内容，可以是html标签
            template: "<h3>不使用extend组件的组件</h3>"
        })

        var vue = new Vue({
            el: '#app',
            data: {
            }
        })
    </script>
</body>
```



#### 方式三

<img src="/image-20200325230815578.png" style="float:left; width:500px;"/>

```html
<body>
    <div id="app">
        <my-component></my-component>
    </div>

    <template id="temp">
        <h3>组件开发</h3>
    </template>

    <script>
        // 3.使用template
        Vue.component('myComponent', {
            template: '#temp'
        })

        var vue = new Vue({
            el: '#app',
            data: {
            }
        })
    </script>
</body>
```



### 组件中的data()和methods()

> 需求 : 使用组件通过点击按钮 , 实现数字的增加

![20203252327](/20203252327.gif)

```html
<body>
    <div id="app">
        <my-component></my-component>
    </div>

    <template id="temp">
        <div>
            count = {{count}}<br />
            <button @click="add">点击</button>
        </div>
    </template>

    <script>
        Vue.component('myComponent', {
            template: "#temp",
            // ① : Vue 组件中的data必须是一个方法，并且返回一个对象
            // ② : 一次定义 , 多处使用
            data() {
                return {
                    count: 0
                }
            },
            methods: {
                add() {
                    this.count++
                }
            }
        })

        var vue = new Vue({
            el: '#app',
            data: {
            }
        })
    </script>
</body>
```



### 私有组件

![image-20200325234219029](/image-20200325234219029.png)

```html
<body>
    <div id="app">
        <my-component></my-component>
    </div>

    <template id="temp">
        <div>
            我是私有组件
        </div>
    </template>

    <script>
        var vue = new Vue({
            el: '#app',
            count: 0,
            data: {
            },
            components: {// 定义私有组件的方式：
                // 组件名称建议用引号包起来。如果不包起来，在严格语法情况下会报警告
                // ，需要改成-。而方法、变量中是不允许有横线的，就会报错、
                'myComponent': {
                    template: '#temp'
                }
            }
        })
    </script>
</body>
```



### 组件的切换

> 需求 : 
>
> ① : 当点击登录按钮 , 则显示登陆界面.
>
> ② : 当点击注册按钮 , 则显示注册界面.

#### 方式一 

![](/20203261207.gif)

```html
<body>
    <div id="app">
        <button @click="flag=true">登录</button>
        <button @click="flag=false">注册</button>
        <login v-if="flag"></login>
        <register v-else></register>
    </div>

    <script>
        Vue.component('login', {
            template: '<p>我是登录组件</p>'
        })

        Vue.component('register', {
            template: '<p>我是注册组件</p>'
        })
        var vue = new Vue({
            el: '#app',
            data: {
                flag: true
            }
        })
    </script>
</body>
```



#### 方式二

![](20203261235.gif)

```html
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>组件</title>
        <script src="lib/vue-2.4.0.js"></script>
        <style>
            /* component-enter 这是个时间点，是进入之前，元素的起始状态，此时还没有进入 */
            /* 
            component-leave-to 这是个时间点，是动画离开之后，
            元素的终止状态，此时，元素 动画已经结束了 */
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
            <button @click="componentName='login'">登录</button>
            <button @click="componentName='register'">注册</button>

            <!-- transition提供了model属性，设置组件切换时的模式 -->
            <transition name="component" mode="out-in">
                <!-- 
                    Vue提供了component，来展示对应名称的组件。
                    这是个占位符，使用:is来指定要展示的组件名称
                -->
                <component :is="componentName"></component>
            </transition>
        </div>

        <script>
            Vue.component('login', {
                template: '<p>我是登录组件</p>'
            })

            Vue.component('register', {
                template: '<p>我是注册组件</p>'
            })

            new Vue({
                el: '#app',
                data: {
                    componentName: 'login'
                }
            })
        </script>
    </body>

</html>
```



### 父组件向子组件传递值

![](20203261308.gif)

```html
<body>
    <div id="app">
        <!-- 父组件向子组件传值. 属性名称 , 也需要使用- -->
        <my-component :parent-msg="msg"></my-component>
    </div>

    <template id="temp">
        <div>
            <div>{{parentMsg}}</div>
            <button @click="checkgeMsg">修改</button>
        </div>
    </template>

    <script>
        new Vue({
            el: "#app",
            data: {
                msg: "父组件 : parent-msg"
            },
            components: {
                'my-component': {
                    template: "#temp",
                    methods: {
                        checkgeMsg() {
                            this.parentMsg = "我被修改了"
                        }
                    },
                    // props中的数据，都是通过父组件传递给子组件的。
                    // props中的数据都是只读的，无法去赋值
                    // props使用数组是非常不标准的写法。建议使用对象，并给每一个prop声明类型和默认值
                    props: {
                        parentMsg: { 
                            type: String,
                            default: null
                        }
                    }
                }
            }
        })
    </script>
</body>
```



### 父组件向子组件传递方法

![](20203261325.gif)

```html
<body>
    <div id="app">
        {{msg}} <br />
        {{title}}

        <my-component @change="changeMsg"></my-component>
    </div>

    <template id="temp">
        <div>
            <button @click="changeMsg">修改</button>
        </div>
    </template>

    <script>
        new Vue({
            el: "#app",
            data: {
                title: "我是父级组件的标题",
                msg: "我是父级组件的内容"
            },
            methods: {
                changeMsg(msg, title) {
                    this.msg = msg
                    this.title = title
                }
            },
            components: {
                'my-component': {
                    template: "#temp",
                    methods: {
                        changeMsg() {
                            // emit 第一个参数是要调用的方法名称
                            this.$emit("change", "我是子级组件的标题", "我是子级组件的内容")
                        }
                    }
                }
            }
        })
    </script>
</body>
```



### 父级组件调用子组件的方法

![](20203261341.gif)

```html
<body>

    <div id="app">
        <button @click="handlerChildFunction">我是父级组件 : 调用子集组件方法</button>
        <my-component ref="parent"></my-component>
    </div>

    <template id="temp">
        <div></div>
    </template>

    <script>
        new Vue({
            el: "#app",
            methods: {
                handlerChildFunction() {
                    // 父组件调用子组件方法。，直接使用ref去调用方法。方法的用法和子组件中一模一样
                    this.$refs.parent.childFunction()
                }
            },
            components: {
                'my-component': {
                    template: "#temp",
                    methods: {
                        childFunction() {
                            console.log("我是子级组件 , 调用成功")
                        }
                    }
                }
            }
        })
    </script>
</body>
```

