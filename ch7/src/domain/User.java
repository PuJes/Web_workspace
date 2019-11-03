package domain;

import java.util.Set;

public class User {
	private String id;
	private String userName;
	private String passWord;
	private String realName;
	private String gender;
	private int age;
	private String personalSignature;
	private Set<Information> information;
	private Set<Comment> comments;

	public User() {
	}

	public User(String userName, String passWord, String realName, String gender, int age, String personalSignature) {
		this.userName = userName;
		this.passWord = passWord;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.personalSignature = personalSignature;
	}
	
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPersonalSignature() {
		return personalSignature;
	}

	public void setPersonalSignature(String personalSignature) {
		this.personalSignature = personalSignature;
	}

	public Set<Information> getInformation() {
		return information;
	}

	public void setInformation(Set<Information> information) {
		this.information = information;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", realName=" + realName
				+ ", gender=" + gender + ", age=" + age + ", personalSignature=" + personalSignature + "]";
	}

}
