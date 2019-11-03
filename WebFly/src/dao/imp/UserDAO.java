package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IUserDAO;
import domain.User;

public class UserDAO implements IUserDAO {
	public static void main(String[] args) {
		User user = new User("nobody");
		UserDAO t = new UserDAO();
		try {
			System.out.println(t.addUser(user));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("wrong!!!!");
			e.printStackTrace();
		}
	}

	@Override
	public boolean addUser(User user) throws ClassNotFoundException, SQLException {
		String sql = "Insert into `users`(username,password,realname,gender,age,PersonalSignature) VALUES(?,?,?,?,?,?)";
		Object[] data = {user.getUsername(),user.getPassword(),user.getRealname(),user.getGender(),user.getAge(),user.getPersonalSignature()};
		DatabaseDAO mydb = new DatabaseDAO();
		int state = mydb.update(sql,data);
		mydb.releaseConnection();
		if (state == 1)
			return true;
		return false;
	}

	@Override
	public List<User> getUserByName(String username) throws ClassNotFoundException, SQLException {
		List<User> userList = new ArrayList<>();
		String sql = "select * from users where username=?;";
		Object[] data = {username};
		DatabaseDAO mydb = new DatabaseDAO();
		ResultSet res = mydb.query(sql,data);
		while(res.next()) {
			User user = new User(res.getString("username"));
			user.setPassword(res.getString("password"));
			user.setAge(res.getInt("age"));
			user.setGender(res.getString("gender"));
			user.setId(res.getInt("id"));
			user.setPassword(res.getString("password"));
			user.setPersonalSignature(res.getString("PersonalSignature"));
			user.setRealname(res.getString("realname"));
			userList.add(user);
		}
		mydb.releaseConnection();
		return userList;
	}

	@Override
	public List<User> getUserById(int id) throws ClassNotFoundException, SQLException {
		List<User> userList = new ArrayList<>();
		String sql = "select * from users where id=?;";
		Object[] data = {id};
		DatabaseDAO mydb = new DatabaseDAO();
		ResultSet res = mydb.query(sql,data);
		while(res.next()) {
			User user = new User(res.getString("username"));
			user.setPassword(res.getString("password"));
			user.setAge(res.getInt("age"));
			user.setGender(res.getString("gender"));
			user.setId(res.getInt("id"));
			user.setPassword(res.getString("password"));
			user.setPersonalSignature(res.getString("PersonalSignature"));
			user.setRealname(res.getString("realname"));
			userList.add(user);
		}
		mydb.releaseConnection();
		return userList;
	}

	@Override
	public boolean updatePswd(int id, String password) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE users SET password = ? WHERE ID = ? ";
		Object[] data = {password,id};
		DatabaseDAO mydb = new DatabaseDAO();
		int state = mydb.update(sql,data);
		mydb.releaseConnection();
		if (state == 1)
			return true;
		return false;
	}

}
