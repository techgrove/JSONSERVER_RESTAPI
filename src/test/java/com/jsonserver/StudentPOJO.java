package com.jsonserver;

import java.util.List;

public class StudentPOJO {
	public Integer id;
	public String firstname;
	public String lastname;
	public String email;
	public String programm;
	public List<String> courses;
	public StudentPOJO() {
		
	}
	public StudentPOJO(Integer id, String firstname, String lastname, String email, String programm,
			List<String> courses) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.programm = programm;
		this.courses = courses;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramm() {
		return programm;
	}
	public void setProgramm(String programm) {
		this.programm = programm;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "StudentPOJO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", programm=" + programm + ", courses=" + courses + "]";
	}
	
	

}
