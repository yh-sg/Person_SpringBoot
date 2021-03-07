package prac.PersonProj.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prac.PersonProj.Model.Person;

public interface PersonJPADao extends JpaRepository<Person, UUID> {

}