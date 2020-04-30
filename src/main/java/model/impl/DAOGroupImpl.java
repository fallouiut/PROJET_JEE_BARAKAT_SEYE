package model.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import entity.Group;
import entity.Person;
import model.services.DAOGroup;

//@Repository
@Transactional
@Service
public class DAOGroupImpl implements DAOGroup {
	

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager emanager;


    @Override
	public Collection<Group> findAll() {
		try {
			String query = "SELECT g FROM Group g";
	        TypedQuery<Group> q = emanager.createQuery(query, Group.class);
			return q.getResultList();
    	} catch (Exception e) {
    		System.err.println("dao error");
    		return null;
    	}
	}
    
    @Transactional
	@Override
	public Group find(long id) {
    	try {
		Group g = emanager.find(Group.class, id);
		//g.getPerson().size();
		System.out.println("*** groupe n°" +" "+ g.getId() + " "+ g.getGroupName());
		return g;
    	} catch (Exception e) {
    		System.err.println("dao error");
    		return null;
    	}
	}
	
	@Transactional
	@Override
	public void save(Group object) {
		emanager.persist(object);	
		System.out.println("*** ajout d'une person au groupe id=" + object.getId() + " de nom: " + object.getGroupName());
	}
	

	@Transactional
	@Override
	public void modifier(Group g) {		
		emanager.merge(g);			   
		System.err.println("update of the group witdh id=" + g.getId() +" "+ g.getGroupName());   
	}
	
	@Override
	public void clearDatabase() {	   
		  //
	}
}
