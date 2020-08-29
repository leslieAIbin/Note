---
typora-root-url: images
---

## ElementUI之表格(department)

### 实现静态数据

> 第一步 : 在views创建department文件夹 , 在其下面创建department-list.vue

<img src="/image-20200331204122641.png" style="float:left;"/>



> 第二步 :  从ElementUI文档找到表格的数据进行粘贴到department-list.vue中

```vue
<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="date" label="日期" width="180"></el-table-column>
    <el-table-column prop="name" label="姓名" width="180"></el-table-column>
    <el-table-column prop="address" label="地址"></el-table-column>
  </el-table>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄"
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄"
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄"
        }
      ]
    };
  }
};
</script>
```



> 第三步 : 在App.vue中修改部门管理 , 添加路由

```vue
 <el-menu-item index="1" :route="'/departmentList'">部门管理</el-menu-item>
```



> 第四步 : 修改index.js中的路由

```js
const routes = [
  // 路由的懒加载
  { // 重定向到departmentList中
    path: '/',
    redirect: '/departmentList'
  },
  {
    path: '/departmentList',
    component: () => import('../views/department/department-list.vue')
  }
]
```



> 第五步 : 进行访问

![image-20200331204527923](/image-20200331204527923.png)



> 第六步 : 修改样式
>
> ① : 添加class
>
> ② : 在<style>中添加css文件

```vue
<template>
  <div id="app">
    <div class="menu-div">
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1" :route="'/departmentList'">部门管理</el-menu-item>
        <el-submenu index="2">
          <template slot="title">用户管理</template>
          <el-menu-item index="2-1">用户列表</el-menu-item>
          <el-menu-item index="2-2">添加用户</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>

    <router-view />
  </div>
</template>

<style>
.menu-div {
  margin-bottom: 10px;
}
</style>
```



### 实现动态数据

> ① : 在api文件夹中书写department.js文件
>
> ② : 在department-list.vue中导入department.js
>
> ③ : 在request.js中根据状态码进行一个判断
>
> ④ : 将数据进行渲染

> 第一步 : 在api文件夹中书写department.js文件

```js
import request from '../utils/request'
const group_name = "department"
export default {
  departmentList() {
    return request({
      url: `/${group_name}/departmentList`,
      method: 'get'
    })
  }
}
```



> 第二步 : 在department-list.vue中导入department.js

```vue
<script>
import departmentApi from "../../api/department.js";
export default {
  data() {
    return {
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄"
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄"
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄"
        }
      ]
    };
  },
  methods: {
    getDepartmentList() {
      departmentApi.departmentList().then(res) => {
        console.log(res)
      }
    }
  }
};
</script>
```



> 第三步 : 在request.js中根据状态码进行一个判断

```js
import axios from 'axios'
import { Message } from 'element-ui'
const service = axios.create({
  baseURL: '/',
  timeout: 10000 // 默认请求超时时间
})

// request 拦截器
service.interceptors.request.use(
  config => {
    return config
  },
  error => {
    // 请求异常
    Message({
      type:"error",
      message:'系统异常 , 请快联系管理员!'
    })
    return Promise.reject(error)
  }
)

// response 拦截器
service.interceptors.response.use(
  response => {
    const res = response.data
    if(res.code === 200){
      return res
    }else{
      //非200异常 , 表示接口异常
      Message({
        type:"error",
        message:res.msg
      })
    }
  },
  error => {
    // 请求报错的情况 HTTP请求报错
    Message({
      type:"error",
      message:res.msg
    })
  }
)

export default service
```



> 第四步 : 将department-list.vue中的数据进行渲染
>
> 注意 : 
>
> * 渲染时:data中的数据要与data()中一直
> * 表格中的数据也要与java字段中的保持一致

```vue
<template>
  <el-table :data="departmentList" border style="width: 100%">
    <el-table-column prop="id" label="部门编号"></el-table-column>
    <el-table-column prop="name" label="所在部门"></el-table-column>
  </el-table>
</template>

<script>
import departmentApi from "../../api/department.js";
export default {
  data() {
    return {
      departmentList:[]
    };
  },
  methods: {
    getDepartmentList() {
      departmentApi.departmentList().then(res => {
        this.departmentList = res.data
      })
    }
  },
  created(){
    this.getDepartmentList()
  }
};
</script>
```



> 第五步 : 进行访问

![image-20200331221906518](/image-20200331221906518.png)

