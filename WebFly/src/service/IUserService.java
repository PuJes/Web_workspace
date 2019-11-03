package service;

import com.MyException;

import domain.User;

public interface IUserService {
	public boolean newUser(User user) throws MyException;

	public User getUser(String id) throws MyException;

	public boolean validUser(String username, String password) throws MyException;

	public boolean hasUser(String username) throws MyException;
}
