package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product product) {
		if(product.getPrice()>1000) {
			return "Product price must be <1000";
			}else if(productDao.storeProductDetails(product)>0) {
				return "Product added successfully";
		
		}else {
			return "Product did not insert";
		}
	
}
	
	public String deleteProductInfo(int id) {
		if(productDao.deleteProductInfo(id)>0) {
			return "Product  deleted successfully";
		}else {
			return "Product not exists";
		}
}
	public List<Product> getAllAvailableProduct() {
		return productDao.getAllAvailableProduct();
}
	public List<Product> getAllProductByCategory() {
		return productDao.getAllProductByCategory();
}
}

