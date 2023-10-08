package com.kunpeng.dubbo.service;

import com.kunpeng.dubbo.server.ILoginService;

public class MockService implements ILoginService {
    @Override
    public String login(String username, String password) {
        System.out.println("调mock了");
        return "dadasd111d1dd1d1";

    }
}
