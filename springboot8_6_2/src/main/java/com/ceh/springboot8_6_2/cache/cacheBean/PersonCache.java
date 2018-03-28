package com.ceh.springboot8_6_2.cache.cacheBean;

import com.ceh.springboot8_6_2.cache.cacheCommon.RedisStrCommonCache;
import com.ceh.springboot8_6_2.dto.Person;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */
public class PersonCache extends RedisStrCommonCache<Person> {
    @Override
    public boolean init() {
        try {
            loadData();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

     /**
       * @Author: enHui.Chen
       * @Description: 模拟操作数据库
       * @Data 2018/1/29 0029
       */
    public void loadData() {
        for (long i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("陈" + i);
            person.setSex("男" + i);
            super.setValue("" + i, person);
        }
    }
}
