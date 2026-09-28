package com.code.HibernateProject1.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="quantity", nullable=false)
	private int quantity;
	@Column(name="unit_price", precision=10, scale=2, nullable=false)
	private BigDecimal unitPrice;
	
	@ManyToOne
	@JoinColumn(name="orders_id", nullable=false)
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	//default constructor
	public OrderDetails() {
		this.id=0;
		this.quantity=0;
		this.unitPrice=BigDecimal.ZERO;
		this.orders=null;
		this.product=null;
	}

	//parameterized constructor
	public OrderDetails(int quantity, BigDecimal unitPrice, Orders orders, Product product) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.orders = orders;
		this.product = product;
	}

	//Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	//toString() method
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", orders=" + orders
				+ ", product=" + product + "]";
	}
	
}
