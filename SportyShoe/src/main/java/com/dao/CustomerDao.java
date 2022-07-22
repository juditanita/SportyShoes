package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.bean.Customers;


public class CustomerDao {
	
	@Autowired
	EntityManagerFactory emf;   //its SessionFactory in Hibernate
	
	
	public int storeCustomerDetails(Customers cus) {
		try {
			
			EntityManager manager = emf.createEntityManager();  //Session objcect in Hibernate
			EntityTransaction tran = manager.getTransaction();   //TRansaction in Hibernate
			tran.begin();
			
			manager.persist(cus);      //Session save employee
			tran.commit();
			return 1;
			
	}catch(Exception e) {
		System.out.println(e);
		return 0;
	}

}
	
}


