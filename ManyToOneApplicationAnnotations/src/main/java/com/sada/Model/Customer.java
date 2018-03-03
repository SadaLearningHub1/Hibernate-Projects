package com.sada.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="CUSTOMERID", length=5)
	private int customerId;
	
	@Column(name="CUSTOMERNAME", length=15)
	private String customerName;
	
	@Column(name="CUSTOMERADDRESS", length=15)
	private String customerAddress;
	
	@ManyToOne(targetEntity=Vendor.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VENID")
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
