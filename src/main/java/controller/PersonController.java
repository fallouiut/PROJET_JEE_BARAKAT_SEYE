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
@RequestMapping("persons/")
public class PersonController {
	
	@Autowired
	private IDirectoryManager manager;
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    /*
     * Traiter le formulaire de connexion
     */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String treatConnectFormPage(HttpServletRequest request, ModelMap model, @Valid @ModelAttribute User user, BindingResult result) {   

    	if(request.getSession().getAttribute("user") != null) {
    		List<Person> persons = (List<Person>) manager.findAllPersons(null, 0);
    		model.addAttribute("persons", persons);
        	return "persons/list";
    	} else {
    		return "error/loginError";
    		// TODO renvoyer vers page erreur
    	}
		
    }

}