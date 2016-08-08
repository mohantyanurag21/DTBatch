package com.niit.shoppingkart.controller;

import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shoppingkart.dao.UserDAO;

import com.niit.shoppingkart.model.User;
import com.niit.shoppingkart.model.UserDetails;
@Controller
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
	
	//@Autowired
	//private CategoryDAO categoryDAO;
	
	//@Autowired
	//private Category category;
	
	
	/**
	 * if invalid credentials ->  Home page , login ,  error message
	 * if valid credentials  && he is admin ->  AdminHome page ,logout link
	 * if valid credentials && he is end user ->  Home page, cart, logout link
	 * @param userID
	 * @param password
	 * @return it will return data and page name where to return
	 */
	    
	    @RequestMapping("/isValidUser")
		public ModelAndView isValidUser(@RequestParam(value = "name") String name,
				@RequestParam(value = "password") String password, HttpSession session) {
			//System.out.println("in controller");
			//User user = userDAO.get(name);
			//System.out.println(user.isAdmin());
			String message;
			ModelAndView mv ;
			if (userDAO.isValidUser(name, password)) 
			{
				System.out.println("Hello");
				user = userDAO.get(name);
				//System.out.println(user.getId());
				//System.out.println(user.getId());
				if(user.isAdmin() == true)
				{
					mv = new ModelAndView("adminHome");
					message = "Hello ";
					mv.addObject("message", message + name);
					return mv;
				}
				else
				{
					message = "Hello ";
					mv = new ModelAndView("index");
					mv.addObject("message", message + name);
					return mv;
				}
			}
			else 
			{
				message = "Invalid credentials";
				 mv = new ModelAndView("login1");
				 mv.addObject("message", message);
				 return mv;
			}
			
		}
		
		
		@RequestMapping("/register")
		public ModelAndView registerUser() 
		{
			
		  ModelAndView mod = new ModelAndView("register");
		  mod.addObject("msg", "Welcome to Registration Page");
		  return mod; 
		 }
		@RequestMapping("/registered")
		public ModelAndView registered(@ModelAttribute UserDetails userDetails)
		{
			ModelAndView mv = new ModelAndView("index");
			userDAO.saveOrUpdate(userDetails);
			//user = (User) userDAO.get(userDetails.getId());
			user.setId(userDetails.getId());
			user.setPassword(userDetails.getPassword());
			user.setAdmin(false);
			userDAO.saveOrUpdate(user);
			
			//userDAO.saveOrUpdate(user);
			//user = (User) userDAO.get(userDetails.getId());
			//user.setAdmin(false);
			//userDAO.saveOrUpdate(user);
			mv.addObject("msg", "successfully registered");
			return mv;
		}


	}

