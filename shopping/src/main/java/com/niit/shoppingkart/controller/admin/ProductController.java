package com.niit.shoppingkart.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	//private Path path;
	

	@RequestMapping("product/add")
	public String addProduct(@ModelAttribute Product product,BindingResult result, HttpServletRequest request) 
	{
		//ModelAndView mv = new ModelAndView("product1");
		System.out.println("Inside add category");
		/*productDAO.saveOrUpdate(product);
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
        }*/
		//String filename=null; 
		//int res = 0; 
		ServletContext context=request.getServletContext();
		String path=context.getRealPath("./WEB-INF/resources/photos/"+product.getId()+".jpg"); 
		System.out.println("Path = "+path); 
		System.out.println("File name = "+product.getImage().getOriginalFilename());
		File f=new File(path); 
		if(!product.getImage().isEmpty())
		{
			try { //filename=p.getImage().getOriginalFilename();
				byte[] bytes=product.getImage().getBytes();
				BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
				bs.write(bytes);
				bs.close();
				System.out.println("Image uploaded");
			}
			catch(Exception ex)
			{
			System.out.println(ex.getMessage());
			}
			}
		
        productDAO.saveOrUpdate(product);
        System.out.println("Image Added");
		//mv.addObject("productList", productDAO.list());
	  return "redirect:/admin/manageProducts" ;
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
		ModelAndView mv = new ModelAndView("productedit");
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
	public String deleteProduct(@PathVariable ("id") String id)
	{
		System.out.println("hello");
		System.out.println(id);
		//ModelAndView mv = new ModelAndView("product1");
		productDAO.delete(id);
		/*mv.addObject("product", product);
		mv.addObject("productList", productDAO.list());
		return mv;*/
		return "redirect:/admin/manageProducts";
	}
	
	@RequestMapping("/product/edit/product/add")
	public String addeditProduct(@ModelAttribute Product product) 
	{
		//ModelAndView mv = new ModelAndView("product1");
		System.out.println("Inside add category");
		System.out.println(product.getId());
		productDAO.saveOrUpdate(product);
		//mv.addObject("productList", productDAO.list());
		return "redirect:/admin/manageProducts";
	 }


	

}
