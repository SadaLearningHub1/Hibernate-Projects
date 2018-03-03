package com.sadalearninghub.SecondLevelCacheInHibernateUsingAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.stat.Statistics;

import com.sadalearninghub.SecondLevelCacheInHibernateUsingAnnotations.pojo.Product;




public class ProductSecondCacheClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
    	System.out.println("Hibernate serviceRegistry created");
    	
    	SessionFactory sessionFactory = conf.buildSessionFactory(serviceRegistry);
		
		
		Statistics stats = sessionFactory.getStatistics();
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		
		Session session = sessionFactory.openSession();
		Session otherSession = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Transaction otherTransaction = otherSession.beginTransaction();
		
		printStats(stats, 0);
		
		Product p = (Product) session.load(Product.class, 444);
		printData(p, stats, 1);
		
		p = (Product) session.load(Product.class, 444);
		printData(p, stats, 2);
		
		//clear first level cache, so that second level cache is used
		session.evict(p);
		p = (Product) session.load(Product.class, 444);
		printData(p, stats, 3);
		
		p = (Product) session.load(Product.class, 445);
		printData(p, stats, 4);
		
		p = (Product) otherSession.load(Product.class, 444);
		printData(p, stats, 5);
		
		//Release resources
		transaction.commit();
		otherTransaction.commit();
		sessionFactory.close();
	}

	private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count="
				+ stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count="
				+ stats.getSecondLevelCacheHitCount());
		System.out
				.println("Second Level Miss Count="
						+ stats
								.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count="
				+ stats.getSecondLevelCachePutCount());
	}

	private static void printData(Product p, Statistics stats, int count) {
		System.out.println(count+":: PRoductID="+p.getProductId()+", ProductName="+p.getProductName()+", Price="+p.getPrice());
		printStats(stats, count);
	}

}
