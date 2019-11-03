package service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyException;

import dao.imp.UserDAO;
import domain.User;
import service.IUserService;

public class UserService implements IUserService {
	public static void main(String[] args) {
		UserService test = new UserService();
		User user = new User("pujie");
		user.setPassword("poi");
		try {
			System.out.println(test.getUser(""));
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean newUser(User user) throws MyException {
		boolean state;
		if (user.getPassword() == null || user.getUsername() == null) {
			throw new MyException("username or password is null");
		}
		if (!hasUser(user.getUsername())) {
			UserDAO userDAO = new UserDAO();
			try {
				state = userDAO.addUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				throw new MyException("cannot do the add operater");
			}
		} else {
			throw new MyException("already has this username");
		}
		return state;
	}

	@Override
	public User getUser(String username) throws MyException {
		if (username == "") {
			throw new MyException("username is null");
		}
		UserDAO userDAO = new UserDAO();
		User user;
		List<User> users;
		try {
			users = userDAO.getUserByName(username);
		} catch (ClassNotFoundException | SQLException e) {
			throw new MyException("DAO get user fail");
		}
		user = users.size() == 0 ? null : users.get(0);
		return user;
	}

	@Override
	public boolean validUser(String username, String password) throws MyException {
		if (username == "" || password == "") {
			throw new MyException("username or password is null");
		}
		if (hasUser(username)) {
			UserDAO userDAO = new UserDAO();
			List<User> users;
			try {
				users = userDAO.getUserByName(username);
			} catch (ClassNotFoundException | SQLException e) {
				throw new MyException("DAO get user byname fail");
			}
			for (User user : users) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}else {
			throw new MyException("we dont have this username");
		}
		return false;
	}

	@Override
	public boolean hasUser(String username) throws MyException {
		if (username == "") {
			throw new MyException("username is null");
		}
		List<User> users = new ArrayList<>();
		UserDAO hasUser = new UserDAO();
		try {
			users = hasUser.getUserByName(username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MyException("DAO get user byname fail");
		}
		if (users.size() > 0) {
			return true;
		}
		return false;
	}

}
