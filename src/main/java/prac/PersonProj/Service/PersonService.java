package prac.PersonProj.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import prac.PersonProj.DAO.PersonDao;
import prac.PersonProj.Model.Person;

@Service
public class PersonService {
	
	private final PersonDao personDao;
	
	@Autowired
	public PersonService(@Qualifier("postgres") PersonDao personDao) {
		this.personDao=personDao;
	}
	
	public int addPerson(Person person) {
		return personDao.addPerson(person);
	}
	
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person person) {
		return personDao.updatePersonById(id, person);
	}
}
