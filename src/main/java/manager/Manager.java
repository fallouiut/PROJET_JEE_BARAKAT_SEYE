package manager;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Group;
import entity.Person;
import entity.User;
import model.impl.DAOPersonImpl;
import model.services.DAOGroup;
import model.services.DAOPerson;

@Service
public class Manager implements IDirectoryManager {
	
	@Autowired
	private DAOPerson daoPerson;
	
	@Autowired 
	private DAOGroup daoGroup;
	
	/**
	 * Pour eviter d'aller chercher une deuxieme fois si login == true
	 */
	private Person foundLogin;
	
	@Override
	public User newUser() {
		User user = new User();
		return user;
	}

	@Override
	public Person findPerson(User user, long personId) {
		// TODO Auto-generated method stub
		return this.daoPerson.find(personId);
	}

	@Override
	public Group findGroup(User user, long groupId) {

		Group g = this.daoGroup.find(groupId);
		return this.daoGroup.find(groupId);
	}

	@Override
	public Collection<Person> findAllPersons(User user, long groupId) {
		// TODO Auto-generated method stub
		return daoPerson.findAll();
	}

	@Override
	public boolean login(String email, String password) {
		Person p = daoPerson.findByEmail(email);
		
		if(p != null && p.getMail().equals(email) && p.getPassWord().equals(password)) {
			this.foundLogin = p;
			System.err.println("return true,");
			return true;
		}
		System.err.println("return fakse,");
		foundLogin = null;
		return false;
	}
	
	public Person getLoggedPerson() {
		return this.foundLogin;
	}

	@Override
	public void logout(User user) {
		user = null;	
		foundLogin = null;
	}
	
	public void tstring() {
		System.err.println("Dao: ");
		System.err.println(daoPerson.toString());
	}

	@Override
	public void savePerson(User user, Person p) {
		// TODO Auto-generated method stub
		daoPerson.save(p);
	}

}
