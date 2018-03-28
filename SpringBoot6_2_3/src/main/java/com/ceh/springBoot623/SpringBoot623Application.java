package com.ceh.springBoot623;

import com.ceh.springBoot623.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2017/9/14.
 */
// 6.2.3类型安全的配置(基于properties),
// 通过@ConfigurationProperties注解将properties属性与Bean进行关联，完成安全配置
@RestController// 集成了responsebody与controller注解 所以返回的只是数据
@SpringBootApplication
public class SpringBoot623Application {
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String authorSettings() {
        return "name:" + authorSettings.getName() + ",age:" + authorSettings.getAge();
    }
    public static void main(String[] args){
        SpringApplication.run(SpringBoot623Application.class,args);
    }
}
