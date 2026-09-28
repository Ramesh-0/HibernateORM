package com.code.HibernateProject1.crud;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Users;
import com.code.HibernateProject1.entity.Users.Role;

public class CreateUsers {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public CreateUsers(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//create the object of the Category
		Users users = new Users("Disha Dutta", "1234", "disha1234@example.com", Role.ADMIN);
		
		//save the object
		session.persist(users);
		
		//second object
		users = new Users("Trishit Ghosh", "1234","trishit1234@example.com", Role.CUSTOMER);
		
		//save the object
		session.persist(users);
		
		//third object
		users = new Users("Diya Sarkar", "1234", "diyasarkar1234@example.com", Role.CUSTOMER);
		
		//save the object
		session.persist(users);
		
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		
		//close the session
		session.close();
		//give a message to user
		System.out.println("Users are created successfully");
	}
}
