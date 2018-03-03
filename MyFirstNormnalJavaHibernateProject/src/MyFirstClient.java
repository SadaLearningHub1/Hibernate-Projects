import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class MyFirstClient {
	public static void main(String args[]) {
		Configuration conf = new Configuration();
		try {
			conf.configure("hibernate.cfg.xml");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
