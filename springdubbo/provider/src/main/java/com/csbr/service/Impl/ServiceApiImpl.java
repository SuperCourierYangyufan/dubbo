package com.csbr.service.Impl;

import com.csbr.service.ServiceApi;

/**
 * Created by YangYuFan on 2018/12/15.
 */
public class ServiceApiImpl implements ServiceApi {
    @Override
    public String sendMessage(String message) {
        return "this is "+message;
    }
}
