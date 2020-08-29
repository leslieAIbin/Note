---
typora-root-url: images
---

## ElementUI之搜索框

> ① : 找到ElementUI中对应的form组件. 进行拷贝
>
> ② : 进行修改

>  from的表单组件
>
> ![image-20200401123340464](/image-20200401123340464.png)

```vue
<el-form :inline="true" :model="formInline" class="demo-form-inline">
  <el-form-item label="审批人">
    <el-input v-model="formInline.user" placeholder="审批人"></el-input>
  </el-form-item>
  <el-form-item label="活动区域">
    <el-select v-model="formInline.region" placeholder="活动区域">
      <el-option label="区域一" value="shanghai"></el-option>
      <el-option label="区域二" value="beijing"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>
```



### 根据姓名搜索

> ① : 修改`:model`
>
> ② : 修改`@click`事件
>
> ![](202004011236.gif)

> 修改`user-list.vue`中的`template`组件

```vue
<!-- 搜索框开始 -->
<div>
    <el-form :inline="true" :model="page.params" class="demo-form-inline">
        <el-form-item label="姓名">
            <el-input v-model="page.params.userName" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="getUserList">查询</el-button>
        </el-form-item>
    </el-form>
</div>
```



### 根据性别搜索

> ① : 拷贝组件
>
> ② : 修改`:model`
>
> ③ : 清空所选项`clearable`
>
> ![](202004011247.gif)

```vue
<!-- 搜索框开始 -->
<div>
    <el-form :inline="true" :model="page.params" class="demo-form-inline">
        <el-form-item label="性别">
            <el-select v-model="page.params.userSex" placeholder="性别" clearable>
                <el-option label="男" value="1"></el-option>
                <el-option label="女" value="2"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="getUserList">查询</el-button>
        </el-form-item>
    </el-form>
</div>
```



### 根据部门搜索

> ① : 找到选择器的组件
>
> ② : 引入department的api
>
> ③ : 进行修改
>
> ![](202004011300.gif)

```vue
<!-- 搜索框开始 -->
<div>
    <el-form :inline="true" :model="page.params" class="demo-form-inline">
        <el-form-item label="所在部门">
           <el-select v-model="page.params.userDepartment" placeholder="请选择" clearable>
               <el-option
                 v-for="item in departmentList"
                 :key="item.value"
                 :label="item.name"
                 :value="item.id">
               </el-option>
           </el-select>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="getUserList">查询</el-button>
        </el-form-item>
    </el-form>
</div>
```



### 根据时间搜索

> ① : 找到时间控件
>
> ② : 添加修改方法
>
> ③ : 进行部分判断
>
> ![](202004011321.gif)

```vue
<!-- 搜索框开始 -->
<div>
    <el-form :inline="true" :model="page.params" class="demo-form-inline">
        <el-form-item label="生日">
            <el-date-picker
              v-model="birthday"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="datetimerange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              @change="changeBirthday">
            </el-date-picker>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="getUserList">查询</el-button>
        </el-form-item>
    </el-form>
</div>

<script>
export default {
    data(){
        return birthday: null
    },
    methods: {
         changeBirthday(val) {
              if (val) {
                // 创建时间不为空，处理一下创建时间区间
                this.page.params.userBirthdayStart = val[0];
                this.page.params.userBirthdayEnd = val[1];
              } else {
                this.page.params.userBirthdayStart = null;
                this.page.params.userBirthdayEnd = null;
              }
        }
    }
}
</script>
```



### 实现表格排序

> ① : 在<el-table/>属性中添加`@sort-change="sortChange"`
>
> ② : 在methods中添加`sortChange()`
>
> ![](202004011329.gif)

```vue
<el-table :data="page.list" border style="width: 100%" @sort-change="sortChange">
	...
</el-table>

<script>
	export default {
        methods: {
            sortChange(column, prop, order) {
              this.page.sortColumn = column.prop;
              this.page.sortMethod = column.order;
              this.getUserList();
            }
        }
    }
</script>
```

