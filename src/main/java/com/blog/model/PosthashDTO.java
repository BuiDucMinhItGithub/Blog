package com.blog.model;

public class PosthashDTO {
	private int id;
	private String id_post;
	private String id_hashtag;
	private String post_title;
	private String hashtag_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_post() {
		return id_post;
	}
	public void setId_post(String id_post) {
		this.id_post = id_post;
	}
	public String getId_hashtag() {
		return id_hashtag;
	}
	public void setId_hashtag(String id_hashtag) {
		this.id_hashtag = id_hashtag;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getHashtag_name() {
		return hashtag_name;
	}
	public void setHashtag_name(String hashtag_name) {
		this.hashtag_name = hashtag_name;
	}
	public PosthashDTO(int id, String id_post, String id_hashtag, String post_title, String hashtag_name) {
		super();
		this.id = id;
		this.id_post = id_post;
		this.id_hashtag = id_hashtag;
		this.post_title = post_title;
		this.hashtag_name = hashtag_name;
	}
	@Override
	public String toString() {
		return "Posthash [id=" + id + ", id_post=" + id_post + ", id_hashtag=" + id_hashtag + ", post_title="
				+ post_title + ", hashtag_name=" + hashtag_name + "]";
	}
	public PosthashDTO() {
		super();
	}
}
