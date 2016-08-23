package com.niit.shoppingkart.controller.admin;



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
	private Supplier supplier;
	

	@RequestMapping("/supplier/add")
	public String addSupplier(@ModelAttribute Supplier supplier) {
		//ModelAndView mv = new ModelAndView("supplier1");
		System.out.println("Inside add category");
		supplierDAO.saveOrUpdate(supplier);
		//mv.addObject("supplierList", supplierDAO.list());
		return "redirect:/admin/manageSuppliers";
	 }

	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers() {

		System.out.println("getAllSuppliers");
		
		List<Supplier> supplierList = supplierDAO.list();
		
		ModelAndView mv = new ModelAndView("/supplierList");
		mv.addObject("supplierList", supplierList);

		return mv;
	}
	@RequestMapping("/supplier/edit/{id}")
	public ModelAndView updateSupplier(@PathVariable ("id") String id)
	{
		ModelAndView mv = new ModelAndView("supplieredit");
		supplier = supplierDAO.get(id);
		mv.addObject("sid", supplier.getId());
		mv.addObject("sname", supplier.getName());
		mv.addObject("paddress", supplier.getAddress());
		supplierDAO.delete(id);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}
	@RequestMapping("/supplier/remove/{id}")
	public String deleteSupplier(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		//ModelAndView mv = new ModelAndView("supplier1");
		supplierDAO.delete(id);
		//mv.addObject("supplierList", supplierDAO.list());
		return "redirect:/admin/manageSuppliers";	
	}

}
