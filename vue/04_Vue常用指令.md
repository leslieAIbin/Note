---
typora-root-url: images
---

## Vue常用指令

> vue.js官方给自己的定为是数据模板引擎，并给出了一套渲染数据的指令.

* v-if
* v-show
* v-for
* v-text
* v-html
* v-clock
* v-bind
* v-on
* v-model



### v-if , v-show指令

> v-if = "expression" : 根据表达式的真假来删除和插入元素
>
> v-show = "expression" : 不会每次都去删除和创建DOM元素 , 而是通过dispaly:none将元素隐藏起来

#### v-if 例子

```html
<body>
  <div id="app">
    <h1 v-if="yes">yes!</h1>
    <h1 v-if="age > 16">age : {{age}}</h1>
    <h1 v-if="name.indexOf('i') > 0">name : {{name}}</h1>
  </div>

  <script>
    new Vue({
      el: '#app',
      data: {
        yes: false, // 如果是true则显示内容 , false则不会显示
        age: 18,
        name: 'wickson'
      }
    })
  </script>
</body>
```

##### 运行截图

<img src="/1584942772077.png" style="float:left; width:200px"/>

#### v-show 例子

```html
<div id="app">
    <div v-show="content1">
        我是v-show
    </div>
    <button @click="handler">点击我</button>
</div>
<script>
    new Vue({
        el: '#app',
        data: {
            content1: false
        },
        methods: {
            handlerContent1() {
                this.content1 = !this.content1
            }
        }
    })
</script>
```

##### 运行截图

![20203241618](/20203241618.gif)



### v-for 指令

> v-for = "item in items" : 基于一个数组渲染一个列表

#### 例子

```html
<div id="app">
    <table style="width: 400px; height: 600px;" border="1" cellspacing="0">
        <thead>
            <tr>
                <th>name</th>
                <th>age</th>
            </tr>

        </thead>
        <tbody>
            <tr v-for = "item in items">
                <td align="center">{{item.name}}</td>
                <td align="center">{{item.age}}</td>
            </tr>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    var app = new Vue({
        el: '#app',
        data: {
            items: [
                { name: 'well', age: '20' }, 
                { name: 'good', age: '19' }, 
                { name: 'nice', age: '18' }, 
                { name: 'ok', age: '17' }
            ]
        }
    })
</script>
```

#### 运行截图

<img src="/1584948287677.png" style="float:left; width:300px;"/>



### v-text , v-html , v-clock指令

> v-text : 会覆盖原有标签中的内容. 将data中的数据作为字符串去处理
>
> v-html : 会见data作为html标签去渲染
>
> v-clock : 占位符指令 , 会替换掉自己的这个占位 , 不会把整个元素清空

#### 例子

```html
<div id="app">
    <div v-clock>{{msg}} 你好</div>
    <div v-text="msg1">你好</div>
    <div v-html="msg2"></div>
</div>

<script type="text/javascript">
    var app = new Vue({
        el: '#app',
        data: {
            msg: "我是v-clock",
            msg1: "我是v-text",
            msg2: "<div>我是v-html</div>"
        }
    })
</script>
```

#### 界面截图

<img src="/1584949143857.png" style="float:left; width:300px;"/>

### v-bind , v-on 指令

> v-bind : Vue中提供用户绑定属性的指令. 也可以简写成:
>
> v-on : Vue提供的事件绑定指令. 可以简写成@

#### 例子

```html
<div id="app">
    <!-- 
        v-bind : 用户绑定属性的指令. 也可以简写成 :
        <button :title="msg">这是一个按钮</button>
    -->
    <button v-bind:title="msg">这是一个按钮</button>

    <!-- 
        v-on : 事件绑定指令. 可以简写为@
        <button @:click="show">点击我</button>
    -->
    <button v-on:click="show">点击我</button>
</div>

<script>
    var vue = new Vue({
        el: "#app",
        data: {
            msg: "我是一个按钮"
        },
        methods: {
            show() {
                alert("点一下玩一年");
            }
        }
    })
</script>
```

#### 运行截图

![1584952616056](/1584952616056.png)



### v-model 指令

> v-model : 数据的双向绑定 , **只能用于表单元素**. 一方被修改之后另一方也会同步修改
>
> v- bind : 数据的单向绑定. 当model中数据被修改是 , bind绑定的数据会被修改. 而bind绑定的位置改变model则不会被修改

#### 例子

```html
<div id="app">
    <h5>{{msg}}</h5>
    <div>
        我是v-model<br />
        <input type="text" name="" id="" v-model:value="msg">
    </div>
    <div>
        我是v-bind<br />
        <input type="text" name="" id="" v-bind:value="msg">
    </div>
    <button v-on:click="changeMsg">点击我</button>
</div>

<script>
    var vue = new Vue({
        el: "#app",
        data: {
            msg: "我是一个按钮"
        },
        methods: {
            changeMsg() {
                this.changeMsg1()
            },
            changeMsg1() {
                this.msg = "我现在不是按钮了"
            }
        }
    })
</script>
```

#### 运行截图

<img src="/201910241443.gif" style="float:left; width:400px"/>