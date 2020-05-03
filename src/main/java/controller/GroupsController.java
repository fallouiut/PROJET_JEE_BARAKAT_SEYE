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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import entity.Group;
import entity.Person;
import entity.User;
import manager.IDirectoryManager;

@Controller
@RequestMapping("groups/")
public class GroupsController {
	
	@Autowired
	private IDirectoryManager manager;
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    /*
     * Liste des groupes
     */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String treatConnectFormPage(HttpServletRequest request, ModelMap model, @Valid @ModelAttribute User user, BindingResult result) {   

    	if(request.getSession().getAttribute("user") != null) {
    		List<Group> groups = (List<Group>) manager.findAllGroups();
    		model.addAttribute("groups", groups);
        	return "groups/list";
    	} else {
    		return "error/loginError";
    	}
    }
    
    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
    public String getUserDescription(@PathVariable("groupId") int userId,
    		 HttpServletRequest request,ModelMap model) {
    	if(request.getSession().getAttribute("user") != null) {
    		Group found = manager.findGroup(null, userId);	
    		if(found == null) {
    			System.err.println("Not found");
    			return "error/groupNotFound";
    		} else {
    			model.addAttribute("group", found);
            	return "groups/description";
    		}    		
    	} else {
    		return "error/loginError";
    		// TODO renvoyer vers page erreur
    	}
    }
}