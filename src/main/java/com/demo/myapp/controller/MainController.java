package com.demo.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	// Example: returning index.jsp page
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("info", "its working");
		return "index";
	}

	// Example: returning model and .jsp page
	@GetMapping("/siteinfo")
	public String greeting(Model model) {
		model.addAttribute("name", "hello");
		return "siteinfo";
	}
	
	// Example: Another way
	// Returning View and Model
	@RequestMapping(value = { "/alldata" }, method = RequestMethod.GET)
	public ModelAndView listAllData() {
	    ModelAndView modelAndView = new ModelAndView("alldata");
	    modelAndView.addObject("data", "sample text");
	    return modelAndView;
	}
}
