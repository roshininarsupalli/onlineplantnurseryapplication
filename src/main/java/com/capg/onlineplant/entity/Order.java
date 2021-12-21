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
import java.time.LocalDate;

@Entity
@Table(name="orders")
public class Order {
@Id
@GeneratedValue
private Integer bookingOrderId;
   public Integer getBookingOrderId() {
	return bookingOrderId;
}
public void setBookingOrderId(Integer bookingOrderId) {
	this.bookingOrderId = bookingOrderId;
}
public LocalDate getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}
public String getTransactionMode() {
	return transactionMode;
}
public void setTransactionMode(String transactionMode) {
	this.transactionMode = transactionMode;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

//@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="Cart")
//@JoinColumn(name="price_FK")

@Column(name="price_PK")
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
private LocalDate orderDate;
   private String transactionMode;
   private int quantity;
   private double price;
public Order(Integer bookingOrderId, LocalDate orderDate, String transactionMode, int quantity, double price) {
	super();
	this.bookingOrderId = bookingOrderId;
	this.orderDate = orderDate;
	this.transactionMode = transactionMode;
	this.quantity = quantity;
	this.price = price;
}
public Order() {

}
@Override
public String toString() {
	return "Order [bookingId=" + bookingOrderId + ", bookingDate=" + orderDate + ", transactionMode=" + transactionMode
			+ ",price=" + price + "]";
}
}
