import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;

import model.services.DAOPerson;
import entity.Person;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

 
@ExtendWith(SpringExtension.class)
public class TestDaoPerson {

	@Autowired
    DAOPerson dao;  
    
	@Test
	public void testAutowiredAndInit() {
		System.out.println("testAutowired");
		System.out.println(dao.toString());
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
	
	/**
	 * error a voir plus tard
	 */
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
}