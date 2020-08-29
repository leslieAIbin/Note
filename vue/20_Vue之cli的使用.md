---
typora-root-url: images
---

## vue-cli

> Vue的脚手架
>
> 注意 : 
>
> ​		Vue-cli3创建的项目中，默认把@符号作为src路径。在任何地方，都可以使用@符号从src路径下引入组件、文件等
>
> ​		vue-cli3创建的项目中，默认把import时的后缀给取消了，在import的时候，可以不带文件后缀（没有不确定的文件名（user.vue,user.js））

### 安装步骤

> 安装本版 : npm install -g @vue/cli@3.7.0

![image-20200331185452536](/image-20200331185452536.png)

> 查看版本 : vue -v

![image-20200331185754857](/image-20200331185754857.png)

> 开始创建项目 : vue ui

<img src="/image-20200331185843134.png" style="float:left;width:350px;"/>

![image-20200331185925816](/image-20200331185925816.png)



### 创建项目

#### 详情

![image-20200331190144960](/image-20200331190144960.png)



#### 预设

![image-20200331190220931](/image-20200331190220931.png)



#### 功能

![image-20200331190702807](/image-20200331190702807.png)

#### 配置

![image-20200331190750052](/image-20200331190750052.png)

#### 创建项目

![image-20200331190827683](/image-20200331190827683.png)

#### 创建完成

![image-20200331191156445](/image-20200331191156445.png)



### 安装插件

> 安装 : axios

![image-20200331191336919](/image-20200331191336919.png)

> 安装Element UI

![image-20200331191510026](/image-20200331191510026.png)



### 使用VSCode进行配置

> 查看package.json

![image-20200331191757825](/image-20200331191757825.png)

> 创建vue.config.js进行配置

```js
// vue.config.js 配置说明
// 这里只列一部分，具体配置惨考文档啊
module.exports = {
    // baseUrl :'/' 
    // 将部署应用程序的基本URL
    // 默认情况下，Vue CLI假设您的应用程序将部署在域的根目录下。
    // https://www.my-app.com/。如果应用程序部署在子路径上，则需要使用此选项指定子路径。例如，如果您的应用程序部署在https://www.foobar.com/my-app/，集baseUrl到'/my-app/'.

    baseUrl: '/',

    //   lintOnSave：{ type:Boolean default:true } 问你是否使用eslint
    lintOnSave: false,
    // productionSourceMap：{ type:Bollean,default:true } 生产源映射
    // 如果您不需要生产时的源映射，那么将此设置为false可以加速生产构建
    productionSourceMap: false,
    // devServer:{type:Object} 3个属性host,port,https
    // 它支持webPack-dev-server的所有选项

    devServer: {
        port: 8085, // 端口号
        open: true, //配置自动启动浏览器
        // proxy: 'http://localhost:4000' // 配置跨域处理,只有一个代理
        proxy: {
            '/': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        },  // 配置多个代理
    }
}
```

> 项目结构

<img src="/image-20200331192330209.png" style="float:left; width:290px"/>

> 启动项目 : npm run dev
>
> 如果项目报错 , 删除vue.config.js中的 :     baseUrl: '/',

![image-20200331192516487](/image-20200331192516487.png)

> 创建utils文件夹 和 request.js文件

`request.js`

```js
import axios from 'axios'
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
    return Promise.reject(error)
  }
)

// response 拦截器
service.interceptors.response.use(
  response => {
    const res = response.data
    return res
  },
  error => {
  }
)

export default service
```

> 创建api文件夹和api文件

```js
import request from '@/utils/request'
export default {
  departmentList() {
    return request({
      url: `/department/departmentList`,
      method: 'get'
    })
  }
}
```

> 此时的项目结构

<img src="/image-20200331193048489.png" style="float:left;width:290px"/>