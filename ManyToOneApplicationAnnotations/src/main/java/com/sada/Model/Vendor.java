package com.sada.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="vendor")
public class Vendor {
	@Id
	@Column(name="VENDORID", length=5)
	private int vendorId;
	
	@Column(name="VENDORNAME", length=15)
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
