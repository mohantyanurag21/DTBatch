package com.niit.shoppingkart.test;



import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingkart.dao.CartDAO;

import com.niit.shoppingkart.model.Cart;

public class CartTest {
public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingkart");
		context.refresh();
		System.out.println("Table Created");
		Cart c =(Cart)	  context.getBean("cart");
		
		CartDAO cartDAO = (CartDAO)  context.getBean("cartDAO");
		
		
		c.setUserId("monty");
		c.setPrice(15000);
		c.setQuantity(1);
		c.setStatus("N");
		c.setProductname("HA");
		
		cartDAO.saveOrUpdate(c);
		//categoryDAO.delete("");
		/*List<Cart> cartList = cartDAO.get("mohan");
		for(Cart cart : cartList)
		{
			System.out.println(cart.getCart_id());
			System.out.println(cart.getUserId());
			System.out.println(cart.getStatus());
			System.out.println(cart.getQuantity());
			System.out.println(cart.getProductname());
			System.out.println(cart.getPrice());
			
		}*/
		System.out.println("Table Created");
	}

}
