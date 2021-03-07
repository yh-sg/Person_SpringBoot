package prac.PersonProj.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import prac.PersonProj.Model.Person;

@Repository("fakeDao")
public class FakePersonDataService implements PersonDao {

	private static List<Person> DB = new ArrayList<>();
	
	static {
		DB.add(new Person(UUID.randomUUID(),"Kyaru"));
		DB.add(new Person(UUID.randomUUID(),"Rei"));
		DB.add(new Person(UUID.randomUUID(),"Kuroe"));
	}
	
	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}
	
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}

	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personSelected = selectPersonById(id);
		if(personSelected.isEmpty()) {
			return 0;
		}
		DB.remove(personSelected.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return selectPersonById(id)
				.map(p->{
					int indexOfPersonToUpdate = DB.indexOf(p);
					if(indexOfPersonToUpdate >= 0) {
						DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}
	
}
