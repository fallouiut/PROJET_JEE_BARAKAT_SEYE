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

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IDirectoryManager manager;
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    /*
     * Traiter le formulaire de connexion
     */
    @RequestMapping(value="/description", method = RequestMethod.GET)
    public String getDescriptionPage(HttpServletRequest request, ModelMap model) { 
    	;
    	if(request.getSession().getAttribute("user") != null) {
    		Person person = ((User)request.getSession().getAttribute("user")).getRelatedPerson();
    		model.addAttribute("person", person);
    		return "persons/edit";
    	} else {
    		return "error/loginError";
    	}
    }
    
    /*
     * Traiter le formulaire de connexion
     */
    @RequestMapping(value="/description", method = RequestMethod.POST)
    public String treatDescruption(@ModelAttribute @Valid Person person, BindingResult result,
    		HttpServletRequest request, ModelMap model) {   
    	if(request.getSession().getAttribute("user") != null) {
    		
    		if(result.hasErrors()) {
    			return "persons/edit";
    		} else {
    			
    			Person current = ((User)request.getSession().getAttribute("user")).getRelatedPerson();

    			current.setEmail(person.getEmail());
    			current.setFirstName(person.getFirstName());
    			current.setLastName(person.getLastName());
    			current.setWebsite(person.getWebsite());
    			
    			manager.updatePerson(current);
    			
    			System.err.println(current);
    			
    			model.addAttribute("person", current);
    			model.addAttribute("successEdit", "Votre description a été modifiée avec succès");
    			// affichage message reconnexion
    			// afficha 
    			return "persons/description";
    		}
    	} else {
    		return "error/loginError";
    	}
    }
    
    @ModelAttribute
    public Person getPerson(@RequestParam(value = "firstName", required = false) String firstName,
    		 @RequestParam(value = "lastName", required = false) String lastName,
    		 @RequestParam(value = "website", required = false) String website,
    		 @RequestParam(value = "email", required = false) String email) {

    	System.err.println("ok");
    	
    	Person person = new Person();
    	person.setEmail(email);
    	person.setFirstName(firstName);
    	person.setLastName(lastName);
    	person.setWebsite(website);
    	
    	System.err.println(person);
    	
    	return person;
    }
    

}