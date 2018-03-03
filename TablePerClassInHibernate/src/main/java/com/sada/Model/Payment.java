package com.sada.Model;
import java.util.Date;
public class Payment {
	
	private int paymentId;
	private double amount;
	private Date paymentDate;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payment(int paymentId, double amount, Date paymentDate) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public Payment(int paymentId) {
		super();
		this.paymentId = paymentId;
	}
	public Payment() {
	}
}