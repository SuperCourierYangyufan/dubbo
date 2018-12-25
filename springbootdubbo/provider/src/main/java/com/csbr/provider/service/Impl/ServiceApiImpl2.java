package com.csbr.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csbr.provider.service.ServiceApi;
import org.springframework.stereotype.Component;

/**
 * Created by YangYuFan on 2018/12/15.
 */
@Component
@Service(timeout = 5000,loadbalance = "roundrobin",group = "B")
public class ServiceApiImpl2 implements ServiceApi{
    @Override
    public String sendMessage(String message) {
        try {
            System.out.println("this is 2 "+message);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this is "+message;
    }
}
