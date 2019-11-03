package entity;

import java.util.Date;
import java.util.Set;

public class Information {
	private String id;
	private String title;
	private String content;
	private Date publishingTime;
	private String type;
	private User publishingUser;
	private Set<Comment> comments;

	public Information() {
	}

	public Information(String title, String content, Date publishingTime, String type, User publishingUser) {
		this.title = title;
		this.content = content;
		this.publishingTime = publishingTime;
		this.type = type;
		this.publishingUser = publishingUser;
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

	public Date getPublishingTime() {
		return publishingTime;
	}

	public void setPublishingTime(Date publishingTime) {
		this.publishingTime = publishingTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getPublishingUser() {
		return publishingUser;
	}

	public void setPublishingUser(User publishingUser) {
		this.publishingUser = publishingUser;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Information [title=" + title + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Information other = (Information) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
