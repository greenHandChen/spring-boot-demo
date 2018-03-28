package com.ceh.springboot8_2_3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
// 正向工程:当为正向工程时，实体类的注解为@Entity,属性不需要加@Column注解(正向工程:通过实体类维护表结构)
// 逆向工程:当为逆向工程时，实体类的注解为@Table，属性需要加@Column注解(逆向工程:通过表结构维护实体类)
@Entity
//通过@NamedQuery注解来构造查询条件,表名的首字母一定要大写
@NamedQuery(name = "Person.withIdNamedQuery",
        query = "select p from Person p where p.id=?1")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long age;
    private String address;

    public Person() {
        super();
    }

    public Person(Long id, String name, Long age, String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
