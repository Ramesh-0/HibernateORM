package com.code.HibernateProject1.crud;

import java.math.BigDecimal;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;


public class UpdateOrders {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public UpdateOrders(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		//Have one id
		int updateid = 3;
		
		//get the objects from the Orders with id updateid
		Orders orders = session.get(Orders.class, updateid);
		
		//check the existance of the object of updateid
		if(orders == null) {
			System.out.println("Orders with id "+updateid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(orders.toString());
		
		//set the new value
		orders.setTotalAmount(BigDecimal.valueOf(1100.00));
		
		//update the object
		session.merge(orders);
		
		//to update into the table
		session.getTransaction().commit();
		
		//close the session
		session.close(); //detached
	
		System.out.println("Order is updated successfully");
	}
}
