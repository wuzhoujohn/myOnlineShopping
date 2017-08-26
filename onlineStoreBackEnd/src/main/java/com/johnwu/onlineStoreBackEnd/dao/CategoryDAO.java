package com.johnwu.onlineStoreBackEnd.dao;

import java.util.List;

import com.johnwu.onlineStoreBackEnd.dto.Category;

public interface CategoryDAO {

	//get the category list
	List<Category> list();
	
	//get a specific category by id
	Category get(int id);
	
	
	//a method to add a category, return true if successfully added, or return false.
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
