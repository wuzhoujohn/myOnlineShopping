package com.johnwu.onlineStoreBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//here we need to import springframework transactional package
import org.springframework.transaction.annotation.Transactional;

import com.johnwu.onlineStoreBackEnd.dao.CategoryDAO;
import com.johnwu.onlineStoreBackEnd.dto.Category;


//every method in this class will be run within a transactional context 
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*private static List<Category> categories = new ArrayList<Category>(); 
	
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
		
		
	}*/

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		//here it has to be the java class name in the string, not the table name inside the database.
		String selectActiveCategory = "FROM Category Where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	//getting a single category based on id
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//get category by id with using enhanced for loop
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	//inserting a single category
	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	//update a single category
	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		// TODO Auto-generated method stub
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	

}
