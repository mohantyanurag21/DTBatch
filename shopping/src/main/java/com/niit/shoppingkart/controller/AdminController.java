package com.niit.shoppingkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.CartDAO;
import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.dao.ProductDAO;
import com.niit.shoppingkart.dao.SupplierDAO;
import com.niit.shoppingkart.model.Cart;
import com.niit.shoppingkart.model.Category;
import com.niit.shoppingkart.model.Product;
import com.niit.shoppingkart.model.Supplier;
@Controller
public class AdminController 
{
	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartDAO cartDAO;

	
	@RequestMapping("/manageCategories")
	public ModelAndView categories() {
		ModelAndView mv = new ModelAndView("category1");
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}

	@RequestMapping("/manageProducts")
	public ModelAndView products() {
		System.out.println("hello yooo");
		ModelAndView mv = new ModelAndView("product1");
		mv.addObject("product", product);
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("productList", productDAO.list());
		
		return mv;
	}

	@RequestMapping("/manageSuppliers")
	public ModelAndView suppliers() {
		ModelAndView mv = new ModelAndView("supplier1");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}
	
	@RequestMapping("/manageCart")
	public ModelAndView cart() {
		ModelAndView mv = new ModelAndView("about");
		mv.addObject("cart", cart);
		mv.addObject("isAdminClickedCart", "true");
		mv.addObject("cartList", cartDAO.list());
		return mv;
	}


}
