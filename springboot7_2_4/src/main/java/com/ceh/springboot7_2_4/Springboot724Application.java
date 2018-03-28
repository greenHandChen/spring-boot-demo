package com.ceh.springboot7_2_4;

import com.ceh.springboot7_2_4.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Springboot724Application {
	@RequestMapping("/")
	public String helloWorld(Model model){
		Person singlePerson = new Person();
		singlePerson.setName("陈");
		singlePerson.setId(12761L);
		List<Person> list = new ArrayList<Person>();
		Person person1 = new Person();
		person1.setName("陈");
		person1.setId(12761L);
		Person person2 = new Person();
		person2.setName("恩");
		person2.setId(12761L);
		Person person3 = new Person();
		person3.setName("慧");
		person3.setId(12761L);
		list.add(person1);
		list.add(person2);
		list.add(person3);
		model.addAttribute("singlePerson",singlePerson);
		model.addAttribute("people",list);
		return "helloWorld";
	}
	public static void main(String[] args) {
		SpringApplication.run(Springboot724Application.class, args);
	}
}
