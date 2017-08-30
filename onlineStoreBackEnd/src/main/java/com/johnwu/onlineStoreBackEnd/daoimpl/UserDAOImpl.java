package com.johnwu.onlineStoreBackEnd.daoimpl;

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
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

}
