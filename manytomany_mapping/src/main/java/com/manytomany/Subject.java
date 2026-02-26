package com.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	private int id;
	private String name;
	private int no_of_days;
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
	public int getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", no_of_days=" + no_of_days + "]";
	}
	
}
