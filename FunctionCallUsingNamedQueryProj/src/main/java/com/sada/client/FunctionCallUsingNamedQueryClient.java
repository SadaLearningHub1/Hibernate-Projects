package com.sada.client;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Employee;
public class FunctionCallUsingNamedQueryClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Query qry = session.getNamedQuery("s1");
		qry.setParameter(0, 1);
		List l = qry.list();
		Iterator it = l.iterator();
		while(it.hasNext()){
			Employee e = (Employee)it.next();
			System.out.println(e.getEmployeeId()+"\t"+e.getEmployeeName()+"\t"+e.getEmployeeSal()+"\t"+e.getDeptNumber());
			System.out.println("===========================");
		}
		session.close();
		factory.close();
	}
}

/*Function : employees_fun
create or replace function employees_fun(dno number) return sys_refcursor is
  c1 sys_refcursor;
begin
  open c1 for select * from employee where DEPTNUMBER = dno;
  return c1;
end;*/
