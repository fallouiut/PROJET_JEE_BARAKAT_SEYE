package controller;


import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import entity.Person;
import entity.User;
import manager.IDirectoryManager;
import model.services.DAOGroup;
import model.services.DAOPerson;

@Controller
@RequestMapping("test/")
public class TestController {
	
	@Autowired
	private IDirectoryManager manager;
	
	@Autowired
	DAOPerson daoFallou;
	
	@Autowired
	DAOGroup daoJulien;
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    @RequestMapping(value = "/fallou", method = RequestMethod.GET)
    public String testFallou() {
    	List<Person> p = (List<Person>) manager.findAllPersons(null, 1);

    	System.err.println("Taille " + p);
    	
    	return "index";
    }
    
    @RequestMapping(value = "/julien", method = RequestMethod.GET)
    public String testJulien() {

    	/**
    	 * Test les DAO en faisant marcher spring boot
    	 * donc en lançant Starter.java et en appelant cette methdoe
    	 * localhost:8080/test/julien
    	 * et tu affiche les resultat  pour que DaoGroup marche bien en faisant
    	 * System.err
    	 */
    	return "index";
    }
}