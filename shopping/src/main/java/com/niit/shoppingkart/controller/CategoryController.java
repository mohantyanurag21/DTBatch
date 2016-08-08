package com.niit.shoppingkart.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	private CategoryDAO categoryDAO;
	//private Category category;
	

	@RequestMapping("/category/add")
	public ModelAndView addCategory(@ModelAttribute Category category) 
	{
		ModelAndView mv = new ModelAndView("category1");
		System.out.println("Inside add category");
		System.out.println(category.getId());
		categoryDAO.saveOrUpdate(category);
		mv.addObject("categoryList", categoryDAO.list());
	  return mv;
	 }

	
	
	
	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories() {

		System.out.println("getAllCategories");
		
		List<Category> categoryList = categoryDAO.list();
		
		ModelAndView mv = new ModelAndView("/categoryList");
		mv.addObject("categoryList", categoryList);

		return mv;
	}
	
	
	@RequestMapping("category/edit/{id}")
	public ModelAndView updateCategory(@ModelAttribute("category") ArrayList<Category> categories)
	{
		Category c =categories.get(0);
		categoryDAO.saveOrUpdate(c);
		
		System.out.println("updating category");
		ModelAndView mv = new ModelAndView("/categoryList");
		
	    List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		
		return mv;
	}
	@RequestMapping("/category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		ModelAndView mv = new ModelAndView("category1");
		categoryDAO.delete(id);
		//mv.addObject("category", category);
		mv.addObject("categoryList", categoryDAO.list());
		return mv;	
	}

	
	

}
