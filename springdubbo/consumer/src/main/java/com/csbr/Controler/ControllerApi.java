package com.csbr.Controler;

import com.csbr.service.ServiceApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by YangYuFan on 2018/12/15.
 */
public class ControllerApi {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-consumer.xml");

        context.start();

        while(true){
            Scanner scanner = new Scanner(System.in);
            String message = scanner.next();

            ServiceApi  serviceApi = (ServiceApi)context.getBean("serviceApi");
            System.out.println(serviceApi.sendMessage(message));
        }
    }
}
