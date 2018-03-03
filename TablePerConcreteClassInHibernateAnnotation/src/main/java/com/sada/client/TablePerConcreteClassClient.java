package com.sada.client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sada.Model.ChequePayment;
import com.sada.Model.CreditCardPayment;
import com.sada.Model.Payment;

public class TablePerConcreteClassClient {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		/*Payment p = new Payment();
		p.setPaymentId(10110);
		p.setAmount(5000);
		p.setPaymentDate(new java.util.Date());*/
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setPaymentId(10111);
		ccp.setAmount(5000);
		ccp.setCardType("VISA");;
		ccp.setPaymentDate(new java.util.Date());
		
		/*Payment p1 = new Payment();
		p1.setPaymentId(10120);
		p1.setAmount(8000);
		p1.setPaymentDate(new java.util.Date());*/
		ChequePayment chp = new ChequePayment();
		chp.setPaymentId(10121);
		chp.setAmount(8000);
		chp.setPaymentDate(new java.util.Date());
		chp.setChequeType("order");
		
		Transaction tx = session.beginTransaction();
		
		//session.save(p);
		session.save(ccp);
		//session.save(p1);
		session.save(chp);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
