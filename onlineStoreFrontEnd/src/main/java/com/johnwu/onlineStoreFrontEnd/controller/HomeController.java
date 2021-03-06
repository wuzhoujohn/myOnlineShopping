package com.johnwu.onlineStoreFrontEnd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnwu.onlineStoreBackEnd.dao.CategoryDAO;
import com.johnwu.onlineStoreBackEnd.dao.ProductDAO;
import com.johnwu.onlineStoreBackEnd.dto.Category;
import com.johnwu.onlineStoreBackEnd.dto.Product;


@Controller
public class HomeController {

	//the autowired annotation is the spring framework dependency injection, so you
	// dont need to instantiate this class here. 
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value ={ "/", "/home", "/index"}, method = RequestMethod.GET)
	public ModelAndView home() {
		//System.out.println("we are in home handlerMethod");
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "home page");
		model.addObject("userClickHome", true);
		//passing the list of categories
		model.addObject("categories", categoryDAO.list());
		return model;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "about page");
		model.addObject("userClickAbout", true);
		return model;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "contact page");
		model.addObject("userClickContact", true);
		return model;
	}
	/*
	 * Methods to load all the products and products based on category
	 * */
	
	@RequestMapping(value = "/show/all/products", method = RequestMethod.GET)
	public ModelAndView showAllProducts() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("title", "all products");
		model.addObject("categories", categoryDAO.list());
		model.addObject("userClickAllProducts", true);
		return model;
	}
	
	@RequestMapping(value = "/show/category/{id}/products", method = RequestMethod.GET)
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("home");
		//categoryDAO to fetch a single category
		
		Category category = null;
		
		category = categoryDAO.get(id);
		
		model.addObject("title", category.getName());
		
		//passing the list of categories
		model.addObject("categories", categoryDAO.list());
		
		//passing the single category
		model.addObject("category", category);
		
		model.addObject("userClickCategoryProducts", true);
		return model;
	}
	
	/*
	 * viewing a single product
	 * */
	
	@RequestMapping(value = "/show/{id}/product", method = RequestMethod.GET)
	public ModelAndView showSingleProduct(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("home");
		Product product = productDAO.get(id);
		
		//update the count of view and then update the product
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		model.addObject("title", product.getName());
		model.addObject("product", product);
		model.addObject("userClickShowProduct", true);
		return model;
	}
	
	/*
	 * for login
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(name="error", required = false) String error,
				@RequestParam(name="logout", required = false) String logout) {
		ModelAndView model = new ModelAndView("login");	
		if(error != null){			
			model.addObject("message", "Invalid Username or password");
		}
		
		if(logout != null){			
			model.addObject("logout", "User has successfully logged out");
		}
		return model;
	}
	
	/*access denied page
	 * 
	 * */
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView("error");	
		model.addObject("title", "403 - Access Denied");
		model.addObject("errorTitle", "Wrong User And/Or password");
		model.addObject("errorDescription", "You are not authorized to view this page");
		return model;
	}
	
	/*
	 * log out handling*/
	
	@RequestMapping(value="/perform-logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		//fetch the authentication object
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
		

}
