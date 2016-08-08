package com.niit.shoppingkart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingkart.dao.UserDAO;
import com.niit.shoppingkart.model.User;
import com.niit.shoppingkart.model.UserDetails;

public class UserTest 
{
	public static class Test {
		
		static AnnotationConfigApplicationContext context;
		
		public Test()
		{
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.shoppingkart");
			context.refresh();
		}
		
		public static void createUser(User user)
		{
			
			UserDAO  userDAO =  (UserDAO) context.getBean("userDAO");
			userDAO.saveOrUpdate(user);
			
			
		}
		
		public static void createUser(UserDetails userDetails)
		{
			
			UserDAO  userDAO =  (UserDAO) context.getBean("userDAO");
			userDAO.saveOrUpdate(userDetails);
			
			
		}
		
		

		@SuppressWarnings("static-access")
		public static void main(String [] args)
		{
			
			Test t = new Test();
			
			User user =(User)  context.getBean("user");
			UserDetails userDetails =(UserDetails)  context.getBean("userDetails");
			user.setId("monty");
			user.setPassword("monty");
			user.setAdmin(false);
			userDetails.setId("monty");
			userDetails.setPassword("monty");
			userDetails.setAddress("Faridabad");
			userDetails.setContactNumber("9438785752");
			userDetails.setMailID("monty5@yahoo.com");
			userDetails.setName("Monty");
			t.createUser(userDetails);
			t.createUser(user);
			
			
		}

	}	
}