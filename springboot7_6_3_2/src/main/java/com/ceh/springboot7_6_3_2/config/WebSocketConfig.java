package com.ceh.springboot7_6_3_2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by enHui.Chen on 2017/9/18.
 */
@Configuration
// 开启基于stomp协议来传输数据
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * @Author: enHui.Chen
     * @Description: 注册终端的url映射
     * @Data 2017/9/18
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointCeh").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    /**
     * @Author: enHui.Chen
     * @Description: 配置消息代理
     * @Data 2017/9/18
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic");
    }

}
