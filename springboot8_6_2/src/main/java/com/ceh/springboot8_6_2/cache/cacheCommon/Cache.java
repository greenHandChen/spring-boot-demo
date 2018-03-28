package com.ceh.springboot8_6_2.cache.cacheCommon;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */
public interface Cache<T> {
    boolean init();

    void setValue(String field, T value);

    T getValue(String field);

    void delete(String field);

    void setCacheName(String cacheName);

    String getCacheName();
}
