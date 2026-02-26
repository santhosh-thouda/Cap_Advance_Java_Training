package com.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	private int id;
	private String name;

	
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
	
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
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name;
	}
	
}
