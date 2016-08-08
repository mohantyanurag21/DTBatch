package com.niit.shoppingkart.test;
//import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.model.Category;

public class CategoryTest {
public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingkart");
		context.refresh();
		System.out.println("Table Created");
		Category c =(Category)	  context.getBean("category");
		
		CategoryDAO categoryDAO = (CategoryDAO)  context.getBean("categoryDAO");
		
		
		/*c.setId("TAB_079");
		c.setName("Tablet");
		c.setDescription("Tablet product");*/
		
		
		//categoryDAO.saveOrUpdate(c);
		categoryDAO.delete("");
		System.out.println("Table Created");
	}

}
