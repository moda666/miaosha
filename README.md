# miaosha
Java秒杀系统

## 初始情况

### 初始项目情况

**后端**：SpringBoot，MyBatis，JSR303

**前端**：Thymeleaf，Bootstrap，Jquery

**中间件**：Druid，Redis，RabbitMQ

### 服务器情况

**服务器类型**：阿里云轻量应用服务器

**CPU核心数**：单核

**内存**：2G

**磁盘**：40G

### 初始QPS

用一段小代码往数据库里插入了1800条用户信息，并生成相应的用户Token，保存在tokens.txt中。

使用JMeter来进行压力测试

