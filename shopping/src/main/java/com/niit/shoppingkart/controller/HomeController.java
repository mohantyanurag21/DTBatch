package com.niit.shoppingkart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.CartDAO;
import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.model.Cart;

@Controller
public class HomeController {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	@RequestMapping("/index")
	public ModelAndView home1() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	@RequestMapping("/electronics")
	public String elec() {
		return "electronics";
	}
	@RequestMapping("/clothing")
	public String cloth() {
		return "clothing";
	}
	@RequestMapping("/login1")
	public String login() {
		return "login1";
	}
	@RequestMapping("/temp")
	public ModelAndView temp() {
		ModelAndView mv = new ModelAndView("temp");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/myCart")
	public ModelAndView myCart(HttpSession session)
	{
		String user = (String) session.getAttribute("isLoggedInUser");
		ModelAndView mv = new ModelAndView("mycart");
		List<Cart> cartList = cartDAO.get(user);
		mv.addObject("cart", cart);
		mv.addObject("cartList", cartList);
		double total = cartDAO.getTotalAmount("mohan");
		mv.addObject("Amount", total);
		return mv;
	}
}
