package com.johnwu.onlineStoreFrontEnd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.johnwu.onlineStoreBackEnd.dao.UserDAO;
import com.johnwu.onlineStoreBackEnd.dto.Address;
import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.User;
import com.johnwu.onlineStoreFrontEnd.model.RegisterModel;

//@component to make the class as a bean
@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel registerModel){
		String transitionValue = "success";
		//fetch the user
		User user = registerModel.getUser();
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			
			cart.setUser(user);
			
			user.setCart(cart);
		}
		//save the user
		userDAO.addUser(user);
		//get the address
		Address billing = registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		//save the address
		userDAO.addAddress(billing);
		return transitionValue;
	}
}
