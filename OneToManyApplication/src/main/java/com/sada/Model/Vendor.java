package com.sada.Model;
import java.util.Set;
public class Vendor {
	
	private int vendorId;
	private String vendorName;
	
	private java.util.Set customers;
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public java.util.Set getCustomers() {
		return customers;
	}
	public void setCustomers(java.util.Set customers) {
		this.customers = customers;
	}
	public Vendor(int vendorId, String vendorName, Set customers) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.customers = customers;
	}
	public Vendor(int vendorId) {
		super();
		this.vendorId = vendorId;
	}
	public Vendor() {}
}
