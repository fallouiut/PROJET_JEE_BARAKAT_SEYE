package controller;


import java.net.http.HttpRequest;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import manager.IDirectoryManager;

@Controller
@RequestMapping("log/")
public class LogController {
	
	@Autowired
	private IDirectoryManager manager;
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    /*
     * Traiter le formulaire de connexion
     */
    @RequestMapping(value="/connect", method = RequestMethod.POST)
    public String treatConnectFormPage(@Valid @ModelAttribute User user, BindingResult result) {   
		System.err.println("Salut"); 	
    	if(result.hasErrors()) {
    		System.err.println("Error");
    		return "log/connect";
    	} else {
    		System.out.println(user.toString());
    		System.out.println("Tout est ok");
    	}
    	return "log/connect";
    }

    /*
     * Renvoyer la page de connexion
     */
    @RequestMapping(value="/connect", method = RequestMethod.GET)
    public String getConnectFormPage() {
    	System.err.println(manager.toString());
    	System.err.println("Demande du controleur main");
    	return "log/connect";
    }
    
    @ModelAttribute
    public User getUser(
    		@RequestParam("email") String email, 
    		@RequestParam("password") String password) {

    	System.err.println("Email: " + email);
    	System.err.println("Password: " + password);
    	
    	User user = new User();
		user.setEmail(email);
		user.setPassword(password);
    	
    	return user;
    }
}
