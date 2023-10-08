package com.kunpeng.dubbo.server;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(registry = {"beijing"},version = "3.0",timeout = 1000000,retries = 0,methods = {@Method(name = "login",executes = 3)})
public class LoginServiceImpl3 implements ILoginService{
    @Autowired
    private TestSpring testSpring;
    public String login(String username, String password) {
        System.out.println("start:"+Thread.currentThread().getName());
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            System.out.println("异常了");
            throw new RuntimeException(e);
        }
        System.out.println("over:"+Thread.currentThread().getName());
        if(username.equals("admin")&&password.equals("admin")){
            return "sucess";
        }
        return "false";
    }
}
