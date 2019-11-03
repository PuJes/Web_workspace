package domain;

public class User {
	int id;
	String username;
	String password;
	String realname;
	String gender;
	int age;
	String personalSignature;

	public User(String username) {
		this.username = username;
	}

	public User(int id, String username, String password, String realname, String gender, int age,
			String personalSignature) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.gender = gender;
		this.age = age;
		this.personalSignature = personalSignature;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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
}
