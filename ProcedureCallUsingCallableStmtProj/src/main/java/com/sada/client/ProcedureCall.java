package com.sada.client;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.jdbc.Work;
public class ProcedureCall implements Work {

	public void execute(Connection con) throws SQLException {
		CallableStatement cstmt = con.prepareCall("{call employee_bonus_pro(?,?)}");
		cstmt.setInt(1, 1);
		cstmt.registerOutParameter(2, Types.DECIMAL);
		cstmt.execute();
		double bonus = cstmt.getDouble(2);
		System.out.println("Bonus is: "+bonus);
		cstmt.close();
	}

}

/*Procedure : employee_bonus_pro
create or replace procedure employee_bonus_pro(eno in number, bonus out number)
is
temp_salary number(8);
begin
	select EMPLOYEESAL into temp_salary from employee where EMPLOYEEID = eno;
	if temp_salary between 1 and 1000 then
		bonus := temp_salary * 0.20;
	elsif temp_salary between 1001 and 3000 then
		bonus := temp_salary * 0.25;
	else
		bonus := temp_salary * 0.30;
	end if;
end;*/
