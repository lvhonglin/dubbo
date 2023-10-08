package com.kunpeng.dubbo.server;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@DubboService(registry = {"beijing"},version = "2.0",weight = 26 )
public class LoginServiceImpl implements ILoginService{
    @Autowired
    private TestSpring testSpring;
    public String login(String username, String password) {
        System.out.println("啥玩意是啊");
        int a=1/0;
        System.out.println(33334);

        return "succ";
    }
}
