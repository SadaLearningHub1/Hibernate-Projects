package com.sada.Model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name="PAYMENT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Payment {
	@Id
	@Column(name="PAYMENTID")
	private int paymentId;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="PAYMENTDATE")
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