package com.sada.IdGenertor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyIdGenerator implements IdentifierGenerator{

	public Serializable generate(SharedSessionContractImplementor implementor, Object o){
		String str=" ";
		try{
			Connection con = implementor.connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select test_sequence.nextval as next from dual");
			rs.next();
			int i = rs.getInt("next");
			if(i<=9){
				str = "c00"+i;
			}else if(i>9 && i<=99){
				str = "c0"+i;
			}else{
				str = "c"+i;
			}
			rs.close();
			stmt.close();
			//con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
}
