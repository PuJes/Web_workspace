import dao.imp.UserDAO;
import domain.User;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		User user = new User("pujess", "87", "pujie", "male", 20, "nothing can stop me");
		userDAO.addUser(user);
	}
}
