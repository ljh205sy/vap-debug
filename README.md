## vap-debug

统一的模块及版本入口，版本统一管理。以免造成版本混乱及版本不归一情况。

## 开发遵循规范
### 版本号统一管理，不依赖各个模块去管理依赖版本号。如需要升级，做统一升级管理，以免造成版本混乱和不一致
- vap-service                          所有服务引用该模块
- vap-mybatis                          mybatis使用统一封装
- vap-common
- vap-swagger2-spring-boot-starter     swagger接口文档
- vap-redis-spring-boot-starter        redis组件封装
- vap-prometheus-spring-boot-starter   prometheus监控
- api-services  所有服务路径


### 需要引入spring-boot 与 spring-cloud、 aliba-could 整合组件
~~~
<!-- spring-boot 与 spring-cloud、 aliba-could 整合-->
<dependency>
    <groupId>com.vrv.vap</groupId>
    <artifactId>vap-service</artifactId>
</dependency>
~~~ 


### 各服务引用redis操作统一封装，服务直接引用
~~~~
<!-- redis操作统一封装，服务直接引用 -->
<dependency>
    <groupId>com.vrv.vap</groupId>
    <artifactId>vap-redis-spring-boot-starter</artifactId>
    <version>${vap-redis.version}</version>
</dependency>
~~~~

### 各服务prometheus 监控统一封装，服务直接引用
访问方式:  http://127.0.01:端口/actuator/prometheus
~~~~
<!-- prometheus 监控 -->
<dependency>
    <groupId>com.vrv.vap</groupId>
    <artifactId>vap-prometheus-spring-boot-starter</artifactId>
</dependency>
~~~~        
### 各服务引用需要swagger接口文档。各服务可以去除swagger依赖
~~~
<!--  统一封装swagger接口文档 -->
  <dependency>
      <groupId>com.vrv.vap</groupId>
      <artifactId>vap-swagger2-spring-boot-starter</artifactId>
  </dependency>
~~~~

# 2021年4月24日17:08:01
1.针对单数据源的封装，多数据源动态设置后续在加
2.升级springboot、springcloud、spring alibaba cloud版本
3.技术栈
所需技能|技能
--| -- |
Java | 基础
Maven | 文章涉及到大量的代码，均使用Maven构建
Spring Boot |  微服务脚手架，版本号2.3.8.RELEASE
Spring Cloud | 版本号：Hoxton.SR9
Alibaba Cloud | 集成alibaba Cloud，版本号：2.2.5.RELEASE


<spring-cloud-alibaba-dependencies.version>2.2.5.RELEASE</spring-cloud-alibaba-dependencies.version>
<spring-boot-dependencies.version>2.3.8.RELEASE</spring-boot-dependencies.version>
<spring-cloud-dependencies.version>Hoxton.SR9</spring-cloud-dependencies.version>



