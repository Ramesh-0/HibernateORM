package com.code.HibernateProject1.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;

public class ReadCategory {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public ReadCategory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//show all the object from the Category
		List<Category> categories = session.createQuery("from Category").getResultList();
		for(Category category:categories) {
			System.out.println(category.toString());
		}
		
		//close the session
		session.close(); //detached
	}
}
