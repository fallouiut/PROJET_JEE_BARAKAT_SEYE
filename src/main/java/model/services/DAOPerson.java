package model.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import entity.Person;

@Service
public interface DAOPerson extends DAO<Person> {

}
