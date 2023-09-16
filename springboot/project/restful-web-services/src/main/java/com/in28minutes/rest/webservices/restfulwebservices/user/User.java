package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past(message = "Birth Date should be int the past")
	private LocalDate bitrhDate;
	
	public User(Integer id, String name, LocalDate bitrhDate) {
		super();
		this.id = id;
		this.name = name;
		this.bitrhDate = bitrhDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBitrhDate() {
		return bitrhDate;
	}

	public void setBitrhDate(LocalDate bitrhDate) {
		this.bitrhDate = bitrhDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bitrhDate=" + bitrhDate + "]";
	}
	
}
