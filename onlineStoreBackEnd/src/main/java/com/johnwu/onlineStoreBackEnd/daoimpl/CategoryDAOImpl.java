package com.johnwu.onlineStoreBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.johnwu.onlineStoreBackEnd.dao.CategoryDAO;
import com.johnwu.onlineStoreBackEnd.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<Category>(); 
	
	//this static block will be initialized when the CategoryDAOImpl class gets created
	static{
		
		Category category = new Category();
		//setting properties of this category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("1.png");
		categories.add(category);
		
		//setting second category
		Category category2 = new Category();
		//setting properties of this category
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("This is some description for mobile");
		category2.setImageURL("2.png");
		categories.add(category2);
		
		//setting third category
		Category category3 = new Category();
		//setting properties of this category
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("This is some description for laptop");
		category3.setImageURL("3.png");
		categories.add(category3);
		
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//get category by id with using enhanced for loop
		
		for(Category category : categories){
			if(category.getId() == id ){
				return category;
			}
		}
		return null;
	}
	

}
