package com.ceh.springboot7_6_3_2.controller;

import com.ceh.springboot7_6_3_2.domain.CehMessage;
import com.ceh.springboot7_6_3_2.domain.CehResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by enHui.Chen on 2017/9/18.
 */

@Controller
public class CehController {
    /**
     * @Author: enHui.Chen
     * @Description: 广播式(MessageMapping:url映射路径，SendTo：订阅了sendto路径的客户端将会接收到消息)
     * @Data 2017/9/18
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public CehResponse say(CehMessage cehMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new CehResponse("welcome:" + cehMessage.getName() + "!");
    }

    // 点对点式总结: 1.security的配置
    //              2.快速跳转的配置(包括chat页面)
    //              3.WebSocketCofig的配置(终端映射，消息代理)
    //              4.控制器的编写(需要注意的是注解是@MessageMapping)与SimpMessagingTemplate的注入

    /**
     * @Author: enHui.Chen
     * @Description: 点对点式
     * Principal：封装了当前用户信息
     * simpMessagingTemplate.convertAndSendToUser:第一个参数为接收消息的用户，第二个参数为订阅的url路径，第三个是消息
     * @Data 2017/9/18
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;// 通过该对象向浏览器发送消息
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String text) {
        if (principal.getName().equals("ceh")) {
            simpMessagingTemplate.convertAndSendToUser("hyy", "/queue/notifications",
                    principal.getName() + "-send:" + text);
        } else {
            simpMessagingTemplate.convertAndSendToUser("ceh", "/queue/notifications",
                    principal.getName() + "-send:" + text);
        }
    }
}
