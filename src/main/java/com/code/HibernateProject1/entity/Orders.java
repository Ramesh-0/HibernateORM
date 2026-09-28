package com.code.HibernateProject1.entity;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="orderDate", nullable=false)
	private LocalDateTime orderDate;
	@Column(name="total_amount", precision=12, scale=2, nullable=false)
	private BigDecimal totalAmount;
	
	@ManyToOne
	@JoinColumn(name="users_id", nullable=false)
	private Users users;
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<OrderDetails> orderDetails = new ArrayList<>();
	
	//default constructor
	public Orders() {
		this.id=0;
		this.orderDate=null;
		this.totalAmount=BigDecimal.ZERO;
		this.users=null;
	}

	//parameterized constructor
	public Orders(LocalDateTime orderDate, BigDecimal totalAmount, Users users) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.users = users;
	}

	//Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void addOrderDetail(OrderDetails detail) {
		orderDetails.add(detail);
		detail.setOrders(this);
	}

	public void removeOrderDetail(OrderDetails detail) {
		orderDetails.remove(detail);
		detail.setOrders(null);
	}

	//toString() method
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", users=" + users
				+ "]";
	}

}
