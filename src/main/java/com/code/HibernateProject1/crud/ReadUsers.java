package com.code.HibernateProject1.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.Users;

public class ReadUsers {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public ReadUsers(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//show all the object from the Category
		List<Users> userss = session.createQuery("from Users").getResultList();
		for(Users users:userss) {
			System.out.println(users.toString());
		}
		
		//close the session
		session.close(); //detached
	}
}
