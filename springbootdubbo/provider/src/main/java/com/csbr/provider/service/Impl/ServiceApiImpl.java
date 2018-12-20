package com.csbr.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csbr.provider.service.ServiceApi;
import org.springframework.stereotype.Component;

/**
 * Created by YangYuFan on 2018/12/15.
 */
@Component
@Service(timeout = 5000,loadbalance = "roundrobin")
public class ServiceApiImpl implements ServiceApi{
    @Override
    public String sendMessage(String message) {
        return "this is "+message;
    }
}
