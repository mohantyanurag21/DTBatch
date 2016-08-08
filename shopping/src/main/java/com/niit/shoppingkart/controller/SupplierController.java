package com.niit.shoppingkart.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.SupplierDAO;
import com.niit.shoppingkart.model.Supplier;



@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;
	

	@RequestMapping("/supplier/add")
	public ModelAndView addSupplier(@ModelAttribute Supplier supplier) {
		ModelAndView mv = new ModelAndView("supplier1");
		System.out.println("Inside add category");
		supplierDAO.saveOrUpdate(supplier);
		mv.addObject("supplierList", supplierDAO.list());
	  return mv;
	 }

	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers() {

		System.out.println("getAllSuppliers");
		
		List<Supplier> supplierList = supplierDAO.list();
		
		ModelAndView mv = new ModelAndView("/supplierList");
		mv.addObject("supplierList", supplierList);

		return mv;
	}
	@RequestMapping("supplier/remove/{id}")
	public ModelAndView deleteSupplier(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		ModelAndView mv = new ModelAndView("supplier1");
		supplierDAO.delete(id);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;	
	}

}
