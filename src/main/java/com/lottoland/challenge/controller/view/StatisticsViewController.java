package com.lottoland.challenge.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A simple controller that renders the statistics view.
 */
@Controller
public class StatisticsViewController {
	    @RequestMapping(value = "/statistics")
	    public String index() {
	        return "statistics";
	    }
}
