package com.csbr;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by YangYuFan on 2018/12/15.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}
