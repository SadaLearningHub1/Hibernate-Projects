package com.sada.Model;

public class TestEmployee {
	
	private int employeeId;
	private String employeeName;
	private int employeeSal;
	private int deptNumber;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeSal() {
		return employeeSal;
	}
	public void setEmployeeSal(int employeeSal) {
		this.employeeSal = employeeSal;
	}
	public int getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
	}
	public TestEmployee(int employeeId, String employeeName, int employeeSal,
			int deptNumber) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSal = employeeSal;
		this.deptNumber = deptNumber;
	}
	public TestEmployee() {
	}
	public TestEmployee(int employeeId) {
		this.employeeId = employeeId;
	}
}
