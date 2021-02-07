package prac.PersonProj.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prac.PersonProj.Model.Person;
import prac.PersonProj.Service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	
	@Autowired
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService=personService;
	}
	
	//@PostMapping
	@RequestMapping(method = RequestMethod.POST)
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getPerson() {
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id)
				.orElse(null);
	}
	
	
}
