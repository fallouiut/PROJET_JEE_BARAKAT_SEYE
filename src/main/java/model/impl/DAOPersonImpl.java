package model.impl;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import entity.Person;
import entity.User;
import model.services.DAOPerson;

@Repository
@Service
public class DAOPersonImpl implements DAOPerson{

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager em;

	@Override
	public Collection<Person> findAll() {
		try {
			String query = "SELECT p FROM Person p";
	        TypedQuery<Person> q = em.createQuery(query, Person.class);
			return q.getResultList();
    	} catch (Exception e) {
    		System.err.println("dao error");
    		return null;
    	}
	}

	@Override
	public Person find(long id) {
		Person p = em.find(Person.class, id);
		System.out.println(p.toString());
		//System.out.println(" person retrouver" +" "+ p.getId());
		return p;
	}
	
	@Override
	public void save(Person object) {
		em.persist(object);	
		 //System.err.println("addPerson witdh id=" + object.getId());
	}

	@Override
	public void modifier(Person p) {		
		em.merge(p);			   
		//System.err.println("update of the person witdh id=" + p.getId() +" "+ p.getFirstName());   
	}
	
	@Override
	public void clearDatabase() {	   
		int nb = 0;
		nb += em.createQuery("DELETE FROM Person").executeUpdate();
		System.out.println(nb + " entities deleted");	     
	}

	@Override
	public Person findByEmail(String email) {
		try {
	        TypedQuery<Person> q = em.createNamedQuery("findByEmail", Person.class).setParameter("email", email);
	        System.err.println("Taille de l'ensemble retournée " + q.getResultList().size());
			return q.getSingleResult();
		} catch (Exception e) {
    		System.err.println("dao error");
    		System.err.println(e.getMessage());
    		e.printStackTrace();
    		
    		return null;
    	}
	}
}