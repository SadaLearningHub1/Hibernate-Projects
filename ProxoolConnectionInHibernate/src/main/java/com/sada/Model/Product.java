package com.sada.Model;

import java.io.Serializable;

//Product.java
//Pojo class
public class Product implements Serializable {
	
	private int productId;
	private String productName;
	private double price;
	
	//Full constructor
	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
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
