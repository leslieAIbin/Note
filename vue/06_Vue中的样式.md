---
typora-root-url: images
---

## Vue中的样式

> 常见的样式 : 
>
> ① : 行内样式
>
> ② : 在style中书写样式

### 实例一 

> 使用v-bind给class设置一个数组样式

#### 代码

```html
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="lib/vue-2.4.0.js"></script>
        <style>
            .red {
                color: salmon;
            }

            .size {
                font-size: 20px;
            }
        </style>
    </head>

    <body>
        <div id="app">
            <div :class="['red','size']">我是一个div</div>
        </div>

        <script>
            new Vue({
                el: "#app"
            })
        </script>
    </body>

</html>
```

#### 截图

<img src="/image-20200324154357773.png" style="float:left; width:500px"/>



### 实例二

> 使用三元运算符来控制样式

#### 代码

```html
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="lib/vue-2.4.0.js"></script>
        <style>
            .red {
                color: salmon;
            }

            .size {
                font-size: 20px;
            }
        </style>
    </head>

    <body>
        <div id="app">
            <div :class="flag?'size':'red'">我是一个div</div>
        </div>

        <script>
            new Vue({
                el: "#app",
                data: {
                    flag: true
                }
            })
        </script>
    </body>

</html>
```

#### 截图

> 当flag 为true时

<img src="/image-20200324154816642.png" style="float:left; width:500px"/>

> 当flag 为false时

![image-20200324154944185](/image-20200324154944185.png)



### 实例三

> 通过点击事件改变div的颜色 , 大小 , 背景颜色

#### 代码

```html
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="lib/vue-2.4.0.js"></script>
        <style>
            .red {
                color: salmon;
            }

            .size {
                font-size: 20px;
            }

            .back {
                background-color: rgb(175, 244, 96);
            }
        </style>
    </head>

    <body>
        <div id="app">
            <div :class="classObj">我是一个div</div>
            <button @click="changeStyle">点击我</button>
        </div>

        <script>
            new Vue({
                el: "#app",
                data: {
                    classObj: {
                        'red': true,
                        'size': true,
                        'back': true
                    }
                },
                methods: {
                    changeStyle() {
                        this.classObj.red = !this.classObj.red,
                            this.classObj.size = !this.classObj.size,
                            this.classObj.back = !this.classObj.back
                    }
                }
            })
        </script>
    </body>

</html>
```

#### 截图

![20203241600](/20203241600.gif)