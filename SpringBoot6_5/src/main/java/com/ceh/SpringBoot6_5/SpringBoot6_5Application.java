package com.ceh.SpringBoot6_5;

import com.ceh.springBootStarterHello.config.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2017/9/15.
 */
@RestController
@SpringBootApplication
public class SpringBoot6_5Application {
    @Autowired
    HelloService helloService;
    @RequestMapping("/")
    public String helloWorld(){
        return helloService.sayHello();
    }
    public static void main(String[] args){
        SpringApplication.run(SpringBoot6_5Application.class,args);
    }
}
