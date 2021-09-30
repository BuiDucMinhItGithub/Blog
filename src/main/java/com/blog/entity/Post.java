package com.blog.entity;


public class Post {
	private String id;
	private String title;
	private String content;
	private  String author;
	private String date;
	private String img;
	private String id_category;
	private String name_category;
	//extend
	private String month;
	private int amount;
	private int soLuongBinhLuan;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	public int getSoLuongBinhLuan() {
		return soLuongBinhLuan;
	}
	public void setSoLuongBinhLuan(int soLuongBinhLuan) {
		this.soLuongBinhLuan = soLuongBinhLuan;
	}
	public Post(String id, String title, String content, String author, String date, String img, String id_category,
			String name_category, String month, int amount) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.img = img;
		this.id_category = id_category;
		this.name_category = name_category;
		this.month = month;
		this.amount = amount;
	}
	public Post(String id, String title, String content, String author, String date, String img, String id_category,
			String name_category) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.img = img;
		this.id_category = id_category;
		this.name_category = name_category;
	}
	
	
	
	
	public Post(String id, String title, String content, String author, String date, String img, String id_category,
			String name_category, int soLuongBinhLuan) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.img = img;
		this.id_category = id_category;
		this.name_category = name_category;
		this.soLuongBinhLuan = soLuongBinhLuan;
	}
	public Post(String id, String title, int soLuongBinhLuan) {
		super();
		this.id = id;
		this.title = title;
		this.soLuongBinhLuan = soLuongBinhLuan;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getId_category() {
		return id_category;
	}
	public void setId_category(String id_category) {
		this.id_category = id_category;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", date=" + date
				+ ", img=" + img + ", id_category=" + id_category + ", name_category=" + name_category + "]";
	}
	
	

}
