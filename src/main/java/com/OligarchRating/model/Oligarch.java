package com.OligarchRating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Oligarch")
public class Oligarch {
	
	
	@Id
	@Column(name="ID")
	private long id;
    
	@Column(name="FIRST_NAME")
    private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="ASSETS_VALUE")
	private double assetsValue;

	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public double getAssetsValue() {
		return assetsValue;
	}
	public void setAssetsValue(double assetsValue) {
		this.assetsValue = assetsValue;
	}
	

}
