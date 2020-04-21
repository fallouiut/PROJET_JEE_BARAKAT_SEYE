package controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("log/")
public class LogController {
	
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/connect", method = RequestMethod.GET)
    public String getHomePage() {
    	System.out.println("Demande du controleur main");
    	return "log/connect";
    }
}
