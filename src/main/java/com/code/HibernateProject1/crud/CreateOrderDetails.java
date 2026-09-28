package com.code.HibernateProject1.crud;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.HibernateProject1.entity.OrderDetails;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;

public class CreateOrderDetails {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public CreateOrderDetails(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//set the id of the orders to assign the orderDetails
		int ordersid = 2;
		
		//set the id of the first product to assign the order details
		int productid = 2;
		
		//get the objects from the users with ordersid
		Orders orders = session.get(Orders.class, ordersid);
		
		//check the existance of the orders with ordersid
		if(orders == null) {
			System.out.println("Orders with id "+ordersid+" not found");
			return;
		}
		
		//get the objects from the Product with productid
		Product product = session.get(Product.class, productid);
		
		//check the existance of the Product with productid
		if(product == null) {
			System.out.println("Product with id "+productid+" not found");
			return;
		}
		
		//show the current object values
		System.out.println(orders.toString());
		
		//show the current object values
		System.out.println(product.toString());
		
		//create the OrderDetails object
		OrderDetails orderDetails = new OrderDetails(1, BigDecimal.valueOf(300.00), orders, product);
		
		//save the object
		session.persist(orderDetails);

		Product secondProduct = session.get(Product.class, 3);
		if (secondProduct != null) {
			session.persist(new OrderDetails(2, BigDecimal.valueOf(400.00), orders, secondProduct));
		}
		
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		
		//close the session
		session.close();
		//give a message to user
		System.out.println("OrderDetails are created successfully");
	}
}
