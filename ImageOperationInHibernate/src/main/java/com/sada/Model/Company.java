package com.sada.Model;

import java.sql.Blob;

public class Company {
	private int companyId;
	private Blob image;
	public Company(int companyId, Blob image) {
		super();
		this.companyId = companyId;
		this.image = image;
	}
	public Company(int companyId) {
		super();
		this.companyId = companyId;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
}
