package com.code.HibernateProject1.crud;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Users;


public class DeleteUsers {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public DeleteUsers(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		//Have one id
		int deleteid = 2;
		
		//get the objects from the category with id deleteid
		Users users = session.get(Users.class, deleteid);
		
		//check the existance of the object of deleteid
		if(users == null) {
			System.out.println("User with id "+deleteid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(users.toString());
		
		//remove the object
		session.remove(users);
		
		//to update into the table
		session.getTransaction().commit();
		
		//close the session
		session.close(); //detached
	
		System.out.println("User is deleted successfully");
	}
}
