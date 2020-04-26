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
@Transactional
public class Manager implements IDirectoryManager {
	
	@Autowired
	private DAOPerson daoPerson;
	
	@Autowired 
	private DAOGroup daoGroup;
	
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
		// TODO Auto-generated method stub
		return this.daoGroup.find(groupId);
	}

	@Override
	public Collection<Person> findAllPersons(User user, long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String email, String password) {
		Person p = daoPerson.findByEmail(email);
		
		if(p.getMail().equals(email) && p.getPassWord().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void logout(User user) {
		user = null;	
	}

	@Override
	public void savePerson(User user, Person p) {
		// TODO Auto-generated method stub
		daoPerson.save(p);
	}

}
