package domain;

import java.util.Date;

public class Comment {
	private String id;
	private String title;
	private String content;
	private Date deliveredTime;
	private User commenter;
	private Information information;

	public Comment() {

	}

	public Comment(String title, String content, Date deliveredTime, User commenter, Information information) {
		super();
		this.title = title;
		this.content = content;
		this.deliveredTime = deliveredTime;
		this.commenter = commenter;
		this.information = information;
	}
	
	public String getId() {
		return id;
	}

	protected void setId(String id) {
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

	public Date getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(Date deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	
	
	
}
