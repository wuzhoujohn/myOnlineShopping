package com.johnwu.onlineStoreBackEnd.dao;

import com.johnwu.onlineStoreBackEnd.dto.Address;
import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.User;

public interface UserDAO {
	//add an user
	boolean addUser(User user);
	
	//add an address
	boolean addAddress(Address address);
	
	//add a cart
	boolean addCart(Cart cart);
}	
