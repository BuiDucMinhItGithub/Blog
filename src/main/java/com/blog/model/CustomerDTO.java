package com.blog.model;

public class CustomerDTO {
	private int id;
	private String name;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public CustomerDTO(int id, String name, int state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", state=" + state + "]";
	}
	public CustomerDTO() {
		super();
	}
	
}
