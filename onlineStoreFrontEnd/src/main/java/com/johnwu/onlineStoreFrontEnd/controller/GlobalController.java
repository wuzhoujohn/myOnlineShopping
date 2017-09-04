package com.johnwu.onlineStoreFrontEnd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.johnwu.onlineStoreBackEnd.dao.UserDAO;
import com.johnwu.onlineStoreBackEnd.dto.User;
import com.johnwu.onlineStoreFrontEnd.model.UserModel;

@ControllerAdvice
public class GlobalController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		if(session.getAttribute("userModel") == null){
			//add the userModel
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getByEmail(authentication.getName());
			
			if(user != null){
				//create a new userModel object to pass the user details
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				userModel.setRole(user.getRole());
				
				if(userModel.getRole().equals("USER")){
					//set the cart if the user is a buyer
					userModel.setCart(user.getCart());
				}
				
				//set the userModel in the session.
				
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
