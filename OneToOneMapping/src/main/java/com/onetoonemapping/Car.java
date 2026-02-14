package com.onetoonemapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

@Entity
public class Car {

    @Id
    private int id;

    private String brand;
    private String model;
    private String modelYear;
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")  // foreign key column
    private Engine engine;
    
    void setEngine(Engine engine) {
    	this.engine = engine;
    }
    
    Engine getEngine() {
    	return engine;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return id+" "+brand+" "+model+" "+modelYear+" "+price;
	}
}
