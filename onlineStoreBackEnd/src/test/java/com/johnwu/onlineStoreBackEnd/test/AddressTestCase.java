package com.johnwu.onlineStoreBackEnd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnwu.onlineStoreBackEnd.dao.UserDAO;
import com.johnwu.onlineStoreBackEnd.dto.Address;
import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.User;

public class AddressTestCase {
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
	
/*	@Test
	public void TestAddress(){
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
		
		address.setUser(user);
		
		assertEquals("lined billing address to user", true, userDAO.addAddress(address));
		
		//create a shipping address
		address = new Address();
		address.setAddressLineOne("1000 Yonge Street");
		address.setAddressLineTwo("unit 1406");
		address.setCity("Toronto");
		address.setPostalCode("m2l 0r1");
		address.setProvince("ON");
		address.setShipping(true);
		address.setCountry("Canada");
		
		address.setUser(user);
		assertEquals("linked shipping address to user", true, userDAO.addAddress(address));
		
		
	}*/
	
	@Test
	public void testAddAddress(){
		// create a shipping address
		
		user = userDAO.getByEmail("abcde@gmail.com");
		address = new Address();
		address.setAddressLineOne("10200 Yonge Street");
		address.setAddressLineTwo("unit 1232");
		address.setCity("Toronto");
		address.setPostalCode("m3k 0r1");
		address.setProvince("ON");
		address.setShipping(true);
		address.setCountry("Canada");
		
		address.setUser(user);
		
		assertEquals("fetched the user and added a shipping address", true, userDAO.addAddress(address));
	}
}
