package com.code.HibernateProject1;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.crud.CreateCategory;
import com.code.HibernateProject1.crud.CreateOrderDetails;
import com.code.HibernateProject1.crud.CreateOrders;
import com.code.HibernateProject1.crud.CreateProduct;
import com.code.HibernateProject1.crud.CreateUsers;
import com.code.HibernateProject1.crud.DeleteCategory;
import com.code.HibernateProject1.crud.DeleteOrderDetails;
import com.code.HibernateProject1.crud.DeleteOrders;
import com.code.HibernateProject1.crud.DeleteProduct;
import com.code.HibernateProject1.crud.DeleteUsers;
import com.code.HibernateProject1.crud.ReadCategory;
import com.code.HibernateProject1.crud.ReadOrderDetails;
import com.code.HibernateProject1.crud.ReadOrders;
import com.code.HibernateProject1.crud.ReadProduct;
import com.code.HibernateProject1.crud.ReadUsers;
import com.code.HibernateProject1.crud.UpdateCategory;
import com.code.HibernateProject1.crud.UpdateOrderDetails;
import com.code.HibernateProject1.crud.UpdateOrders;
import com.code.HibernateProject1.crud.UpdateProduct;
import com.code.HibernateProject1.crud.UpdateUsers;
import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.OrderDetails;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;
import com.code.HibernateProject1.entity.Users;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//new CreateCategory(sessionFactory);
		//new ReadCategory(sessionFactory);
		//new UpdateCategory(sessionFactory);
		//new DeleteCategory(sessionFactory);
		//new CreateProduct(sessionFactory);
		//new ReadProduct(sessionFactory);
		//new UpdateProduct(sessionFactory);
		//new DeleteProduct(sessionFactory);
		//new CreateUsers(sessionFactory);
		//new ReadUsers(sessionFactory);
		//new UpdateUsers(sessionFactory);
		//new DeleteUsers(sessionFactory);
		//new CreateOrders(sessionFactory);
		//new ReadOrders(sessionFactory);
		//new UpdateOrders(sessionFactory);
		//new DeleteOrders(sessionFactory);
		//new CreateOrderDetails(sessionFactory);
		//new ReadOrderDetails(sessionFactory);
		//new UpdateOrderDetails(sessionFactory);
		new ReadOrders(sessionFactory);
		HibernateUtil.shutdown();
	}
}
