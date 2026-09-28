package com.code.HibernateProject1.crud;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.Product;

public class CreateProduct {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public CreateProduct(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//set the id of the category to assign the product
		int categoryid = 2;
		
		//get the objects from the category with categoryid
		Category category = session.get(Category.class, categoryid);
		
		//check the existance of the category with categoryid
		if(category == null) {
			System.out.println("Category with id "+categoryid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(category.toString());
		
		//create the Product object
		Product product = new Product("Foundation", BigDecimal.valueOf(500.00), 5, category);
		
		//save the object
		session.persist(product);
		
		//create second object
		product = new Product("Lipstick", BigDecimal.valueOf(300.00), 10, category);
		
		//save the object
		session.persist(product);
		
		//create third object
		product = new Product("Primer", BigDecimal.valueOf(400.00), 7, category);
		
		//save the object
		session.persist(product);
		
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		
		//close the session
		session.close();
		//give a message to user
		System.out.println("Product is created successfully");
	}
}
