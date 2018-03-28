package com.ceh.springboot8_6_2.config;

import com.ceh.springboot8_6_2.cache.cacheBean.PersonCache;
import com.ceh.springboot8_6_2.cache.cacheBean.StudentCache;
import com.ceh.springboot8_6_2.cache.cacheCommon.Cache;
import com.ceh.springboot8_6_2.cache.cacheManager.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */
@Configuration
public class RedisConfiguration {

    /**
     * @Author: enHui.Chen
     * @Description: 配置jedis连接工厂
     * @Data 2018/1/29 0029
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    /**
     * @Author: enHui.Chen
     * @Description: 配置redisTemplate操作模板, 设置Key-value序列化方式
     * @Data 2018/1/29 0029
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate() throws UnknownHostException {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    /**
     * @Author: enHui.Chen
     * @Description: 配置cacheBean
     * @Data 2018/1/29 0029
     */
    @Bean
    public PersonCache personCache() {
        PersonCache personCache = new PersonCache();
        personCache.setCacheName("personCache");
        return personCache;
    }

    @Bean
    public StudentCache studentCache() {
        StudentCache studentCache = new StudentCache();
        studentCache.setCacheName("studentCache");
        return studentCache;
    }

    /**
     * @Author: enHui.Chen
     * @Description: 往cacheManager添加cacheBean，项目启动时将自动加载缓存
     * @Data 2018/1/29 0029
     */
    @Bean
    public CacheManager cacheManager() {
        CacheManager cacheManager = new CacheManager();
        List<Cache> caches = new ArrayList<>();
        caches.add(personCache());
        caches.add(studentCache());
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
