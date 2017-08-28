package com.johnwu.onlineStoreBackEnd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnwu.onlineStoreBackEnd.dao.ProductDAO;
import com.johnwu.onlineStoreBackEnd.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){	
		context = new AnnotationConfigApplicationContext();
		context.scan("com.johnwu.onlineStoreBackEnd");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("ProductDAO");
	}
	
	/*@Test
	public void testCRUDProduct(){
		product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description about oppp phones");
		product.setUnitPrice(400);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		
		assertEquals("Smth sent srong when inserting product", true, productDAO.add(product));
		
		//reading and updating the category
		product = productDAO.get(2);
		product.setName("IPhone 8");
		assertEquals("Smth sent srong when updating product", true, productDAO.update(product));
		
		assertEquals("Smth sent srong when deleting product", true, productDAO.delete(product));
		//get the list of the products
		assertEquals("Smth sent srong when getting the list of products", 8, productDAO.list().size());
	}*/
	
	/*@Test
	public void testListActiveProducts(){
		assertEquals("Something went wrong while getting active products", 7, productDAO.listActiveProducts().size());
	}*/
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Something went wrong while getting active products", 5, productDAO.listActiveProductsByCategory(2).size());
	}
	
	@Test
	public void testLatestActiveProducts(){
		assertEquals("Something went wrong while getting active products", 3, productDAO.getLatestActiveProducts(3).size());
	}
}
