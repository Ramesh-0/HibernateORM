package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;

public class CreateCategory {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public CreateCategory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//create the object of the Category
		Category category = new Category("Electronics", "Electronic products");
		
		//save the object
		session.persist(category);
		
		//second object
		category = new Category("Beauty", "Makeup products");
		
		//save the object
		session.persist(category);
		
		//third object
		category = new Category("Toy", "Toy products");
		
		//save the object
		session.persist(category);
		
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		
		//close the session
		session.close();
		//give a message to user
		System.out.println("Category is created successfully");
	}
}
