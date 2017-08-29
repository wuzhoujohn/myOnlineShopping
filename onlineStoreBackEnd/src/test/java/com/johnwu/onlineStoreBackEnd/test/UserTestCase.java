package com.johnwu.onlineStoreBackEnd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnwu.onlineStoreBackEnd.dao.UserDAO;
import com.johnwu.onlineStoreBackEnd.dto.Address;
import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.johnwu.onlineStoreBackEnd");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd(){
		user = new User();
		user.setFirstName("Johnny");
		user.setLastName("Dep");
		user.setEmail("abcde@gmail.com");
		user.setContactNumber("1234234");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("added user", true, userDAO.addUser(user));
		
		//create a billing address for the user
		address = new Address();
		address.setAddressLineOne("1000 Yonge Street");
		address.setAddressLineTwo("unit 1406");
		address.setCity("Toronto");
		address.setPostalCode("m2l 0r1");
		address.setProvince("ON");
		address.setBilling(true);
		address.setCountry("Canada");
		
		//link the user with the address
		
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("added address", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			//create a cart for this user
			cart = new Cart();
			
			//link the cart with the user
			cart.setUser(user);
			
			//add the cart
			assertEquals("added cart", true, userDAO.addCart(cart));
			
			//create a shipping address
			address = new Address();
			address = new Address();
			address.setAddressLineOne("1000 Yonge Street");
			address.setAddressLineTwo("unit 1406");
			address.setCity("Toronto");
			address.setPostalCode("m2l 0r1");
			address.setProvince("ON");
			address.setShipping(true);
			address.setCountry("Canada");
			
			//link it with the user
			address.setUserId(user.getId());
			
			assertEquals("added shipping address", true, userDAO.addAddress(address));
		}
	}
}