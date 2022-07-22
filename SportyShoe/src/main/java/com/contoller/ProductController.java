package com.contoller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Product;
import com.service.ProductService;



@Controller
public class ProductController {
	

	@Autowired
	ProductService productService;
	@RequestMapping(value="/")
	public String openPage() {
		return "index";
	}
	
	
	@RequestMapping(value="/storeProduct", method=RequestMethod.GET)
	public String storeProduct() {
		return "storeProduct";
	}
	@RequestMapping(value ="/storeProductDetails",method =RequestMethod.POST)
	public String storeProduct(HttpServletRequest req, Product product) {      // DI for request and Employee object 
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		float price = Float.parseFloat(req.getParameter("price"));
		String available = req.getParameter("available");
		
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setCategory(category);
		product.setPrice(price);
		product.setAvailable(available);
		
		
		String result = productService.storeProduct(product);
		//System.out.println(result);
		req.setAttribute("msg", result);      // store msg in request scope
		return "index";
		//return "storeProduct";
}

	@RequestMapping(value="/displayAvailableProduct",method = RequestMethod.GET)
	public String displayAvailableProduct(HttpServletRequest req) {
		List<Product> listOProduct = productService.getAllAvailableProduct();
		req.setAttribute("listOfProduct", listOProduct);
		return "displayAvailableProduct";					// displayAvailableProuct.jsp 
}	


@RequestMapping(value="/displayProductByCategory",method = RequestMethod.GET)
public String displayProduct(HttpServletRequest req) {
	List<Product> listOfProduct = productService.getAllProductByCategory();
	req.setAttribute("listOfProduct", listOfProduct);
	return "displayProductByCategory";					// displayProductByCategory.jsp 
}
}