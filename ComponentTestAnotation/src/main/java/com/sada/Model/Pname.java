package com.sada.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Pname {
	@Column(name="I",length=1)
	private char initial;
	
	@Column(name="fname",length=10)
	private String firstName;
	
	@Column(name="lname", length=10)
	private String lastName;

	public Pname(char initial, String firstName, String lastName) {
		super();
		this.initial = initial;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Pname(char initial) {
		super();
		this.initial = initial;
	}

	public Pname() {
		super();
		// TODO Auto-generated constructor stub
	}

	public char getInitial() {
		return initial;
	}

	public void setInitial(char initial) {
		this.initial = initial;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
