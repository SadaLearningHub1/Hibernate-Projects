package com.sada.Model;

public class Student {
	private int studentId;
	private String studentName;
	private Address address;
	public Student(int studentId, String studentName, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}
	public Student(int studentId) {
		super();
		this.studentId = studentId;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
