
## 项目介绍
国际机票TTS(Total Solution)平台服务
## 系统架构图
## 组织结构

```lua
mall
├── mall-common -- 工具类及通用代码模块
├── mall-dao -- MyBatisGenerator生成的数据库操作代码模块
├── mall-admin -- TTS (Total Solution)管理平台服务
├── mall-agent -- TTS 聚合代理服务
└── config -- 配置中心存储的配置
```

## 项目文档

## 项目演示

- 后台管理系统：

## 技术选型

### 后端技术
| 技术 | 说明 | 官网 |
| --- | --- | --- |
| Spring Cloud | 微服务框架 | [https://spring.io/projects/spring-cloud](https://spring.io/projects/spring-cloud) |
| Spring Cloud Alibaba | 微服务框架 | [https://github.com/alibaba/spring-cloud-alibaba](https://github.com/alibaba/spring-cloud-alibaba) |
| Spring Boot | 容器+MVC框架 | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) |
| Spring Security Oauth2 | 认证和授权框架 | [https://spring.io/projects/spring-security-oauth](https://spring.io/projects/spring-security-oauth) |
| MyBatis | ORM框架 | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html) |
| MyBatisGenerator | 数据层代码生成 | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html) |
| PageHelper | MyBatis物理分页插件 | [http://git.oschina.net/free/Mybatis_PageHelper](http://git.oschina.net/free/Mybatis_PageHelper) |
| Redis | 分布式缓存 | [https://redis.io/](https://redis.io/) |
| JWT | JWT登录支持 | [https://github.com/jwtk/jjwt](https://github.com/jwtk/jjwt) |


## 环境搭建

### 开发环境
| 工具 | 版本号 | 下载 |
| --- | --- | --- |
| JDK | 1.8 | [https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) |
| Mysql | 5.7 | [https://www.mysql.com/](https://www.mysql.com/) |
| Redis | 7.0 | [https://redis.io/download](https://redis.io/download) |


### 搭建步骤
Linux 环境部署

- 初始化数据库
> 用的Mysql ，源代码 `document`目录下导入 `education.sql`

- 本地启动Consul，注册微服务
> [https://kingfree.gitbook.io/consul/getting-started/install](https://kingfree.gitbook.io/consul/getting-started/install)

- IDE 启动
> SpringBoot 找到 `AdminApplication.java` 启动Web服务

![image.png](https://cdn.nlark.com/yuque/0/2023/png/25529450/1673264084253-e2e5eb8f-dd7f-4291-8fee-c3d18689785a.png#averageHue=%23eaeae9&clientId=u004af954-e21a-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=182&id=u1e7cb6fc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=364&originWidth=2422&originalType=binary&ratio=1&rotation=0&showTitle=false&size=568162&status=done&style=none&taskId=ub976d863-3342-496c-9e90-b6b40236ddf&title=&width=1211)
## 运行效果展示
![image.png](https://cdn.nlark.com/yuque/0/2023/png/25529450/1673264139993-a85043a9-0b60-449a-8064-c9d7da576b53.png#averageHue=%23f7f6f6&clientId=u004af954-e21a-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=679&id=u64290b59&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1358&originWidth=2148&originalType=binary&ratio=1&rotation=0&showTitle=false&size=235139&status=done&style=none&taskId=uad46a65b-5438-42b2-9694-cb5bf5eff25&title=&width=1074)
## ![image.png](https://cdn.nlark.com/yuque/0/2023/png/25529450/1673264677715-eb617425-189c-40c0-8418-aa95fc83ffc4.png#averageHue=%23f5c027&clientId=ueb1032cc-7a0b-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=386&id=uf4e2f769&margin=%5Bobject%20Object%5D&name=image.png&originHeight=772&originWidth=2406&originalType=binary&ratio=1&rotation=0&showTitle=false&size=153424&status=done&style=none&taskId=ubcf2897a-11b3-4b87-9d68-a75cf851feb&title=&width=1203)
## 许可证

Apache License 2.0

Copyright (c) 2018-2023  laziobird
