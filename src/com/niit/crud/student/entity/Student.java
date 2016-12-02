package com.niit.crud.student.entity;

public class Student {
	
	//Private fields
	private int id;
	private int rollNumber;
	private int year;
	private String firstName;
	private String lastName;
	private String address;
	
	//Setters and Getters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Overriding toString() for debugging
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNumber=" + rollNumber + ", year=" + year + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + "]";
	}

}
