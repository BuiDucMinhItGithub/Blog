package com.blog.entity;


public class CommentChart {
	private int amount;
	private int month;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public CommentChart(int amount, int month) {
		super();
		this.amount = amount;
		this.month = month;
	}
	public CommentChart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
