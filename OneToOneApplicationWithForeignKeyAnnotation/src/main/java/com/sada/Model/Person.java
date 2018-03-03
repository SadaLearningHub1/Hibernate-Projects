package com.sada.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@Column(name="PERSONID", length=5)
	private int personId;
	
	@Column(name="PERSONNAME", length=15)
	private String personName;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}
	public Person(int personId) {
		super();
		this.personId = personId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
