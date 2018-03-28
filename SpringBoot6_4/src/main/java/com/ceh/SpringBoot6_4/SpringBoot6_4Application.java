package com.ceh.SpringBoot6_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2017/9/14.
 */
//6.4Profile配置
@RestController
@SpringBootApplication
public class SpringBoot6_4Application {
    public static void main(String[] args){
        SpringApplication.run(SpringBoot6_4Application.class,args);
    }
}
