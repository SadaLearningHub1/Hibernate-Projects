package com.sada.Model;

import java.io.Serializable;

//Product.java
//Pojo class
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String productName;
	private double price;
	private int version;
	
	//Full constructor
	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	//Default constructor
	public Product() {}
	//Minimal constructor
	public Product(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
