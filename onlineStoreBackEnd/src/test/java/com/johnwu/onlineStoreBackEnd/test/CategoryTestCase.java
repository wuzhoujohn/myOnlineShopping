package com.johnwu.onlineStoreBackEnd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnwu.onlineStoreBackEnd.dao.CategoryDAO;
import com.johnwu.onlineStoreBackEnd.dto.Category;

public class CategoryTestCase {
	/*
	 * we can use the AnnotationConfigApplicationContext to access the bean, a
	 * and use CategoryDAO to access the add method we created inside the class.
	 * */
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.johnwu.onlineStoreBackEnd"); 
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
/*	@Test
	public void testAddCategory(){
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for television");
		category.setImageURL("1.png");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
	}*/
	
/*	@Test
	public void testGetCategory(){
		
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a category inside the table", "Laptop", category.getName());
	}
	*/
	
	/*@Test
	public void testUpdateCategory(){
		
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a category inside the table", true, categoryDAO.update(category));
	}*/
	
/*	@Test
	public void testDeleteCategory(){	
		category = categoryDAO.get(2);
		assertEquals("Successfully deleted a category inside the table", true, categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory(){	
		assertEquals("Successfully fetched the list of category inside the table", 1, categoryDAO.list().size());
	}*/
	
	@Test 
	public void testCRUDCategory(){
		//add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("1_1.png");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("1_2.png");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		//fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("TV1");
		assertEquals("Successfully updated a category inside the table", true, categoryDAO.update(category));
		
		//deleting the category	we just fetched
		assertEquals("Successfully deleted a category inside the table", true, categoryDAO.delete(category));
		//fetching the list
		assertEquals("Successfully fetched the list of category inside the table", 1, categoryDAO.list().size());
		
	}
}
