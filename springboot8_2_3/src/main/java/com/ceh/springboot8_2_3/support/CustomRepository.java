package com.ceh.springboot8_2_3.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
// 声明自定义的Repository，而非实体类的Repository
    // 继承JpaSpecificationExecutor使我们获得使用Specification的能力
@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    Page<T> findByAuto(T example, Pageable pageable);
}
