## ElementUI之导航栏

> 详细文档 : https://element.eleme.cn
>
> 第一步 : 修改`App.vue` 和 `index.js`

`App.vue`

```vue
<template>
  <div id="app">
   
  </div>
</template>
```

`index.js`

```js
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  // 路由的懒加载
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  routes
})

export default router
```



> 第二步 : 在main.js中引入ElementUI

```js
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
```



> 第三步 : 在App.vue中引入导航栏

```vue
<template>
  <div id="app">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect">
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="3" disabled>消息中心</el-menu-item>
      <el-menu-item index="4">
        <a href="https://www.ele.me" target="_blank">订单管理</a>
      </el-menu-item>
    </el-menu>

	<router-view/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1"
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
};
</script>
```



> 第四步 : 进行访问

![image-20200331200344443](G:%5C%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%5Cvue%5Cimages%5Cimage-20200331200344443.png)



> 第五步 : 修改App.vue
>
> :router : 默认是false. 如果是false这点击部门管理时,不会加载表格. 如果需要点击时不为空更改为true即可

```vue
<template>
  <div id="app">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      :router="true"
      mode="horizontal">
      <el-menu-item index="1" :route="'/departmentList'">部门管理</el-menu-item>
      <el-submenu index="2">
        <template slot="title">用户管理</template>
        <el-menu-item index="2-1">用户列表</el-menu-item>
        <el-menu-item index="2-2">添加用户</el-menu-item>
      </el-submenu>
    </el-menu>

    <router-view/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "1"
    };
  }
};
</script>
```

