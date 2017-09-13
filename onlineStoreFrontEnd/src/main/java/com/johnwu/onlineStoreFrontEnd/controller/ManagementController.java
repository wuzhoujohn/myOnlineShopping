package com.johnwu.onlineStoreFrontEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnwu.onlineStoreBackEnd.dao.CategoryDAO;
import com.johnwu.onlineStoreBackEnd.dao.ProductDAO;
import com.johnwu.onlineStoreBackEnd.dto.Category;
import com.johnwu.onlineStoreBackEnd.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView model = new ModelAndView("home");
		
		model.addObject("userClickManageProducts", true);
		
		model.addObject("title", "Manage Products");
		
		Product product = new Product();
		
		product.setSupplierId(1);
		
		product.setActive(true);
		
		model.addObject("product", product);
		
		if(operation != null) {
			if(operation.equals("product")) {
				model.addObject("message", "Product Submitted Successfully");
			}
			
		}
		
		return model;
	}
	
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product product) {
	
		//create the newly created product record
		
		productDAO.add(product);
		
		
		return "redirect:/manage/products?operation=product";
	}
	//set a categories variable inside the model
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
		
	}
}
