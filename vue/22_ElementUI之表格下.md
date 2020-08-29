## ElementUI之表格(user)

> 具体步骤 : 
>
> ① : 在api文件夹下面创建user.js
>
> ② : 更改index.js和App.vue中的路由
>
> ③ : 添加动画
>
> ④ : 创建user-list.vue , 并配置

> 第一步 : 在api文件夹下面创建user.js

```js
import request from '../utils/request'
const group_name = "user"
export default {
  /**
   * 查询所有用户
   * url : 对应接口的url
   * method : 请求方式
   * data : 需要传递的参数
   * */ 
  userList(page) {
    return request({
      url: `/${group_name}/page`,
      method: 'post',
      data: page
    })
  },
   /**
   * 更新用户
   * url : 对应接口的url
   * method : 请求方式
   * data : 需要传递的参数
   * */ 
  update(user) {
    return request({
      url: `/${group_name}/update`,
      method: 'put',
      data: user
    })
  },
  /**
   * 删除用户
   * url : 对应接口的url
   * method : 请求方式
   * data : 需要传递的参数
   * */ 
  deleteById(id) {
    return request({
      url: `/${group_name}/delete/${id}`,
      method: 'delete'
    })
  },
  /**
   * 保存用户
   * url : 对应接口的url
   * method : 请求方式
   * data : 需要传递的参数
   * */ 
  save(user) {
    return request({
      url: `/${group_name}/save`,
      method: 'post',
      data: user
    })
  },
  /**
   * 根据id进行一个删除
   * url : 对应接口的url
   * method : 请求方式
   * data : 需要传递的参数
   * */ 
  getById(id) {
    return request({
      url: `/${group_name}/get/${id}`,
      method: 'get'
    })
  }
}
```



> 第二步 : 更改index.js和App.vue中的路由

`index.js`

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
  },
  {
    path: '/userList',
    component: () => import('../views/user/user-list.vue')
  }
]
```

`App.vue`

```vue
<el-menu-item index="2-1" :route="'/userList'">用户列表</el-menu-item>
```



> 第三步 : 添加动画

```vue
<transition name="component">
    <router-view />
</transition>

<style>
/* 这个是头部导航 */
.menu-div {
  margin-bottom: 10px;
}

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



> 第四步 : 创建user-list.vue , 并配置

```vue
<template>
	<div>
        <el-table :data="page.list" border style="width: 100%">
        <el-table-column prop="userId" label="用户编号" sortable="custom"></el-table-column>
        <el-table-column prop="userName" label="用户姓名" sortable="custom"></el-table-column>
        <el-table-column prop="userSex" label="性别" sortable="custom"></el-table-column>
        <el-table-column prop="userAge" label="年龄" sortable="custom"></el-table-column>
        <el-table-column prop="userBirthday" label="生日" sortable="custom"></el-table-column>
        <el-table-column prop="department.name" label="部门" sortable="custom"></el-table-column>
        <el-table-column prop="createdTime" label="创建时间" sortable="custom"></el-table-column>
        <el-table-column prop="updateTime" label="更新时间" sortable="custom"></el-table-column>
  </el-table>
    </div>
</template>

<script>
// 导入userApi
import userApi from "../../api/user.js";
export default {
  data() {
    return {
      page: {
        pageNumber: 1,
        pageSize: 5,
        totalPage: 0,
        totalCount: 0,
        list: [],
        params: {},
        sortColumn: "",
        sortMethod: ""
      }
    };
  },
  methods: {
    getUserList() {
      userApi.userList(this.page).then(res => {
        this.page = res.data;
      });
    }
  },
  created() {
    this.getUserList();
  }
};
</script>
```



> 第五步 : 进行访问

![image-20200331231808660](G:%5C%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%5Cvue%5Cimages%5Cimage-20200331231808660.png)



> 第六步 : 将性别为1的改为男

```vue
<el-table-column prop="userSex" label="性别" sortable="custom">
    <template slot-scope="scope">
		<span>{{ scope.row.userSex === 1 ? '男' : '女' }}</span>
    </template>
</el-table-column>
```

![image-20200331232536182](G:%5C%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%5Cvue%5Cimages%5Cimage-20200331232536182.png)



> 第七步 : 使用过滤器 , 更新时间为空的显示数据为空

```vue
<el-table-column prop="updateTime" label="更新时间" sortable="custom">
    <template slot-scope="scope">
    	<span>{{ scope.row.updateTime | handlerNullTime }}</span>
    </template>
</el-table-column>

....

<script>
 filters:{
    handlerNullTime(time){
      if(!time){
        return '该数据项为空!!!'
      }
      return time;
    }
  }
</script>
```

![image-20200401001557494](G:%5C%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%5Cvue%5Cimages%5Cimage-20200401001557494.png)



> 解决页面刷新是导航栏高亮问题

```vue
<template>
  <div id="app">
    <div class="menu-div">
      <el-menu :default-active="activeIndex" class="el-menu-demo" :router="true" mode="horizontal">
        <el-menu-item index="1" :route="'/departmentList'">部门管理</el-menu-item>
        <el-submenu index="2">
          <template slot="title">用户管理</template>
          <el-menu-item index="2-1" :route="'/userList'">用户列表</el-menu-item>
          <el-menu-item index="2-2">添加用户</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>

    <transition name="component" mode="out-in">
      <router-view />
    </transition>
  </div>
</template>
```



```vue
<script>
export default {
  data() {
    return {
      activeIndex: "1",
      newConfig: {
        // 这里的路径对应这路由中的路径
        'departmentList': "1",
        'userList': "2-1",
        'addUser': "2-2"
      }
    };
  },
  mounted() {
    var _this = this
    var href = window.location.href
    href = href.split("/#/")[1]
    console.log(href)
    _this.activeIndex = _this.newConfig[href]
  }
};
</script>
```

