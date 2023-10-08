package com.kunpeng.dubbo.server;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(registry = {"beijing"},version = "1.0")
public class LoginServiceImpl2 implements ILoginService{
    @Autowired
    private TestSpring testSpring;
    public String login(String username, String password) {
        System.out.println("北京");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(username.equals("admin")&&password.equals("admin")){
            return "sucess";
        }
        return "false";
    }
}
