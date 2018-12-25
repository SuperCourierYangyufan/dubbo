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
### 异步调用
   1. Reference上async = true
	2. 主类上@EnableAsync
	3. 建议将异步方法放置异步异步的接口中,同步放同步中
	4. controller
		```
			//A调用
			serviceApi.sendMessage(message);
			//获得A的Future对象
			Future<String> sendFutureA = RpcContext.getContext().getFuture();
			//B调用
			serviceApiTwo.sendMessageTwo(message);
			//获得B的Future对象
			Future<String> sendFutureB = RpcContext.getContext().getFuture();
			//返回
			return sendFutureA.get()+sendFutureB.get(); 
		```

### 小贴士
   1.  @Reference(check = false)//让依赖检查关闭,可以先启消费者
   2.  @Service(timeout = 5000,loadbalance = "roundrobin|random|leastactive") //负载均衡策略
   3. dubbo底层协议(通信协议)有多种
		1. dubbo:单连接，长连接，tcp,nio异步传输: 数据包小(数据包小于100k),消费者个数多,常规方式
		2. RMI: 多连接，短连接，tcp,同步传输: 数据包大小不一样,消费者与提供者相差不大
		3. Hessian: 多连接，短连接，HTTP,同步传输: 数据包大小不一样,消费者与提供者相差不大
   4. dubbo默认超时200ms
   5. @Reference(cache = "lru|threadlocal")//开启缓存(最近最少未使用|多个Controller访问一个Service)
   6. 设置最大连接数,service与controller设置连接数作用不同
		* service层:dubbo.protocol.accepts=10 //最有只有10个Controller能调用
		* controller层:dubbo.consumer.connections=10 //最多中能有10个长连接(只能调用10个service)
   7. @Service(executes = 10) //设置服务端最大线程并发数量
   8. 分组(当一个Service的一个借口有多个实现类)
        * @Service(group = "组名,...")
        * @Reference(group = "组名,....")
