package dao;

import java.sql.SQLException;
import java.util.List;

import domain.User;

public interface IUserDAO {
	public boolean addUser(User user) throws ClassNotFoundException, SQLException;
	public List<User> getUserByName(String username)throws ClassNotFoundException, SQLException;
	public List<User> getUserById(int id)throws ClassNotFoundException, SQLException;
	public boolean updatePswd(int id,String password)throws ClassNotFoundException, SQLException;
}
