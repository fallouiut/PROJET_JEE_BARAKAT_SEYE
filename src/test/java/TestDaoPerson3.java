


import org.junit.jupiter.api.AfterAll;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import config.SpringBusinessConfig;
import model.impl.DAOPersonImpl;
import model.services.DAOPerson;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import entity.Person;
import manager.IDirectoryManager;
 
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringBusinessConfig.class)
public class TestDaoPerson3 {

	@Autowired
    DAOPerson dao;  

	@Autowired
	IDirectoryManager manager;
    /*
	@Test
	public void testAutowiredAndInit() {
		System.out.println("testAutowired");
		System.out.println(dao.toString());
		System.out.println(manager.toString());
	}    
	
	@Test
	public void testSavePerson() {
		Person p = new Person();

		p.setFirstName("Fallou");
		p.setLastName("Seye");
		p.setMail("fallou.seye@etu.univ-amu.fr");
		p.setBirthDay(Date.valueOf("2020-04-11"));
		p.setWebSite("fallouseye.com");
		p.setPassWord("mot_de_passe");
		
		dao.save(p);
	}
	
	@Test 
	public void testUpdatePerson() {
		Person p = dao.find(1);
		
		p.setFirstName("Fallou_update");
		p.setLastName("Seye_update");
		p.setMail("fallou.seye@etu.univ-amu.fr_update");
		p.setBirthDay(Date.valueOf("2020-04-11"));
		p.setWebSite("fallouseye.com");
		p.setPassWord("mot_de_passe_update");
		
		dao.modifier(p);
		
	}
	
	@Test
	public void testDeletePerson() {
		Person p = new Person();

		p.setFirstName("Fallou");
		p.setLastName("Seye");
		p.setMail("fallou.seye@etu.univ-amu.fr");
		p.setBirthDay(Date.valueOf("2020-04-11"));
		p.setWebSite("fallouseye.com");
		p.setPassWord("mot_de_passe");
		
		dao.save(p);

	}
	
	
	@Test 
	public void getByEmail() {
		Person p = dao.findByEmail("fallou.seye@etu.univ-amu.fr");	
		System.out.println(p.toString());
	}
	
	@Test
	public void testLoginOK() {
		String email = "fallou.seye@etu.univ-amu.fr";
		String pw = "mot_de_passe_update";
		boolean logged = manager.login(email, pw);
		System.out.println("logged: " + logged);
		assertEquals(logged, true);
	}

	@Test
	public void testLoginBadEmail() {
		String email = "fallou@etu.univ-amu.fr";
		String pw = "mot";
		boolean logged = manager.login(email, pw);
		System.out.println("logged: " + logged);
		assertEquals(logged, false);
	}
	
	@Test
	public void testLoginBadPassword() {
		String email = "fallou.seye@etu.univ-amu.fr";
		String pw = "mot";
		boolean logged = manager.login(email, pw);
		System.out.println("logged: " + logged);
		assertEquals(logged, false);
	}
	*/
	
	@Test
	public void testPersonFindAdd() {		
		List<Person> all = (List) dao.findAll();
		int size = 0;
		if(all != null)
			size = all.size();
		
		assertEquals(true, size >= 2);
		
	}
}