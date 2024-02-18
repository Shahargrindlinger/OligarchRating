package com.OligarchRating.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonInformation {
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;

	public double getID() {
		return id;
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
