package com.ceh.springboot7_6_3_1.domain;

/**
 * Created by enHui.Chen on 2017/9/18.
 */

// 用于接收服务器向浏览器发送的消息
public class CehResponse {
    private String responseMessage;

    public CehResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
