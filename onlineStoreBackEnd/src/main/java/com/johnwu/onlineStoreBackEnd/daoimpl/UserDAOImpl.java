package com.johnwu.onlineStoreBackEnd.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.johnwu.onlineStoreBackEnd.dao.UserDAO;
import com.johnwu.onlineStoreBackEnd.dto.Address;
import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		String selectQuery = "FROM User where email = :email";
		try{
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
						.setParameter("email", email)
							.getSingleResult();
						
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		// TODO Auto-generated method stub
		
		String selectQuery = "FROM Address Where user = :user AND billing = :billing";
		try{
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
						.setParameter("user", user)
						.setParameter("billing", true)
						.getSingleResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		// TODO Auto-generated method stub
		String selectQuery = "FROM Address Where user = :user AND shipping = :shipping";
		try{
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
						.setParameter("user", user)
						.setParameter("shipping", true)
						.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
