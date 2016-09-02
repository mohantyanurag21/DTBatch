package com.niit.shoppingkart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.CartDAO;
import com.niit.shoppingkart.dao.CategoryDAO;
import com.niit.shoppingkart.dao.ProductDAO;
import com.niit.shoppingkart.dao.UserDAO;
import com.niit.shoppingkart.model.Cart;
import com.niit.shoppingkart.model.Product;
import com.niit.shoppingkart.model.User;
import com.niit.shoppingkart.model.UserDetails;

@Controller
public class HomeController {
	
	@Autowired
	private User user;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/")
	public ModelAndView home(HttpSession session ) {
		ModelAndView mv = new ModelAndView("index");
		/*System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getId();
		  System.out.println("instance1" + username);
		  System.out.println("Hello1");
		} else {
		  String username = principal.toString();
		  System.out.println("instance2" + username);
		  System.out.println("Hello2");
		}*/
		
		//System.out.println(activeUser.getId());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     System.out.println(name);
	     //System.out.println("hello3");
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
	public ModelAndView myCart()
	{
		//User user = userDAO.get(activeUser.getId());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    //user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.out.println(user.getId());
		//String user = (String) session.getAttribute("isLoggedInUser");
		ModelAndView mv = new ModelAndView("mycart");
		//System.out.println(activeUser.getId());
		List<Cart> cartList = cartDAO.get(name);
		mv.addObject("cart", cart);
		mv.addObject("cartList", cartList);
		double total = cartDAO.getTotalAmount(name);
		mv.addObject("Amount", total);
		return mv;
	}
	@RequestMapping("/get/{id}")
	public ModelAndView productview(@PathVariable ("id") String id)
	{
		ModelAndView mv = new ModelAndView("productview");
		System.out.println("productview");
		product = productDAO.get(id);
		System.out.println(product.getName());
		mv.addObject("Productprice", product.getPrice());
		mv.addObject("Productname", product.getName());
		mv.addObject("ProductDescription", product.getDescription());
		return mv;
	}
	/*@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session)
	{
		//ModelAndView mv = new ModelAndView("index");
		//session.invalidate();
		//session = request.getSession(true);
		session.setAttribute("categoryList", categoryDAO.list());
		//mv.addObject("logoutMessage", "You successfully logged out");
		//mv.addObject("loggedOut", "true");
		return "redirect:/";
	}*/
}
