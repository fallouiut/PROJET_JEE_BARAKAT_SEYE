package model.impl;

import java.util.Collection;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Service;

import entity.Group;
import model.services.DAOGroup;

@Service
public class DAOGroupImpl implements DAOGroup {
	

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager em;


    @Override
	public Collection<Group> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Group object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(Group object) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void clearDatabase() {	   
		  
	}
}
