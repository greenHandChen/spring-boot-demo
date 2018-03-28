package com.ceh.springboot8_6_2.cache.cacheManager;

import com.ceh.springboot8_6_2.cache.cacheCommon.Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */
public class CacheManager {
    // key为缓存名-value为缓存
    private Map<String, Cache> cacheMap = new HashMap<>();
    // 记录所有缓存用于初始化
    private List<Cache> caches;

     /**
       * @Author: enHui.Chen
       * @Description: 加载缓存
       * @Data 2018/1/29 0029
       */
    public void setCaches(List<Cache> caches) {
        this.caches = caches;
        caches.forEach(cache -> {
            if (cache.init()) {
                cacheMap.put(cache.getCacheName(), cache);
            } else {
                System.out.println(cache.getCacheName());
            }
        });
    }

    public Map<String, Cache> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(Map<String, Cache> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public List<Cache> getCaches() {
        return caches;
    }
 /**
   * @Author: enHui.Chen
   * @Description: 根据key名获取缓存
   * @Data 2018/1/29 0029
   */
    public Cache getCacheByCacheName(String cacheName) {
        return cacheMap.get(cacheName);
    }
}
