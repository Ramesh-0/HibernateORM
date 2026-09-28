package com.code.HibernateProject1.crud;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;

public class DeleteOrders {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public DeleteOrders(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		//Have one id
		int deleteid = 3;
		
		//get the objects from the orders with id deleteid
		Orders orders = session.get(Orders.class, deleteid);
		
		//check the existance of the object of deleteid
		if(orders == null) {
			System.out.println("Orders with id "+deleteid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(orders.toString());
		
		//remove the object
		session.remove(orders);
		
		//to update into the table
		session.getTransaction().commit();
		
		//close the session
		session.close(); //detached
	
		System.out.println("Order is deleted successfully");
	}
}
