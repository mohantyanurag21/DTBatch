package com.niit.shoppingkart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
