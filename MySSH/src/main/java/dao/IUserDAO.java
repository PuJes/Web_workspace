package dao;

import java.util.List;

import entity.User;

public interface IUserDAO {
	public void addUser(User user);

	public User getUserById(String id);

	public void deleteUser(User user);

	public void updateUser(User user);

	public List<User> getUserByUserName(String userName);

	public List<User> getAllUser();

}
