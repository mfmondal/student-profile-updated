package com.mondal.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String programEnrolled;
    private String semesterEnrolled;
    private String address;
    private String city;
    private String postalCode;
       
    public Student() {}

	public Student(long id, String firstName, String lastName, String emailId, String programEnrolled,
			String semesterEnrolled, String address, String city, String postalCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.programEnrolled = programEnrolled;
		this.semesterEnrolled = semesterEnrolled;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getProgramEnrolled() {
		return programEnrolled;
	}

	public void setProgramEnrolled(String programEnrolled) {
		this.programEnrolled = programEnrolled;
	}

	public String getSemesterEnrolled() {
		return semesterEnrolled;
	}



	public void setSemesterEnrolled(String semesterEnrolled) {
		this.semesterEnrolled = semesterEnrolled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", programEnrolled=" + programEnrolled + ", semesterEnrolled=" + semesterEnrolled + ", address="
				+ address + ", city=" + city + ", postalCode=" + postalCode + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmailId()="
				+ getEmailId() + ", getProgramEnrolled()=" + getProgramEnrolled() + ", getSemesterEnrolled()="
				+ getSemesterEnrolled() + ", getAddress()=" + getAddress() + ", getCity()=" + getCity()
				+ ", getPostalCode()=" + getPostalCode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}