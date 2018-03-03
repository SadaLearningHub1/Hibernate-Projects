package com.sada.Model;

import java.io.Serializable;
import java.sql.Timestamp;

//Product.java
//Pojo class
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int productId;
	private String productName;
	private double price;
	private Timestamp timestamp;
	//Full constructor
	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	//Default constructor
	public Product() {}
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

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
