package com.quentin.web.jdbc;

public class Student {

	
	public int id;
	public String first_name;
	public  String last_name;
	public String email;
	
	
	public Student(int id ,String first_name,String last_name,String email)
	{
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;

	}
	public Student(String first_name,String last_name,String email)
	{
	
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;

	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + first_name + " " + last_name + " " + email + " ";
	}
	
	
	
	
	
}