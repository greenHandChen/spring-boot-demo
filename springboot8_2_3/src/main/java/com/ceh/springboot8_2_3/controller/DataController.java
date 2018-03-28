package com.ceh.springboot8_2_3.controller;

import com.ceh.springboot8_2_3.dao.PersonRepository;
import com.ceh.springboot8_2_3.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
@RestController
public class DataController {
    /**
     * @Author: enHui.Chen
     * @Description: 保存:save支持批量保存
     * 删除:支持使用id进行删除以及批量删除
     * @Data 2017/9/20
     */
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person savePerson(String name, String address, Long age) {
        Person person = personRepository.save(new Person(null, name, age, address));
        return person;
    }

     /**
       * @Author: enHui.Chen
       * @Description: 通过属性名称构造查询条件
       * @Data 2017/9/20
       */
    @RequestMapping("/findByName")
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    /**
     * @Author: enHui.Chen
     * @Description: 通过属性名称构造查询条件
     * @Data 2017/9/20
     */
    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name,String address) {
        return personRepository.findByNameAndAddress(name,address);
    }

     /**
       * @Author: enHui.Chen
       * @Description: 通过@QUERY注解来构造查询条件，参数按照名称进行注入
       * @Data 2017/9/20
       */
    @RequestMapping("/queryByNameAndAddress")
    public Person queryByNameAndAddress(String name,String address) {
        return personRepository.queryByNameAndAddress(name,address);
    }

     /**
       * @Author: enHui.Chen
       * @Description: 通过@NAMEDQUERY注解来构造查询条件
       * @Data 2017/9/20
       */
    @RequestMapping("/withIdNamedQuery")
    public List<Person> withIdNamedQuery(Long id){
        return personRepository.withIdNamedQuery(id);
    }

     /**
       * @Author: enHui.Chen
       * @Description: 通过某个字段进行排序
       * @Data 2017/9/20
       */
    @RequestMapping("/sort")
    public List<Person> sort(String sortField){
        return personRepository.findAll(new Sort(Sort.Direction.DESC,sortField));
    }

     /**
       * @Author: enHui.Chen
       * @Description: 分页测试
       * @Data 2017/9/20
       */
    @RequestMapping("/page")
    public Page<Person> page(){
        return personRepository.findAll(new PageRequest(1,3));
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person){
        return personRepository.findByAuto(person,new PageRequest(0,10));
    }
}
