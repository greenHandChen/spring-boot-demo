package com.ceh.springBootStarterHello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by enHui.Chen on 2017/9/15.
 */
//配置类
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
