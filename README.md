## vap-module

统一的模块及版本入口，版本统一管理。以免造成版本混乱及版本不归一情况。

## 开发遵循规范
### 版本号统一管理，不依赖各个模块去管理依赖版本号。如需要升级，做统一升级管理，以免造成版本混乱和不一致
- vap-service
- vap-utils
- vap-common
- vap-syslog
- vap-swagger2-spring-boot-starter
- vap-redis-spring-boot-starter
- vap-prometheus-spring-boot-starter


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



