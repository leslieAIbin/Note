## `Vue`

> 简介 : 一套用于构建用户界面的渐进式`JavaScript`框架。
>
> 作者 : 尤雨溪
>
> 官网 : https://cn.vuejs.org/



### `Vue`的特点

* 轻量级(压缩后只有33K)
* 更高的运行效率
  * 从传统的操作`DOM`节点过度到了虚拟的`DOM`
* 双向数据绑定
  * 让开发者不用再去操作`DOM` , 而是把更多精力投入到业务逻辑上
* 生态丰富 , 学习成本低



### `MVVM`架构

>  `MVVM`  : 由 `Model` , `View` , `ViewModel` 三部分构成

#### `Model `

>  代表数据模型，也可以在`Model`中定义数据修改和操作的业务逻辑；主要将数据和页面进行分离

#### `View `

>  代表`UI `组件，它负责将数据模型转化成`UI` 展现出来

#### `ViewModel`

> `ViewModel` 是一个同步View 和 Model的对象。



### 目录结构

```
├── build                      # 构建相关
├── static                     # 静态资源
│   │── img                    # 图片
│   │── favicon.ico            # favicon图标
│   └── index.html             # html模板
│   │── Tinymce                # 富文本
├── src                        # 源代码
│   ├── api                    # 所有请求
│   ├── assets                 # 主题 字体等静态资源
│   ├── components             # 全局公用组件
│   ├── directive              # 全局指令
│   ├── icons                  # 项目所有 svg icons
│   ├── lang                   # 国际化 language
│   ├── layout                 # 全局 layout
│   ├── router                 # 路由
│   ├── store                  # 全局 store管理
│   ├── styles                 # 全局样式
│   ├── utils                  # 全局公用方法
│   ├── views                  # views 所有页面
│   ├── App.vue                # 入口页面
│   ├── main.js                # 入口文件 加载组件 初始化等
│   └── permission.js          # 权限管理
├── tests                      # 测试
├── .env.xxx                   # 环境变量配置
├── .eslintrc.js               # eslint 配置项
├── .gitignore                 # git 配置项
├── .babelrc                   # babel-loader 配置
├── .travis.yml                # 自动化CI配置
├── vue.config.js              # vue-cli 配置
└── package.json               # package.json
```



### 更多介绍

> https://www.cnblogs.com/clwydjgs/p/10796763.html