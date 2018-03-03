package com.sada.Model;

public class Vendor {
	
	private int vendorId;
	private String vendorName;
	
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
	
	public Vendor(int vendorId, String vendorName) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
	}
	public Vendor(int vendorId) {
		super();
		this.vendorId = vendorId;
	}
	public Vendor() {}
}
