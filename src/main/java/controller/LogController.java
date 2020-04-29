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
@RequestMapping("log/")
public class LogController {
	
	@Autowired
	private IDirectoryManager manager;
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    /*
     * Traiter le formulaire de connexion
     */
    @RequestMapping(value="/connect", method = RequestMethod.POST)
    public String treatConnectFormPage(HttpServletRequest request, ModelMap model, @Valid @ModelAttribute User user, BindingResult result) {   
    	if(result.hasErrors()) {
    		return "log/connect";
    	} else {
    		if(manager.login(user.getEmail(), user.getPassword())) {
    			System.err.println("Tout est ok");
    			return "log/connect";
			} else {
				model.addAttribute("loginError", "Erreur dans l'authentification. Veuillez réessayer");
		    	return "log/connect";
    		}
    	}
    }

    /*
     * Renvoyer la page de connexion
     */
    @RequestMapping(value="/connect", method = RequestMethod.GET)
    public String getConnectFormPage() {
    	return "log/connect";
    }

    @ModelAttribute
    public User getUser(
    		@RequestParam(value = "email", required = false) String email, 
    		@RequestParam(value = "password", required = false) String password) {
    	User user = new User();
		user.setEmail(email);
		user.setPassword(password);
    	
    	return user;
    }
}