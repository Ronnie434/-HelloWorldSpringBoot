package com.HelloWorld.Example.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HelloWorld.Example.model.Person;
import com.HelloWorld.Example.service.PersonService;

@RestController
public class HelloController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String start() {
		return "This is main page or Dashboard.";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World RESTful with Spring Boot ....";
	}
	
	
	@GetMapping("/list")
	public List<Person> list(){
		return personService.getAllPerson();
				
	}
	
	@GetMapping("/list/{name}")
	public Person getPerson(@PathVariable String name) {
		return personService.getPerson(name);
	}
	
	@PostMapping("/list")
	public void appPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@PutMapping("/list/{name}")
	public void updatePerson(@RequestBody Person person, @PathVariable String name) {
		personService.updatePerson(name, person);
	}

	@DeleteMapping("/list/{name}")
	public void deletePerson(@PathVariable String name) {
		personService.deletePerson(name);
	}
}
