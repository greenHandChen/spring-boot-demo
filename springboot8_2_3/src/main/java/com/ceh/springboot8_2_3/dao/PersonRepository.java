package com.ceh.springboot8_2_3.dao;

import com.ceh.springboot8_2_3.domain.Person;
import com.ceh.springboot8_2_3.support.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
public interface PersonRepository extends CustomRepository<Person, Long> {
    // 1.通过属性名来构造查询条件
    List<Person> findByName(String name);

    Person findByNameAndAddress(String name, String address);

    // 2.通过@QUERY注解构造查询SQL,参数通过名称进行绑定
    @Query("select p from Person p where p.name =:name and p.address=:address")
    Person queryByNameAndAddress(@Param("name") String name, @Param("address") String address);

    // 3.通过@NamedQuery注解来构造查询条件
    List<Person> withIdNamedQuery(Long id);

}
