package com.sada.Model;
import java.io.Serializable;
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private String customerName;
	private String customerAddress;
	
	public Customer() {
	}
	public Customer(String customerId) {
		this.customerId = customerId;
	}
	public Customer(String customerId, String customerName,	String customerAddress) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}	
}
