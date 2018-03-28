package com.ceh.springboot7_6_3_2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by enHui.Chen on 2017/9/18.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toHello").setViewName("/helloWorld");
        // 必须配置快速跳转
        registry.addViewController("/login").setViewName("/login");
        // 必须配置快速跳转
        registry.addViewController("/chat").setViewName("/chat");
    }
}
