package com.johnwu.onlineStoreFrontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@RequestMapping(value ={ "/", "/home", "/index"}, method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("we are in home handlerMethod");
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "Zhou Wu");
		model.addObject("userClickHome", true);
		return model;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView model = new ModelAndView("about");
		model.addObject("userClickAbout", true);
		return model;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView model = new ModelAndView("contact");
		model.addObject("userClickContact", true);
		return model;
	}
	
}
