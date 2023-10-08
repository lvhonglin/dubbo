package com.kunpeng.dubbo.controller;

import com.kunpeng.dubbo.server.ILoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @DubboReference(check = false,registry = {"beijing"},version = "2.0")
    public ILoginService loginService2;
    @DubboReference(check = false,registry = {"beijing"},version = "3.0",sticky = true,lazy = true,mock = "com.kunpeng.dubbo.service.MockService")
    public ILoginService loginService3;
    @DubboReference(check = false,sticky = true,registry = {"beijing"},version = "2.0",cluster = "failfast",mock = "com.kunpeng.dubbo.service.MockService")
    public ILoginService loginService1;
    @RequestMapping("/get")
    public String getGoods(){
        System.out.println("get");
        loginService1.login("1","2");
        return "1";
    }
    @RequestMapping("/get2")
    public String getGoods2(){
        System.out.println("get2");
        loginService2.login("1","2");
        return "2";
    }
    @RequestMapping("/get3")
    public String getGoods3(){
        System.out.println("get2");
        loginService3.login("1","2");
        return "2";
    }
}
