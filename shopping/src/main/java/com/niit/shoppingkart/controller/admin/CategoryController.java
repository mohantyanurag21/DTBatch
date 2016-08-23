package com.niit.shoppingkart.controller.admin;


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
	@Autowired
	private Category category;
	

	@RequestMapping("category/add")
	public String addCategory(@ModelAttribute Category category) 
	{
		//ModelAndView mv = new ModelAndView("category1");
		System.out.println("Inside add category");
		System.out.println(category.getId());
		categoryDAO.saveOrUpdate(category);
		//mv.addObject("categoryList", categoryDAO.list());
	  return "redirect:/admin/manageCategories" ;
	 }

	
	
	
	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories() {

		System.out.println("getAllCategories");
		
		List<Category> categoryList = categoryDAO.list();
		
		ModelAndView mv = new ModelAndView("/categoryList");
		mv.addObject("categoryList", categoryList);

		return mv;
	}
	
	
	@RequestMapping("/category/edit/{id}")
	public ModelAndView updateCategory(@PathVariable ("id") String id)
	{
		ModelAndView mv = new ModelAndView("categoryedit");
		category = categoryDAO.get(id);
		mv.addObject("cid", category.getId());
		mv.addObject("cname", category.getName());
		mv.addObject("cdescription", category.getDescription());
		categoryDAO.delete(id);
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
		
	}
	@RequestMapping("/category/remove/{id}")
	public String deleteCategory(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		//ModelAndView mv = new ModelAndView("category1");
		categoryDAO.delete(id);
		//mv.addObject("category", category);
		//mv.addObject("categoryList", categoryDAO.list());
		//return mv;
		return "redirect:/admin/manageCategories"; 
	}

	@RequestMapping("/category/edit/category/add")
	public String addeditCategory(@ModelAttribute Category category) 
	{
		//ModelAndView mv = new ModelAndView("category1");
		System.out.println("Inside edit-add category");
		System.out.println(category.getId());
		categoryDAO.saveOrUpdate(category);
		//mv.addObject("categoryList", categoryDAO.list());
	  return "redirect:/admin/manageCategories" ;
	 }

}
