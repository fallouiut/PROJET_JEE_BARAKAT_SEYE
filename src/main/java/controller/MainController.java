package controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class MainController {
	
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage() {
    	logger.info("\u001B[34m Demande du controlleur main");
    	System.out.println("Demande du controleur main \u001B[0m");
    	return "index";
    }
}