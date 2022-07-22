package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {
	
	
	@Autowired
	EntityManagerFactory emf;   //its SessionFactory in Hibernate
	
	
	public int storeProductDetails(Product product) {
		try {
			
			EntityManager manager = emf.createEntityManager();  //Session objcect in Hibernate
			EntityTransaction tran = manager.getTransaction();   //TRansaction in Hibernate
			tran.begin();
			
			manager.persist(product);      //Session save employee
			tran.commit();
			return 1;
			
	}catch(Exception e) {
		System.out.println(e);
		return 0;
	}

}
	
	public float findProductPrice(int id) {
		EntityManager manager = emf.createEntityManager();
		Product product = manager.find(Product.class, id);
		if(product!=null) {
			return product.getPrice();
		}else {
			return 0;
		}
}
	public float updateProductPrice(Product pr) {
		EntityManager mang = emf.createEntityManager();
		EntityTransaction tran=mang.getTransaction();
		Product product1= mang.find(Product.class, pr.getId());
		if(product1 !=null) {
			tran.begin();
			product1.setPrice(pr.getPrice());
			mang.merge(product1);
			tran.commit();
			return 1;
			
			}else {
				return 0;
			}
	}
	public int deleteProductInfo(int id) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Product product = manager.find(Product.class, id);
		if(product!=null) {
						tran.begin();
								manager.remove(product);                          //session.delete(emp);
						tran.commit();
						return 1;
		}else {
			return 0;
		}
}

public int updateProductAvailable(Product product) {
	EntityManager manager= emf.createEntityManager();
	EntityTransaction tran = manager.getTransaction();
	Product product1 = manager.find(Product.class, product.getId());
	if(product1 != null) {
		tran.begin();
		product1.setAvailable(product.getAvailable());
		manager.merge(product1);
		tran.commit();
		return 1;
		
		}else {
			return 0;
		}
	
}

public List<Product> getAllAvailableProduct(){
	EntityManager manager= emf.createEntityManager();
	Query qry = manager.createQuery("Select p from Product p where p.available like 'yes'",Product.class);
List<Product> listOfProduct = qry.getResultList();
return listOfProduct;

}

public List<Product> getAllProductByCategory(){
	EntityManager manager= emf.createEntityManager();
	Query qry = manager.createQuery("Select p from Product p ORDER by category");
	List<Product> listOfProduct = qry.getResultList();
	return listOfProduct;

}
}
