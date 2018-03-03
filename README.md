# miaosha
Java秒杀系统

# 初始情况

## 初始项目情况

**后端**：SpringBoot，MyBatis，JSR303

**前端**：Thymeleaf，Bootstrap，Jquery

**中间件**：Druid，Redis，RabbitMQ

## 服务器情况

**服务器类型**：阿里云轻量应用服务器

**CPU核心数**：单核

**内存**：2G

**磁盘**：40G

## 初始QPS

用一段代码往数据库里插入了1500条用户信息，并生成相应的用户Token，保存在tokens.txt中。

使用JMeter来进行压力测试，由于我的阿里云服务器配置较低，压测的时候出现很多问题，而且不能测试太多线程。

所以，我就改用我的的Windows电脑进行测试，采用的也是本地MySQL和本地Redis。

QPS：是指每秒内查询次数,比如执行了select操作,相应的qps会增加。QPS = 总请求数 / ( 进程总数 *   请求时间 )

### 测试商品列表

1500个线程*10次，平均QPS = 1076/sec

### 测试秒杀接口

1500个线程*10次，平均QPS = 652/sec

## 开始优化

