package com.code.HibernateProject1.crud;

import org.hibernate.Session;


import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.OrderDetails;

public class DeleteOrderDetails {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public DeleteOrderDetails(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		//Have one id
		int deleteid = 1;
		
		//get the objects from the orderDetails with id deleteid
		OrderDetails orderDetails = session.get(OrderDetails.class, deleteid);
		
		//check the existance of the object of deleteid
		if(orderDetails == null) {
			System.out.println("OrderDetails with id "+deleteid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(orderDetails.toString());
		
		//remove the object
		session.remove(orderDetails);
		
		//to update into the table
		session.getTransaction().commit();
		
		//close the session
		session.close(); //detached
	
		System.out.println("OrderDetail is deleted successfully");
	}
}
