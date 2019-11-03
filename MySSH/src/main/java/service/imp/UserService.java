package service.imp;

import java.util.List;

import dao.IUserDAO;
import entity.User;
import service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
	}

	public UserService(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User user) {
		if(user==null) {
			return;
		}
		if(user.getId()!=null) {
			return;
		}
		String userName = user.getUserName();
		List<User> users = userDAO.getUserByUserName(userName);
		if(users.size()<=0) {
			userDAO.addUser(user);
		}else {
			throw new RuntimeException("该用户名已存在，请更换！");
		}
	}

	@Override
	public void delete(User user) {
		if(user==null) {
			return;
		}
		if(user.getId()==null) {
			return;
		}
		userDAO.deleteUser(user);
	}

	@Override
	public void update(User user) {
		if(user==null) {
			return;
		}
		if(user.getId()==null) {
			return;
		}
		userDAO.updateUser(user);
	}

	@Override
	public User getUserByID(String id) {
		if(id==null) {
			return null;
		}
		return userDAO.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public boolean validateUser(String userName, String password) {
		List<User> users = userDAO.getUserByUserName(userName);
		if(users !=null&users.size()!=0) {
			if(users.get(0).getPassWord().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getUserIdByName(String userName) {
		List<User> users = userDAO.getUserByUserName(userName);
		return users.get(0).getId();
	}

}
