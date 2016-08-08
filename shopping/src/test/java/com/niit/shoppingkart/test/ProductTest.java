package com.niit.shoppingkart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingkart.dao.ProductDAO;
import com.niit.shoppingkart.model.Product;

public class ProductTest {
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingkart");
		context.refresh();
		
		Product p = (Product)context.getBean("product");
		
	  
	    p.setId("HP ProBook 4530s");
	    p.setName("HP ProBook 4530s");
	    p.setDescription("This is ProBook 4530s");
	    p.setPrice(45000);
	    p.setCompany("HP");
	    //p.setCategoryID("Laptop");
	    //p.setSupplierID("SUP_001");
	    p.setQuantity(100);
	    ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
	    productDAO.saveOrUpdate(p);
		
		
	}

	

}
