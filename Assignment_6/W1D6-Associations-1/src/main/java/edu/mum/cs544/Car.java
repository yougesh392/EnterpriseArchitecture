package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	private String brand;
	private String year;
	private double price;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Owner owners;

	public Car() {
	}

	public Car(String brand, String year, double price, Owner owners) {
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owners = owners;
	}

	public Car(String brand, String year, double price) {
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Owner getOwners() {
		return owners;
	}

	public void setOwners(Owner owners) {
		this.owners = owners;
	}
}
