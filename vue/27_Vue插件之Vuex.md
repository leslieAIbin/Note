---
typora-root-url: images
---

## Vuex的使用

> ​		Vuex 是一个专门为vue应用程序开发的状态管理（数据管理）模式。它采用了集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化.
>
> ​		Vuex是Vue配套的公共数据管理工具。它可以把一些共享的数据，保存到vuex中，方便整个程序中的任何组件直接获取或者修改我们的公共数据
>
> ​		Vuex是为了保存组件之间共享数据而诞生的。如果组件之间有要共享的数据，可以挂载到vuex中，而不必父子组件之间传值了。



### Vuex的结构

* data：存放组件私有数据
* props：存放父子组件的数据
* vuex：存放共享数据



### 使用场景

> 存放全局变量、存放登录信息、存放三方接口的一些固定参数等等



### 使用Vuex

> 需求 : 
>
> ​	将上述项目中的getDepartment()查询的数据存放到Vuex中

> 第一步 : 安装Vuex
>
> 命令 : npm i vuex

![image-20200401155138945](/image-20200401155138945.png)



> 第二步 : 在`main.js`中进行配置

```js
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Vuex from 'vuex'

Vue.use(Vuex)
Vue.use(ElementUI);
Vue.config.productionTip = false

const store = new Vuex.Store({
  // 相当于 data
  // 使用方式：this.$store.state.count
  state: {
    departmentList: []
  },
  // 相当于methods
  // 使用方式：this.$store.commit('方法名', 参数1, 参数2....)
  mutations: {
    SET_DEPARTMENT_LIST(state, val) {
      state.departmentList = val
    }
  },
  // 通过getters去获取vuex中的数据
  // 用法：this.$store.getters.getCount
  getters: {
    getDepartmentList(){
      return store.state.departmentList
    }
  }
})

new Vue({
  router,
  render: h => h(App),
  store
}).$mount('#app')
```



> 第二步 : 在`App.vue`中进行配置. 保证只有页面刷新就加载数据

```vue
<script>
import departmentApi from "./api/department.js";
export default {
  data() {
    return {
      activeIndex: "1",
      newConfig: { // 页面刷新时显示高亮
        'departmentList': "1",
        'userList': "2-1",
        'userAdd': "2-2"
      }
    };
  },
  methods:{
    getDepartmentList(){
      departmentApi.departmentList().then(res => {
        this.$store.commit('SET_DEPARTMENT_LIST',res.data)
      })
    }
  },
  mounted() {
    var _this = this
    var href = window.location.href
    href = href.split("/#/")[1]
    console.log(href)
    _this.activeIndex = _this.newConfig[href]
  },
  created(){
    this.getDepartmentList()
  }
};
</script>
```



> 第三步 : 以user-add.vue为例子, 其他页面一样
>
> * 将data中的departmentList改为
>   * departmentList: this.$store.getters.getDepartmentList,
> * 把其他的getDepartment()方法删掉
> * 把created()中调用getDepartmentList()的方法也删掉
>
> ![image-20200401161451249](/image-20200401161451249.png)

```vue
<template>
  <div>
    <el-form :model="user" label-width="80px">
      <el-form-item label="用户姓名">
        <el-input v-model="user.userName" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="user.userSex">
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="user.userAge" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-date-picker
          v-model="user.userBirthday"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetime"
          placeholder="选择生日"
          style="width: 200px"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="部门">
        <el-select v-model="user.userDepartment" placeholder="选择部门" style="width: 200px">
          <el-option
            v-for="item in departmentList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveUser">保存</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
// 导入departmentApi
import userApi from "../../api/user.js";
export default {
  data() {
    return {
      departmentList: this.$store.getters.getDepartmentList,
      user: {}
    };
  },
  methods: {
    saveUser() {
      userApi.save(this.user).then(res => {
        this.$message.success(res.msg);
        this.$router.push("/userList");
      });
    }
  }
};
</script>

<style scoped>
</style>
```

