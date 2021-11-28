package com.lottoland.challenge.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A simple controller that renders the main view of the application.
 */
@Controller
public class IndexViewController {
	    @RequestMapping(value = "/")
	    public String index() {
	        return "index";
	    }
}
