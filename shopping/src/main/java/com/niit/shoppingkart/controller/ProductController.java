package com.niit.shoppingkart.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingkart.dao.ProductDAO;
import com.niit.shoppingkart.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	private Path path;
	

	@RequestMapping("/product/add")
	public ModelAndView addProduct(@ModelAttribute Product product,BindingResult result, HttpServletRequest request) 
	{
		ModelAndView mv = new ModelAndView("product1");
		System.out.println("Inside add category");
		productDAO.saveOrUpdate(product);
		MultipartFile productImage = product.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory.toString());
        path = Paths.get(rootDirectory + "/WEB-INF/resources/photos/" + product.getId() + ".png");
        if(productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Product image saving failed", ex);
            }
        }
        System.out.println("Image Added");
		mv.addObject("productList", productDAO.list());
	  return mv;
	 }

	
	
	
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() {

		System.out.println("getAllProducts");
		
		List<Product> productList = productDAO.list();
		
		ModelAndView mv = new ModelAndView("/productList");
		mv.addObject("productList", productList);

		return mv;
	}
	
	
	@RequestMapping("product/edit/{id}")
	public ModelAndView updateProduct(@PathVariable ("id") String id)
	{
		ModelAndView mv = new ModelAndView("categoryedit");
		product = productDAO.get(id);
		mv.addObject("pid", product.getId());
		mv.addObject("pname", product.getName());
		mv.addObject("pdescription", product.getDescription());
		mv.addObject("pcompany", product.getCompany());
		mv.addObject("pprice", product.getPrice());
		mv.addObject("cquantity", product.getQuantity());
		productDAO.delete(id);
		mv.addObject("productList", productDAO.list());
		return mv;
	}
	@RequestMapping("product/remove/{id}")
	public ModelAndView deleteProduct(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		ModelAndView mv = new ModelAndView("product1");
		productDAO.delete(id);
		mv.addObject("productList", productDAO.list());
		return mv;	
	}
	
	@RequestMapping("/product/edit/product/add")
	public ModelAndView addeditProduct(@ModelAttribute Product product) 
	{
		ModelAndView mv = new ModelAndView("product1");
		System.out.println("Inside add category");
		System.out.println(product.getId());
		productDAO.saveOrUpdate(product);
		mv.addObject("productList", productDAO.list());
	  return mv;
	 }


	

}
