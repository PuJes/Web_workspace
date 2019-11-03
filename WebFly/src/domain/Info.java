package domain;

import java.sql.Timestamp;

public class Info {
	int id;
	String title;
	String content;
	Timestamp publishingTime;
	String publishingUser;
	String type;
	public Info() {
	}
	public Info(int id, String title, String content, Timestamp publishingTime, String publishingUser, String type) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.publishingTime = publishingTime;
		this.publishingUser = publishingUser;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Timestamp getPublishingTime() {
		return publishingTime;
	}
	public void setPublishingTime(Timestamp time) {
		this.publishingTime = time;
	}
	public String getPublishingUser() {
		return publishingUser;
	}
	public void setPublishingUser(String publishingUser) {
		this.publishingUser = publishingUser;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
