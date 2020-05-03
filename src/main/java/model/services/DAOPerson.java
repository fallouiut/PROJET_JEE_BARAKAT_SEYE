package model.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import entity.Person;

@Service
public interface DAOPerson extends DAO<Person> {

	public abstract Person findByEmail(String email);
	
	public abstract List<Person> findLike(String pattern);
}
