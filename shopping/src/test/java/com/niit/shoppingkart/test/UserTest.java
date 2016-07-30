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
			user.setId("tushar");
			user.setPassword("tushar");
			user.setAdmin(false);
			userDetails.setId("tushar");
			userDetails.setAddress("Kanpur");
			userDetails.setContactNumber("9000900099");
			userDetails.setMailID("tushar4@yahoo.com");
			userDetails.setName("Tushar Kapoor");
			t.createUser(userDetails);
			t.createUser(user);
			
			
		}

	}	
}