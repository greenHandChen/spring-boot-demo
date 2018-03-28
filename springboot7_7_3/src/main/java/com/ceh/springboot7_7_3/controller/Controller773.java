package com.ceh.springboot7_7_3.controller;

import com.ceh.springboot7_7_3.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2017/9/19.
 */
@RestController
public class Controller773 {

     /**
       * @Author: enHui.Chen
       * @Description:
       * @Data 2017/9/19
       */
    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {
        return new Person(personName, 23, "shanghai");
    }
}
