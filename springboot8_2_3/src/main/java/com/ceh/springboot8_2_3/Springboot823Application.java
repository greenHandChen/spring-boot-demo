package com.ceh.springboot8_2_3;

import com.ceh.springboot8_2_3.support.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// 启用自定义的RepositoryFactoryBean
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Springboot823Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot823Application.class, args);
    }
}
