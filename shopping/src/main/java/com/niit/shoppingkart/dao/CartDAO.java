package com.niit.shoppingkart.dao;

import java.util.List;

import com.niit.shoppingkart.model.Cart;



public interface CartDAO 
{
	public List<Cart> list();

	public List<Cart> get(String userId);

	public void saveOrUpdate(Cart cart);

	public void delete(String id);
	
	public long getTotalAmount(String userId);



}
