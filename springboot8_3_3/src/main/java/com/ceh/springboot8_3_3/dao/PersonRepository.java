package com.ceh.springboot8_3_3.dao;

import com.ceh.springboot8_3_3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

    @RestResource(path="nameStartsWith" ,rel="nameStartsWith")
    List<Person> findByNameStartsWith(@Param("name") String name);
}
