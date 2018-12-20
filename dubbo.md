# dubbo

### 环境搭建
	* 生产者
      1. maven->dubbo-spring-boot-starter
      2. yml
        ```
          # 名字
          dubbo.application.name=user-service-provider
          # 注册中心
          dubbo.registry.protocol=zookeeper
          dubbo.registry.address=120.79.10.101:2181
          # 通信协议,协议名称,端口号
          dubbo.protocol.name=dubbo 
          dubbo.protocol.port=20880
          # 监控中心
          dubbo.monitor.protocol=registry

        ```
      3. 主类@EnableDubbo
      4. 编写实现类@service(dubbo下)
    * 消费者
      1. 与上面1.2.3步一样
      2. yml
        ```
        dubbo:
          application:
          name: user-controller-consumer
          registry:
          address: zookeeper://120.79.10.101:2181

        ```
      3. 使用@Reference(dubbo下)注入
    * 注意
      1. 接口路径一定一定一定一定一定一定一定一定一定一样
      2. 建议接口生成一个新项目install后导入双方

### 小贴士
	1.  @Reference(check = false)//让依赖检查关闭,可以先启消费者
	2.  @Service(timeout = 5000,loadbalance = "roundrobin") //负载均衡策略
	3. dubbo底层协议(通信协议)有多种
		1. dubbo:单连接，长连接，tcp,nio异步传输: 数据包小(数据包小于100k),消费者个数多,常规方式
		2. RMI: 多连接，短连接，tcp,同步传输: 数据包大小不一样,消费者与提供者相差不大
		3. Hessian: 多连接，短连接，HTTP,同步传输: 数据包大小不一样,消费者与提供者相差不大
