package com.johnwu.onlineStoreBackEnd.dao;

import java.util.List;

import com.johnwu.onlineStoreBackEnd.dto.Cart;
import com.johnwu.onlineStoreBackEnd.dto.CartLine;

public interface CartLineDAO {
	public CartLine get(int id);
	
	public boolean add(CartLine cartLine);
	
	public boolean update(CartLine cartLine);
	
	public boolean delete(CartLine cartLine);
	
	public List<CartLine> list(int cartId);
	
	//other business methods
	
	public List<CartLine> listAvailable(int cartId);
	
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update a cart
	boolean updateCart(Cart cart);	
}
