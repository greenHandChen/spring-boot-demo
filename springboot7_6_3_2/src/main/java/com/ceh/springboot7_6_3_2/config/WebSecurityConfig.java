package com.ceh.springboot7_6_3_2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by enHui.Chen on 2017/9/18.
 */
// springSecurity配置类
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     /**
       * @Author: enHui.Chen
       * @Description: 设置用户
       * @Data 2017/9/18
       */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("ceh").password("ceh").roles("USER")// 设置登录用户
                .and()
                .withUser("hyy").password("hyy").roles("USER");// 设置登录用户
    }

     /**
       * @Author: enHui.Chen
       * @Description: 设置静态资源不拦截路径
       * @Data 2017/9/18
       */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }

     /**
       * @Author: enHui.Chen
       * @Description: 设置请求拦截路径
       * @Data 2017/9/18
       */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()// 不拦截这两个请求路径
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")// 设置登录页面
                .defaultSuccessUrl("/chat").permitAll()// 设置登录成功后默认跳转页面
                .and()
                .logout().permitAll();
    }
}
