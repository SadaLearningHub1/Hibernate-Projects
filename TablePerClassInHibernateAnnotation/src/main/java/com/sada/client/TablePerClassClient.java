package com.sada.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sada.Model.ChequePayment;
import com.sada.Model.CreditCardPayment;

public class TablePerClassClient {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setPaymentId(10111);
		ccp.setAmount(5000);
		ccp.setCardType("VISA");;
		ccp.setPaymentDate(new java.util.Date());
		
		ChequePayment chp = new ChequePayment();
		chp.setPaymentId(10122);
		chp.setAmount(8000);
		chp.setPaymentDate(new java.util.Date());
		chp.setChequeType("order");
		
		Transaction tx = session.beginTransaction();
		
		session.save(ccp);
		session.save(chp);
		
		tx.commit();
		
		session.close();
		factory.close();
	}

}
