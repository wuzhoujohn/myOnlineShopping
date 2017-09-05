package com.johnwu.onlineStoreBackEnd.dao;

import java.util.List;

import com.johnwu.onlineStoreBackEnd.dto.Address;
import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.User;

public interface UserDAO {
	
	//get the user by email
	User getByEmail(String email);
	
	//add an user, a cart should be created automatically
	boolean addUser(User user);
	
	//add an address
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	
	List<Address> listShippingAddress(User user);
	
	
}	
