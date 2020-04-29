package model.services;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface DAO<T> {
	
	   Collection<T> findAll();

	   T find(long id);

	   void save(T object);
	   
	   void modifier(T object); 
	   
	   void clearDatabase();
}
