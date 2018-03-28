package com.ceh.springboot8_6_2.cache.cacheBean;

import com.ceh.springboot8_6_2.cache.cacheCommon.RedisStrCommonCache;
import com.ceh.springboot8_6_2.dto.Student;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */
public class StudentCache extends RedisStrCommonCache {
    @Override
    public boolean init() {
        loadData();
        return true;
    }

    public void loadData() {
        for (long i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("陈" + i);
            student.setScore("" + (i * 10));
            super.setValue("" + i, student);
        }
    }
}
