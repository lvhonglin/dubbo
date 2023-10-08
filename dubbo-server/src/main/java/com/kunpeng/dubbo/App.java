package com.kunpeng.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
//        LoadBalance myLoadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class)
//                .getExtension("myLoadBalance");
//        System.out.println(myLoadBalance);
    }
}
