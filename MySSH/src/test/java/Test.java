import org.hibernate.Session;

import entity.User;
import hibernate.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		
		User user = (User)session.get(User.class,"1");
		System.out.println(user.getUserName());
		System.out.println(user.getPassWord());
	}
}
