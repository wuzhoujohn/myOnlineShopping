package com.johnwu.onlineStoreBackEnd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.johnwu.onlineStoreBackEnd.dao.ProductDAO;
import com.johnwu.onlineStoreBackEnd.dto.Category;
import com.johnwu.onlineStoreBackEnd.dto.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		//simply return all the available products including the ones which are inactive
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try{
			product.setActive(false);
			return this.update(product);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectActiveProducts = "FROM Product Where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		String selectActiveProductsByCategory = "FROM Product Where active = :active AND categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class);
		query.setParameter("active", true);
		query.setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		// every parameter name in the query should exactly the same as the name you defined in the java class. or errors will be thrown.
		String selectLatestActiveProducts = "FROM Product WHERE active = :active ORDER BY id";
		Query query = sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts, Product.class);
		query.setParameter("active", true);
		//set the starting and ending index 
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
	}

}
