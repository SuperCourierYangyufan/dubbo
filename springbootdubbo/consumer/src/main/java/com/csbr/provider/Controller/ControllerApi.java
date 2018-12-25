package com.csbr.provider.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csbr.provider.service.ServiceApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YangYuFan on 2018/12/15.
 */
@RestController
public class ControllerApi {

    @Reference(check = false,async = true,group = "B")//让依赖检查关闭,可以先启消费者
    ServiceApi serviceApi;

    @RequestMapping("/{message}")
    public String sendMessage(@PathVariable String message){
        return serviceApi.sendMessage(message);
    }


//    @Reference(async = true,cache = "lru")
//    ServiceApiTwo serviceApiTwo;

//    @RequestMapping("/{message}")
//    public String sendMessage(@PathVariable  String message) throws ExecutionException, InterruptedException {
//        //开始计时
//        long beginTime = System.currentTimeMillis();
//        //A调用
//        serviceApi.sendMessage(message);
//        //获得A的Future对象
//        Future<String> sendFutureA = RpcContext.getContext().getFuture();
//        //B调用
//        serviceApiTwo.sendMessageTwo(message);
//        //获得B的Future对象
//        Future<String> sendFutureB = RpcContext.getContext().getFuture();
//        //结束
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-beginTime);
//        return sendFutureA.get()+sendFutureB.get();
//    }
}
