package com.capg.onlineplant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue
	private int cartId;
	private double price;
	
	public Cart(int cartId, double price) {
		super();
		this.cartId = cartId;
		this.price = price;
	}



	
	public Cart() {
		// TODO Auto-generated constructor stub
	}




	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="Cart")
	@JoinColumn(name="price_FK")
	//@Column(name="price_PK")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	//private Customer customerId;
	//private Customer customerName;
	//private Planter planter;
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", price=" + price + "]";
	}
	

}
