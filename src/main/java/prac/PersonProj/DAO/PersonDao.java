package prac.PersonProj.DAO;

import java.util.List;
import java.util.UUID;

import prac.PersonProj.Model.Person;

public interface PersonDao {
	int insertPerson(UUID id, Person person);
	
	default int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> selectAllPeople();
}
