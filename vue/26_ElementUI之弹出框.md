---
typora-root-url: images
---

## ElementUI之弹出框

> 需求 : 实现user的编辑和删除
>
> ![](202004011530.gif)



### 编辑

> 第一步 : 修改`user-list.vue`中的表格
>
> ![image-20200401142110348](/image-20200401142110348.png)

```vue
<el-table-column fixed="right" label="操作">
    <template slot-scope="scope">
<el-button
           @click="toUpdate(scope.row.userId)"
           type="primary"
           size="mini">
    编辑</el-button>
<el-button
           @click="deleteById(scope.row.userId)"
           type="danger"
           size="mini">
    删除</el-button>
    </template>
</el-table-column>

<script>
    export default {
        data() {
            return {
                //控制对话框时候展开
                dialogFormVisible: false
            }
        },
        methods: {
            // 更新用户
            toUpdate(userId) {
                userApi.getById(userId).then(res => {
                    this.dialogFormVisible = true
                    this.user = res.data
                })
            }
        }
    }
</script>
```



> 第二步 : 添加对话框

```vue
<!-- 添加对话框 -->
<el-dialog title="修改用户" :visible.sync="dialogFormVisible">
    <user-edit :user="user" @closeDialog="closeDialog" @getUserList="getUserList">
    </user-edit>
</el-dialog>

<script>
    export default {
        data(){
          return {
               user:{},
      		   dialogFormVisible: false // 控制对话框
          }  
        },
        // 省略其他
        methods: {
            closeDialog() {
                this.dialogFormVisible = false
            }
        }
    }
</script>
```



> 第三步 : 提取`user-edit.vue`

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
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="updateUser">修改</el-button>
      <el-button @click="closeDialog">取消</el-button>
    </div>
  </div>
</template>

<script>
// 导入api
import userApi from "../../api/user.js";
import departmentApi from "../../api/department.js";
export default {
  data() {
    return {
      departmentList: []
    };
  },
  props: {
    user: {
      type: Object,
      default: {}
    }
  },
  methods: {
    getDepartmentList() {
      departmentApi.departmentList().then(res => {
        this.departmentList = res.data;
      });
    },
    updateUser() {
      userApi.update(this.user).then(res => {
        this.$message.success(res.msg);
        this.$emit("closeDialog");
        this.$emit("getUserList");
      });
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  },
  created() {
    this.getDepartmentList();
  }
};
</script>
```



> 第四步 : 在user-list.vue中进行配置
>
> ① : 导入userEdit , 并加载组件

```vue
<script>
    // 导入userEdit
    import userEdit from './user-edit.vue'
    export default {
        data() {
            ....
        },
        components:{
            userEdit
        }
    }
</script>
```



### 删除

> ① : 修改user-list.vue中的操作
>
> ② : 添加对应的方法即可

> 第一步 : 修改user-list.vue中的操作

```vue
<el-table-column fixed="right" label="操作">
    <template slot-scope="scope">
		<el-button @click="toUpdate(scope.row.userId)" type="primary" size="mini">编辑
        </el-button>
		<el-button @click="deleteById(scope.row.userId)" type="danger" size="mini">删除
        </el-button>
    </template>
</el-table-column>
```

> 第二步 : 添加对应的方法即可

```vue
 deleteById(userId) {
      this.$confirm("是否删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        userApi.deleteById(userId).then(res => {
          this.$message.success(res.msg);
          this.getUserList();
        });
      });
    }
```

