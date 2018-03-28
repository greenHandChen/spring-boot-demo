package com.ceh.springboot8_2_3.support;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;
import java.io.Serializable;

import static com.ceh.springboot8_2_3.specs.CustomerSpecs.byAuto;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
public class CustomRepositoryImpl <T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {
    private final EntityManager entityManager;
    public CustomRepositoryImpl(Class<T> domainClass,EntityManager entityManager){
        super(domainClass,entityManager);
        this.entityManager = entityManager;
    }

     /**
       * @Author: enHui.Chen
       * @Description: 该方法使用byAuto中已经构造好的查询条件，并提供分页功能
       * @Data 2017/9/20
       */
    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example), (org.springframework.data.domain.Pageable) pageable);
    }
}
