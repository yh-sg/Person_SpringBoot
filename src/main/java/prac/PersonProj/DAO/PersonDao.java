package prac.PersonProj.DAO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import prac.PersonProj.Model.Person;

public interface PersonDao{
	
	List<Person> selectAllPeople();
	
	Optional<Person> selectPersonById(UUID id);
	
	int insertPerson(UUID id, Person person);
	
	int deletePersonById(UUID id);
	
	int updatePersonById(UUID id, Person person);
	
	default int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
}
