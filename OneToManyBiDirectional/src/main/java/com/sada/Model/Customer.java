package com.sada.Model;
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	
	private Vendor vendor;
	
	public int getCustomerId() {
		return customerId;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public void setCustomerId(int customerId) {
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
	public Customer(int customerId, String customerName, String customerAddress, Vendor vendor) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.vendor = vendor;
	}
	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}
	public Customer() {}
}
