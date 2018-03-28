package com.ceh.springboot8_3_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 添加了starter-rest依赖后，springboot将会为我们自动配置rest服务、
// 若要修改默认的rest服务，则需要到application.properties中通过修改spring.data.rest前缀进行修改
@SpringBootApplication
public class Springboot833Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot833Application.class, args);
	}
}
