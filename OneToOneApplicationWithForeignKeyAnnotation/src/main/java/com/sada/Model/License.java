package com.sada.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="license")
public class License {
	@Id
	@Column(name="LICENSEID", length=5)
	private int licenseId;
	
	@Column(name="ISSUEDDATE")
	private Date issuedDate;
	
	@Column(name="EXPIREDATE")
	private Date expireDate;
	
	@ManyToOne(targetEntity=Person.class, cascade=CascadeType.ALL)
	@JoinColumn(name="PER_ID",nullable=false,unique=true)
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
