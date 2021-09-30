package com.blog.model;

public class CommentDTO {
	private int id;
	private String name;
	private String email;
	private String date;
	private String content;
	private String id_post;
	private String name_post;
	//extend
	private int amount;
	private String month;
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public CommentDTO(int id, String name, String email, String date, String content, String id_post, String name_post,
			int amount, String month) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
		this.content = content;
		this.id_post = id_post;
		this.name_post = name_post;
		this.amount = amount;
		this.month = month;
	}
	public CommentDTO(int id, String name, String email, String date, String content, String id_post, String name_post) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
		this.content = content;
		this.id_post = id_post;
		this.name_post = name_post;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId_post() {
		return id_post;
	}
	public void setId_post(String id_post) {
		this.id_post = id_post;
	}
	public String getName_post() {
		return name_post;
	}
	public void setName_post(String name_post) {
		this.name_post = name_post;
	}
	public CommentDTO() {
		super();
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", email=" + email + ", date=" + date + ", content=" + content
				+ ", id_post=" + id_post + ", name_post=" + name_post + "]";
	}
}
	
	