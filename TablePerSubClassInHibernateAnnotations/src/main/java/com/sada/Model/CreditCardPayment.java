package com.sada.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CreditCardPayment")
@PrimaryKeyJoinColumn(name="pid")
public class CreditCardPayment extends Payment {
	@Column(name="CCTYPE")
	private String cardType;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
