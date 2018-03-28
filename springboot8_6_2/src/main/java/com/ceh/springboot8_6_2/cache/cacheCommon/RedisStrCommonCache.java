package com.ceh.springboot8_6_2.cache.cacheCommon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */

public class RedisStrCommonCache<T> implements Cache<T> {
    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${cux.redis.category}")
    private String category;

    private String cacheName;

    // 泛型只存在于编译期间，在运行时泛型将被擦除（记录泛型）
    private Class<T> entityClass;

    private ObjectMapper objectMapper = new ObjectMapper();

    public boolean init() {
        return false;
    }

    public void setValue(String field, T value) {
        redisTemplate.execute((RedisCallback) connection -> {
            try {
                this.hSet(connection, field, value);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public void delete(String field) {
        redisTemplate.execute((RedisCallback) connection -> {
            try {
                this.hdelete(connection, field);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public T getValue(String field) {
        return (T) redisTemplate.execute((RedisCallback<T>) connection -> {
            try {
                return this.hget(connection, field);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public void hSet(RedisConnection connection, String field, T obj) throws JsonProcessingException {
        connection.hSet(this.getSerializer().serialize(this.getCacheFullName()), this.getSerializer().serialize(field),
                this.objectMapper.writeValueAsBytes(obj));
    }

    public T hget(RedisConnection connection, String field) throws IOException {
        byte[] entityBytes = connection.hGet(this.getSerializer().serialize(this.getCacheFullName()),
                this.getSerializer().serialize(field));
        if (entityBytes != null) {
            return this.objectMapper.readValue(entityBytes, this.entityClass);
        }
        return null;
    }

    public void hdelete(RedisConnection connection, String field) throws JsonProcessingException {
        connection.hDel(this.getSerializer().serialize(this.getCacheFullName()), this.getSerializer().serialize(field));
    }

    public String getCacheFullName() {
        this.category = StringUtils.isEmpty(this.category) ? "default" : this.category;
        return this.category + ":" + cacheName;
    }

    public RedisSerializer getSerializer() {
        return redisTemplate.getStringSerializer();
    }


    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}
