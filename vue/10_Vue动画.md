---
typora-root-url: images
---

## Vue的过度动画

> 详细文档 : https://cn.vuejs.org/v2/guide/transitions.html
>
> 需求 : 
>
> ① 当点击按钮时 , 会出现一个过度的动画效果

```html
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vue的动画效果</title>
        <script src="lib/vue-2.4.0.js"></script>
        <style>
            /* v-enter 这是个时间点，是进入之前，元素的起始状态，此时还没有进入 */
            /* v-leave-to 这是个时间点，是动画离开之后，元素的终止状态，此时，元素 动画已经结束了 */
            .div-enter,
            .div-leave-to {
                opacity: 0;
                transform: translateX(50px);
            }

            /* v-enter-active 入场动画的时间段 */
            /* v-leave-active 离场动画的时间段 */
            .div-enter-active,
            .div-leave-active {
                transition: all 0.8s ease;
            }
        </style>
    </head>

    <body>
        <div id="app">
            <button @click="flag=!flag">点击</button>
            <transition name="div">
                <div v-show="flag">这是一个div</div>
            </transition>
        </div>

        <script>
            new Vue({
                el: "#app",
                data: {
                    flag: true
                },
                methods: {

                },
                filters: {

                }
            })
        </script>
    </body>

</html>
```

![](/202032522416.gif)