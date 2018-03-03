package com.sada.Model;

import java.util.Date;

public class License {
	
	private int licenseId;
	private Date issuedDate;
	private Date expireDate;
	
	private Person person;
	
	public License(int licenseId, Date issuedDate, Date expireDate,
			Person person) {
		super();
		this.licenseId = licenseId;
		this.issuedDate = issuedDate;
		this.expireDate = expireDate;
		this.person = person;
	}
	public License(int licenseId) {
		super();
		this.licenseId = licenseId;
	}
	public License() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
