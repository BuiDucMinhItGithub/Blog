package com.blog.entity;

public class Admin {
	private String id;
	private String name;
	private String password;
	private int state;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Admin(String id, String name, String password, int state, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.state = state;
		this.role = role;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", state=" + state + ", role=" + role
				+ "]";
	}
	
	
}
