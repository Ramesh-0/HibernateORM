package com.code.HibernateProject1.crud;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;
import com.code.HibernateProject1.entity.Users;

public class CreateOrders {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public CreateOrders(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//set the id of the users to assign the orders
		int usersid = 3;
		
		//get the objects from the users with usersid
		Users users = session.get(Users.class, usersid);
		
		//check the existance of the users with usersid
		if(users == null) {
			System.out.println("Users with id "+usersid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(users.toString());
		
		//create the Orders object
		Orders orders = new Orders(LocalDateTime.parse("2026-09-24T20:15:30"), BigDecimal.valueOf(500.00), users);
		
		//save the object
		session.persist(orders);
		
		//create second object
		orders = new Orders(LocalDateTime.parse("2026-09-24T20:25:30"), BigDecimal.valueOf(300.00), users);
		
		//save the object
		session.persist(orders);
		
		//create third object
		orders = new Orders(LocalDateTime.parse("2026-09-24T20:35:30"), BigDecimal.valueOf(800.00), users);
		
		//save the object
		session.persist(orders);
		
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		
		//close the session
		session.close();
		//give a message to user
		System.out.println("Orders are created successfully");
	}
}
