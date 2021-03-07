package prac.PersonProj.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import prac.PersonProj.DAO.PersonDao;
import prac.PersonProj.DAO.PersonJPADao;
import prac.PersonProj.Model.Person;

@Service
public class PersonService {
	
//	private final PersonDao personDao;
//	
//	@Autowired
//	public PersonService(@Qualifier("postgres") PersonDao personDao) {
//		this.personDao=personDao;
//	}
//	
//	public int addPerson(Person person) {
//		return personDao.addPerson(person);
//	}
//	
//	public List<Person> getAllPeople(){
//		return personDao.selectAllPeople();
//	}
//	
//	public Optional<Person> getPersonById(UUID id){
//		return personDao.selectPersonById(id);
//	}
//	
//	public int deletePerson(UUID id) {
//		return personDao.deletePersonById(id);
//	}
//	
//	public int updatePerson(UUID id, Person person) {
//		return personDao.updatePersonById(id, person);
//	}
	
	@Autowired
	private PersonJPADao personJPADao;
	
	public List<Person> getAllPeople(){
		return personJPADao.findAll();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personJPADao.findById(id);
	}
	
	public void addPerson(Person person) {
		Person person1 = new Person(UUID.randomUUID(), person.getName());
		personJPADao.save(person1);
	}
	
	public void deletePerson(UUID id) {
		personJPADao.deleteById(id);
	}
	
	public void updatePerson(UUID id, Person person) {
		Person personToUpdate = personJPADao.getOne(id);
		personToUpdate.setName(person.getName());
		personJPADao.save(personToUpdate);
	}

}
