package com.blog.entity;


public class Hashtag {
	private String id;
	private String name;
	public Hashtag(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Hashtag() {
		super();
	}
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
	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", name=" + name + "]";
	}
	
	
}
