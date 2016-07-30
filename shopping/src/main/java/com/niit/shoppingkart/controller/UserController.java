package com.niit.shoppingkart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.dao.UserDAO;
import com.niit.shoppingkart.model.Category;
import com.niit.shoppingkart.model.User;
import com.niit.shoppingkart.model.UserDetails;

public class UserController {
	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;
	@Autowired
	UserDetails userDetails;

	//@Autowired
	//private CartDAO cartDAO;
	
	//@Autowired
	//private Cart cart;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	/**
	 * if invalid credentials ->  Home page , login ,  error message
	 * if valid credentials  && he is admin ->  AdminHome page ,logout link
	 * if valid credentials && he is end user ->  Home page, cart, logout link
	 * @param userID
	 * @param password
	 * @return it will return data and page name where to return
	 */
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "name") String userID,
			@RequestParam(value = "password") String password, HttpSession session) {
		//log.debug("Starting of the method login");
		//log.info("userID is {}  password is {}", userID, password);

	
		ModelAndView mv = new ModelAndView("about");
		boolean isValidUser = userDAO.isValidUser(userID, password);

		if (isValidUser == true) {
			user = userDAO.get(userID);
			session.setAttribute("loggedInUser", userDetails.getName());
			mv.addObject("message", "Valid User");
			if (user.isAdmin() == true) {
				mv.addObject("isAdmin", "true");

			} else {
				mv.addObject("isAdmin", "false");
				//cart = cartDAO.get(userID);
				//mv.addObject("cart", cart);
				//List<Cart> cartList = cartDAO.list();
				//mv.addObject("cartList", cartList);
				//mv.addObject("cartSize", cartList.size());
			}

		} else {

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");
			mv.addObject("message", "InValid User");
			

		}
		//log.debug("Ending of the method login");
		return mv;
	}


}
