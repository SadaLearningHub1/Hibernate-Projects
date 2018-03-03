package com.sada.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="person")
public class Person {
	@GenericGenerator(name="gen1", strategy="increment")
	@Id
	@GeneratedValue(generator="gen1")
	@Column(name="pid")
	private int personId;
	
	@Embedded
	private Pname pname;
	
	@Column(name="dob" )
	@Type(type="date")
	private Date date;

	public Person(int personId, Pname pname, Date date) {
		super();
		this.personId = personId;
		this.pname = pname;
		this.date = date;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
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

	public Pname getPname() {
		return pname;
	}

	public void setPname(Pname pname) {
		this.pname = pname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
