---
typora-root-url: images
---

## ElementUI之分页

> ① : 将ElementUI中的分页代码进行拷贝
>
> ② : 修改user-list.vue

![2020401051](/2020401051.gif)

> 第一步 : 将ElementUI中的分页代码进行拷贝
>
> @size-change :  pageSize 改变时会触发(每页条数)
>
> @current-change : currentPage 改变时会触发(当前页)
>
> :current-page : 当前页
>
> :page-sizes : 每页显示多少条数据
>
> :page-size : 每页显示条目个数
>
> :total : 数据总数

```vue
<div class="page-component">
	<el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="page.pageNumber"
    :page-sizes="[1,2,5,10]"
    :page-size="page.pageSize"
    layout="total, sizes, prev, pager, next, jumper"
    :total="page.totalCount">
</el-pagination>
</div>

<script>
  export default {
    methods: {
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
    data() {
      return {
        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4
      };
    }
  }
</script>
```



> 第二步 : 修改user-list.vue
>
> * 修改handleSizeChange(val)方法
> * 修改handleCurrentChange(val)方法

```vue
<template>
  <div>
    <el-table :data="page.list" border style="width: 100%">
      <el-table-column prop="userId" label="用户编号" sortable="custom"></el-table-column>
      <el-table-column prop="userName" label="用户姓名" sortable="custom"></el-table-column>
      <el-table-column prop="userSex" label="性别" sortable="custom">
        <template slot-scope="scope">
          <span>{{ scope.row.userSex === 1 ? '男' : '女' }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="userAge" label="年龄" sortable="custom"></el-table-column>
      <el-table-column prop="userBirthday" label="生日" sortable="custom"></el-table-column>
      <el-table-column prop="department.name" label="部门" sortable="custom"></el-table-column>
      <el-table-column prop="createdTime" label="创建时间" sortable="custom"></el-table-column>
      <el-table-column prop="updateTime" label="更新时间" sortable="custom">
        <template slot-scope="scope">
          <span>{{ scope.row.updateTime | handlerNullTime }}</span>
        </template>
      </el-table-column>
    </el-table>

    <div class="page-component">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="page.pageNumber"
        :page-sizes="[1,2,5,10]"
        :page-size="page.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="page.totalCount"
      ></el-pagination>
    </div>
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
    },
    handleSizeChange(val) {
      // pageSize 控制页面显示条数
      this.page.pageSize = val
      this.getUserList()
    },
    handleCurrentChange(val) {
      // pageNumber 控制着当前页
      this.page.pageNumber = val
      this.getUserList()
    }
  },
  filters: {
    handlerNullTime(time) {
      if (!time) {
        return "该数据项为空!!!";
      }
      return time;
    }
  },
  created() {
    this.getUserList();
  }
};
</script>

<style scoped>
.page-component {
  margin-top: 15px;
}
</style>
```

