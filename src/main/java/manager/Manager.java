package manager;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	public Collection<Group> findAllGroups() {
		// TODO Auto-generated method stub
		return daoGroup.findAll();
	}

	@Override
	public boolean login(String email, String password) {
		Person p = daoPerson.findByEmail(email);
		
		if(p != null && p.getEmail().equals(email) && p.getPassWord().equals(password)) {
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
	
	@Override
	public Collection<Person> findPersonsLike(String query) {
		Set<Person> persons = new HashSet<>();
		
		String[] words = query.split(" ");
		
		int i = 0;
		for(String word: words) {
			++i;
			List<Person> tournée = daoPerson.findLike(word);
			System.out.println(">Tournée " + i + ", " + tournée.size() + " personnes");
			persons.addAll(tournée);
		}
		
		System.err.println("Taille totale" + persons.size());
		
		return persons;
	}
	
	@Override
	public void updatePerson(Person p) {
		daoPerson.modifier(p);
	}

}
