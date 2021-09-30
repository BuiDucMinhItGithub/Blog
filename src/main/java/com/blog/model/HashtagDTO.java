package com.blog.model;

public class HashtagDTO {
	private String id;
	private String name;
	public HashtagDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public HashtagDTO() {
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
