package com.ceh.springBootStarterHello.config;

/**
 * Created by enHui.Chen on 2017/9/15.
 */
//判断依据类
public class HelloService {
    private String msg;

    public String sayHello() {
        return "say: " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
