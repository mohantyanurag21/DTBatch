package com.niit.shoppingkart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingkart.dao.SupplierDAO;
import com.niit.shoppingkart.model.Supplier;



public class SupplierTest 
{
public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingkart");
		context.refresh();
		System.out.println("Table Created");
		Supplier c =(Supplier)	  context.getBean("supplier");
		
		SupplierDAO supplierDAO = (SupplierDAO)  context.getBean("supplierDAO");
		
		
		c.setId("SUP_001");
		c.setName("Supplier1");
		c.setAddress("Faridabad");
		
		
		supplierDAO.saveOrUpdate(c);
		System.out.println("Table Created");
	}


}
