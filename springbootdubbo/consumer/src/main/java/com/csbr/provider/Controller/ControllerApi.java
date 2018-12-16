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

    @Reference(version = "1.0.0")
    ServiceApi serviceApi;

    @RequestMapping("/{message}")
    public String sendMessage(@PathVariable  String message){
        return serviceApi.sendMessage(message);
    }
}
