package com.ceh.springBootDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2017/9/14.
 */
@RestController
//springboot的核心注解 主要是为了开启springboot的默认配置
//该注解为组合注解
//集成了
//@SpringBootConfiguration:定义为springboot的配置类
//@EnableAutoConfiguration:开启springboot的自动配置
//@ComponentScan:该注解开启包的扫描，将会扫描当前类的同级包以及同级包下的所有子包
@SpringBootApplication
public class SpringBootDemoApplication {
    @Value("${book.author}")
    private String author;
     /**
       * @Author: enHui.Chen
       * @Description: 拦截请求路径为空的请求
       * @Data 2017/9/14
       */
    @RequestMapping("/")
    public String helloWorld(){
        return "helloWorld-By " + author;
    }

     /**
       * @Author: enHui.Chen
       * @Description: 启动项目
       * @Data 2017/9/14
       */
    public static void main(String[] args){
        SpringApplication.run(SpringBootDemoApplication.class,args);
    }
}
