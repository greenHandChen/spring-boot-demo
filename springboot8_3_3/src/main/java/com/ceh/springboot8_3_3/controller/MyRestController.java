package com.ceh.springboot8_3_3.controller;

import com.ceh.springboot8_3_3.dao.PersonRepository;
import com.ceh.springboot8_3_3.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by enHui.Chen on 2017/9/20.
 */
@RestController
public class MyRestController {
/*    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/search")
    public List<Person> search(String name){
        return personRepository.findByNameStartsWith(name);
    }*/
}
