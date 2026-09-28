package com.code.HibernateProject1.crud;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Product;

public class DeleteProduct {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public DeleteProduct(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		//Have one id
		int deleteid = 3;
		
		//get the objects from the category with id deleteid
		Product product = session.get(Product.class, deleteid);
		
		//check the existance of the object of deleteid
		if(product == null) {
			System.out.println("Product with id "+deleteid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(product.toString());
		
		//remove the object
		session.remove(product);
		
		//to update into the table
		session.getTransaction().commit();
		
		//close the session
		session.close(); //detached
	
		System.out.println("Product is deleted successfully");
	}
}
