package com.ceh.springboot7_6_3_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// websocket为浏览器和服务器提供了异步的双向通信功能。
// 即浏览器可向服务器发送消息，服务器也可向浏览器发送消息
@SpringBootApplication
public class Springboot7631Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot7631Application.class, args);
	}
}
