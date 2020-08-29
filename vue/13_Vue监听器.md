---
typora-root-url: images
---

## Vue 监听器

> `watch` : 在vue中表示监听的意思 , 我们可以使用watch来响应数据的变化

> 需求 : 
>
> ​		定义三个数 firstNumber , lastNumber , fullNumber. 当firstNumber和lastNumber发生改变时 , fullNumber也随之发生改变

### 方式一 : 事件绑定

![](20203301433.gif)

```vue
<body>

  <div id="app">
    <input type="text" v-model="firstNumber" @keyup="handlerFullName">
    <input type="text" v-model="lastNumber" @keyup="handlerFullName">
    <input type="text" v-model="fullNumber">
  </div>

  <script>
    new Vue({
      el: "#app",
      data: {
        firstNumber: '',
        lastNumber: '',
        fullNumber: ''
      },
      methods: {
        handlerFullName() {
          this.fullNumber = this.firstNumber + this.lastNumber
        }
      }

    })
  </script>
</body>
```



### 方式二 : 使用监听器

> `watch` : 监听器 , 可以监听某个属性.
>
> 基本格式 : function(newVal , oldVal)

![](20203301437.gif)

```vue
<body>

  <div id="app">
    <input type="text" v-model="firstNumber">
    <input type="text" v-model="lastNumber" >
    <input type="text" v-model="fullNumber">
  </div>

  <script>
    new Vue({
      el: "#app",
      data: {
        firstNumber: '',
        lastNumber: '',
        fullNumber: ''
      },
      watch:{
        'firstNumber' : function(newVal , oldVal){
          this.fullNumber = newVal + this.lastNumber
        },
        'lastNumber' : function(newVal , oldVal){
          this.fullNumber = newVal + this.firstNumber
        }
      }

    })
  </script>
</body>
```

