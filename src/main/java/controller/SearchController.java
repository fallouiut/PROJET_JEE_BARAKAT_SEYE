package controller;


import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Person;
import entity.SearchQuery;
import manager.IDirectoryManager;

@Controller
@RequestMapping("search/")
public class SearchController {
	
	@Autowired
	IDirectoryManager manager;
	
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/use", method = RequestMethod.GET)
    public String getSearchPage(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") != null) {
	    	System.err.println("ok");
	    	return "search/main"; 
    	} else {
    		return "error/loginError";
    	}
    }
   
    @RequestMapping(value = "/use", method = RequestMethod.POST) 
    public String userReseach(HttpServletRequest request, @Valid @ModelAttribute SearchQuery searchQuery, ModelMap model, BindingResult result) {
    	if(request.getSession().getAttribute("user") != null) {
    		if(result.hasErrors() || searchQuery.getQuery().length() <= 0) {
	    		model.addAttribute("searchError", "Votre requête est mauvaise, veuillez recommencer");
	    		return "search/main";
	    	} else {
	    		// va faire une requete pour chaque mot  composant la requete
	    		Collection<Person> persons = manager.findPersonsLike(searchQuery.getQuery());
	    		model.addAttribute("lastQuery", searchQuery.getQuery());
	    		model.addAttribute("persons", persons);
	    		return "search/main";
	    	}
    	} else {
    		return "error/loginError";
    	}
    }
    
    /**
     * Construction paramètre controleur /search
     * @param query
     * @return
     */
    @ModelAttribute
    public SearchQuery getQuery(@RequestParam(value = "query", required = false) String query) {
    	SearchQuery searchQuery = new SearchQuery();
    	searchQuery.setQuery(query);
    	return searchQuery;
    }
}