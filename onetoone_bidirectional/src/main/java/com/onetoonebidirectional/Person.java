package com.onetoonebidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private String email;
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Passport passport;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	public String toString() {
		return id+" "+name+" "+email+" "+phone+" "+passport;
	}
}
