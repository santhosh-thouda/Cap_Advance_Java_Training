package com.onetoonebidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private int id;
	private String name;
	private String dateOfBirth;
	private String citizen;
	
	@OneToOne(mappedBy = "passport")
	private Person person; 
	
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String toString() {
		return id+" "+name+" "+dateOfBirth+" "+citizen+" "+person;
	}
	
}
