package com.model;

public class Player {
	private String name;
	private String email;
	private String password;
	private double phoneno;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Player() {
		super();
	}
	public Player(String name, String email, double phoneno , String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
	}
	public Player(int id,String name, String email, double phoneno , String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", email=" + email + ", password=" + password + ", phoneno=" + phoneno + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(double phoneno) {
		this.phoneno = phoneno;
	}	

}