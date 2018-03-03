package com.sada.Model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="vendor")
public class Vendor {
	@Id
	@Column(name="VENDORID")
	private int vendorId;
	
	@Column(name="VENDORNAME")
	private String vendorName;
	
	@OneToMany(targetEntity=Customer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="VENDORID")
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
