---
typora-root-url: images
---

## Vue的生命周期

### 图解

<img src="https://cn.vuejs.org/images/lifecycle.png"  style="float:left; width:80%;"/>

### 文字讲解

#### beforeCreate

> **初始化界面前**.
>
> 这个时候只是一个空的Vue()对象 , 并且只有默认的生命周期函数和默认事件.

```html
<body>
    <div id="app">
        <div id="divId">页面还没有渲染 --- {{msg}}</div>
    </div>

    <script>
        var vue = new Vue({
            el: "#app",
            data: {
                msg: "页面渲染完毕"
            },
            methods: {

            },
            filters: {

            },
            beforeCreate() {
                // 这是我们第一个遇到的生命周期函数，实例被创建出来，
                // 还没有data、methods等时，会执行它
                let content = document.getElementById('divId')
                console.log('beforeCreate：', content.innerText)
                // 在js中，null和undefined是不同的含义。null表示有这个对象，
                // 但是这个对象的值是null。undefined表示压根就没有这个对象
                console.log('beforeCreate', this.msg)
            }
        })
    </script>
</body>
```

![image-20200325221055247](/image-20200325221055247.png)



#### create

> **初始化界面后**
>
> 这时的data和method已经被初始化完成.

```html
<body>
    <div id="app">
        <div id="divId">页面还没有渲染 --- {{msg}}</div>
    </div>

    <script>
        var vue = new Vue({
            el: "#app",
            data: {
                msg: "页面渲染完毕"
            },
            methods: {

            },
            filters: {

            },
            created() {
                // 这是我们第一个遇到的生命周期函数，实例被创建出来，
                // 还没有data、methods等时，会执行它
                let content = document.getElementById('divId')
                console.log('beforeCreate：', content.innerText)
                // 在js中，null和undefined是不同的含义。null表示有这个对象，
                // 但是这个对象的值是null。undefined表示压根就没有这个对象
                console.log('beforeCreate', this.msg)
            }
        })
    </script>
</body>
```

![image-20200325221253610](/image-20200325221253610.png)



#### beforMount

> **渲染dom前**
>
> 这时模板已经在内存中编译完成 , 但没有加载到页面中去.

```html
<body>
    <div id="app">
        <div id="divId">页面还没有渲染 --- {{msg}}</div>
    </div>

    <script>
        var vue = new Vue({
            el: "#app",
            data: {
                msg: "页面渲染完毕"
            },
            methods: {

            },
            filters: {

            },
            beforeMount() {
                // Vue实例创建完毕，页面尚未重新渲染
                let content = document.getElementById('divId')
                console.log('beforeMounte', content.innerText)
                console.log('beforeMounte', this.msg)
            }
        })
    </script>
</body>
```

![image-20200325221427466](/image-20200325221427466.png)



#### mounted

> **dom渲染后**
>
> 这时的页面编译并且替换完毕.

```html
<body>
    <div id="app">
        <div id="divId">页面还没有渲染 --- {{msg}}</div>
    </div>

    <script>
        var vue = new Vue({
            el: "#app",
            data: {
                msg: "页面渲染完毕"
            },
            methods: {

            },
            filters: {

            },
            mounted() {
                // 页面渲染完毕
                let content = document.getElementById('divId')
                console.log('mounted', content.innerText)
                console.log('mounted', this.msg)
            }
        })
    </script>
</body>
```

![image-20200325221551881](/image-20200325221551881.png)



#### beforeUpdate

>  **更新数据前**
>
> 当data数据被修改后会进行触发



#### update

> **更新数据后**
>
> 当update被执行到的时候 , 页面中的数据已经和data保持同步



#### beforeDestroy

> **卸载组件前**
>
> 这时Vue的实例已经从运行阶段变成了销毁阶段. 而这时实例身上所有的data , methods , 过滤器 , 指令都处于可用状态



#### destroyed

> **卸载组件后**
>
> 这是Vue的所有组件都不可用了