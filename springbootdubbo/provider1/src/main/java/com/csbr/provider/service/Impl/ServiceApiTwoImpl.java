package com.csbr.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csbr.provider.service.ServiceApiTwo;
import org.springframework.stereotype.Component;

/**
 * Created by YangYuFan on 2018/12/21.
 */
@Component
@Service(timeout = 1000000,async = true)
public class ServiceApiTwoImpl implements ServiceApiTwo {
    @Override
    public String sendMessageTwo(String message) {
        try {
            System.out.println(message);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sure "+message;
    }
}
