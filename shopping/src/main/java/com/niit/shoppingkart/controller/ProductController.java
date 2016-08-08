package com.niit.shoppingkart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.ProductDAO;
import com.niit.shoppingkart.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	private ProductDAO productDAO;
	

	@RequestMapping("/product/add")
	public ModelAndView addProduct(@ModelAttribute Product product) 
	{
		ModelAndView mv = new ModelAndView("product1");
		System.out.println("Inside add category");
		productDAO.saveOrUpdate(product);
		mv.addObject("productList", productDAO.list());
	  return mv;
	 }

	
	
	
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() {

		System.out.println("getAllProducts");
		
		List<Product> productList = productDAO.list();
		
		ModelAndView mv = new ModelAndView("/productList");
		mv.addObject("productList", productList);

		return mv;
	}
	
	
	@RequestMapping("product/edit/${id}")
	public ModelAndView updateProduct(@ModelAttribute("product") ArrayList<Product> products)
	{
		Product p =products.get(0);
		productDAO.saveOrUpdate(p);
		
		System.out.println("updating product");
		ModelAndView mv = new ModelAndView("/productList");
		
	    List<Product> productList = productDAO.list();
		mv.addObject("productList", productList);
		
		return mv;
	}
	@RequestMapping("product/remove/{id}")
	public ModelAndView deleteProduct(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		ModelAndView mv = new ModelAndView("product1");
		productDAO.delete(id);
		mv.addObject("productList", productDAO.list());
		return mv;	
	}

	

}
