package com.niit.shoppingkart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.CartDAO;
import com.niit.shoppingkart.model.Cart;

@Controller
public class HomeController {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/index")
	public String home1() {
		return "index";
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
	
	@RequestMapping("/myCart")
	public ModelAndView myCart(HttpSession session)
	{
		String user = (String) session.getAttribute("isLoggedInUser");
		ModelAndView mv = new ModelAndView("mycart");
		List<Cart> cartList = cartDAO.get(user);
		mv.addObject("cart", cart);
		mv.addObject("cartList", cartList);
		return mv;
	}
}
