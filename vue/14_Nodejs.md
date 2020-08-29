---
typora-root-url: images
---



## Node.js简介

> ​		Node.js 是一个基于 Chrome V8 引擎的 `JavaScript`运行环境。 Node.js 使用了一个事件驱动、非阻塞式 I/O 的模型。
>
> ​		在浏览器中 , js是无法操作文件的 , 而node提供了文件操作 , 同时也提供了后端代码编写的功能.

### 安装版本

> node-v12.14.1-x64.msi

### 安装步骤

> 选择安装目录的时候 , 尽量不要安装在C盘 , 其他的全部下一步

### 查看是否安装成功

> 查看node的版本 
>
> node -v
>
> 查看npm的版本
>
> npm -v

![image-20200330153606361](/image-20200330153606361.png)



### npm

> ​		npm是node提供的一个包管理工具 , 类似于maven. 通过npm去安装依赖包 , 就不需要在页面上使用`script`标签了.
>
> 配置淘宝镜像
>
> ```
> npm config set registry https://registry.npm.taobao.org
> ```

