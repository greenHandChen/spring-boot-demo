package com.ceh.springboot7_6_3_1.controller;

import com.ceh.springboot7_6_3_1.domain.CehMessage;
import com.ceh.springboot7_6_3_1.domain.CehResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by enHui.Chen on 2017/9/18.
 */
@Controller
public class CehController {
     /**
       * @Author: enHui.Chen
       * @Description: MessageMapping:url映射路径，SendTo：订阅了sendto路径的客户端将会接收到消息
       * @Data 2017/9/18
       */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public CehResponse say(CehMessage cehMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new CehResponse("welcome:" + cehMessage.getName() + "!");
    }
}
