package com.sada.Model;
import java.util.Set;
public class Vendor {
	
	private int vendorId;
	private String vendorName;
	
	private Set customers;
	
	
	public Set getCustomers() {
		return customers;
	}
	public void setCustomers(Set customers) {
		this.customers = customers;
	}
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
