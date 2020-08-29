---
typora-root-url: images
---

## ElementUI之表单

> 需求 : 实现user的添加用户
>
> ![](202004011403.gif)

> 第一步 : 在`user`文件夹中创建`user-add.vue`文件
>
> <img src="/image-20200401134804959.png" style="float:left"/>

```vue
<template>
  <div></div>
</template>

<script>
// 导入departmentApi
import departmentApi from "../../api/department.js";
export default {
  data() {
    return {
      departmentList: []
    };
  },
  methods: {
    getDepartmentList() {
      departmentApi.departmentList().then(res => {
        this.departmentList = res.data;
      });
    }
  },
  filters: {},
  created() {
    this.getDepartmentList();
  }
};
</script>

<style scoped>
</style>
```



> 第二步 : 更改`index.js`中的路由

```js
const routes = [
    {
        path: '/userAdd',
        component: () => import('../views/user/user-add.vue')
    }
]
```



> 第三步 : 修改`user-add.vue`
>
> ![image-20200401135909426](/image-20200401135909426.png)

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
import departmentApi from "../../api/department.js";
import userApi from "../../api/user.js";
export default {
  data() {
    return {
      departmentList: [],
      user: {}
    };
  },
  methods: {
    getDepartmentList() {
      departmentApi.departmentList().then(res => {
        this.departmentList = res.data;
      });
    },
    saveUser() {
      userApi.save(this.user).then(res => {
        this.$message.success(res.msg);
        this.$router.push("/userList");
      });
    }
  },
  created() {
    this.getDepartmentList();
  }
};
</script>

<style scoped>
</style>
```



> 第四步 : 进行测试