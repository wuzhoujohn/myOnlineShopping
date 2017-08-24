package com.johnwu.onlineStoreFrontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		//System.out.println("we are in admissionform ");
		ModelAndView model = new ModelAndView("home");
		return model;
	}
}
