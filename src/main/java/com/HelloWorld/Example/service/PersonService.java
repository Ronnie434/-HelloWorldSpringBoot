package com.HelloWorld.Example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.HelloWorld.Example.model.Person;

@Service
public class PersonService {
	
	private List<Person> persons = new ArrayList<>(Arrays.asList(
			new Person("Ronak", 24, "Software"),
			new Person("Halak", 24, "Hardware"),
			new Person("Anjali", 22, "Accounting")
			));
	
	public List<Person> getAllPerson(){
		return persons;
	}
	
	public Person getPerson(String name) {
		return persons.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void addPerson(Person person) {
		persons.add(person);
		
	}

	public void updatePerson(String name, Person person) {
		for(int i=0; i<persons.size(); i++) {
			Person p = persons.get(i);
			if(p.getName().equals(name)) {
				persons.set(i, person);
			}
		}
		
	}

	public void deletePerson(String name) {
		persons.removeIf(p -> p.getName().equals(name));
		
	}
}
